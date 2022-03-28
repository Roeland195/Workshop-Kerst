package com.example.ChristmasSweather.DAO;

import com.example.ChristmasSweather.Models.Address;
import com.example.ChristmasSweather.Repository.AccountRepository;
import com.example.ChristmasSweather.Repository.AddressRepository;
import com.example.ChristmasSweather.Repository.RoleRepo;
import com.example.ChristmasSweather.jwt.JwtTokenUtil;
import com.example.ChristmasSweather.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.Account;
import com.example.ChristmasSweather.Models.Role;
import com.example.ChristmasSweather.RequestObject.AccountRequestObject;
import com.example.ChristmasSweather.RequestObject.AccountReturnObject;
import com.example.ChristmasSweather.jwt.*;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AccountDao {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private RoleRepo roleRepo;

    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    public Account getByEmail(String email) {
        Optional<Account> acc = accountRepository.findByEmail(email);
        if (acc.isEmpty()) return null;
        else return acc.get();
    }
    public HTTPResponse<AccountReturnObject> getIdBelongingToEmail(String email) {
        Optional<Account> account = accountRepository.findByEmail(email);
        if (account.isEmpty())
            return HTTPResponse.<AccountReturnObject>returnFailure("could not find account with that email");
        AccountReturnObject obj = new AccountReturnObject(account.get());
        return HTTPResponse.<AccountReturnObject>returnSuccess(obj);
    }


    public HTTPResponse<Role> saveRole(Role role) {
        roleRepo.save(role);
        return HTTPResponse.<Role>returnSuccess(role);
    }

    public HTTPResponse<String> addRoleToUser(String email, String roleName) {
        Optional<Account> user = accountRepository.findByEmail(email);
        if (user.isEmpty())
            return HTTPResponse.returnFailure("user does not exist");

        Role role = roleRepo.findByName(roleName);
        if (role == null)
            return HTTPResponse.returnFailure("role does not exist");

        user.get().getRoles().add(role);
        accountRepository.save(user.get());

        return HTTPResponse.<String>returnSuccess("Role is safed to user");
    }

    public HTTPResponse<String> removeRoleFromUser(String email, String roleName) {
        Optional<Account> user = accountRepository.findByEmail(email);
        if (user.isEmpty())
            return HTTPResponse.returnFailure("user does not exist");

        Role role = roleRepo.findByName(roleName);
        if (role == null)
            return HTTPResponse.returnFailure("role does not exist");

        boolean result = user.get().getRoles().remove(role);
        if (result == false)
            return HTTPResponse.returnFailure("user does not have role");

        accountRepository.save(user.get());

        return HTTPResponse.<String>returnSuccess("Role is removed from user");
    }


    public HTTPResponse<AccountReturnObject> getAccountDetails(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty())
            return HTTPResponse.returnFailure("could not find account with id: " + id);
        return HTTPResponse.returnSuccess(new AccountReturnObject(account.get()));
    }

    public HTTPResponse<Account[]> changeAccount(Account[] accounts) {
        Account old = accounts[0];
        Account newObject = accounts[1];
        Optional<Account> account = accountRepository.findById(old.getId());
        if (account.isEmpty()) {
            return HTTPResponse.returnFailure("could not find account with id: " + old.getId());
        }
        newObject.setId(old.getId());

        accountRepository.save(newObject);
        return HTTPResponse.returnSuccess(accounts);
    }

    public HTTPResponse<List<AccountReturnObject>> getAllMods(){
        List<Account> accs = accountRepository.findByRoles_name(RoleNames.MOD.getValue());
        List<AccountReturnObject> returnValues = new ArrayList<AccountReturnObject>();
        for (Account a : accs) {
            returnValues.add(new AccountReturnObject(a));
        }
        return HTTPResponse.returnSuccess(returnValues);
    }

    public HTTPResponse<AccountReturnObject> createMod(AccountRequestObject acc){
        HTTPResponse<AccountReturnObject> r = registerAccount(acc);
        if (!r.isSuccess())
            return r;
        String email = r.getData().getEmail();
        addRoleToUser(email, RoleNames.MOD.getValue());
        return HTTPResponse.returnSuccess(r.getData());
    }

    public HTTPResponse<AccountReturnObject> registerAccount(AccountRequestObject o) {
        Address address = new Address(o.getCity(),o.getCountry(),o.getStreet(),o.getNumber(),o.getExtra());
        if (o.getEmail().equals("") || o.getPassword().equals(""))
            return HTTPResponse.<AccountReturnObject>returnFailure("one ore more required parameters were empty");
        else if (accountRepository.findByEmail(o.getEmail()).isPresent())
            return HTTPResponse.<AccountReturnObject>returnFailure("that email already exists: " + o.getEmail());

        String hashedPassword = userDetailsService.getHashedPassword(o.getPassword());
        Address addresses = new Address(address.getCity(),address.getCountry(),address.getStreet(),address.getNumber(),address.getAddons());
        Account a = new Account(o.getFirstName(), o.getLastName(), o.getEmail(), hashedPassword);
        addressRepository.save(addresses);
        a.getAddresses().add(addresses);

        Role role = roleRepo.findByName("USER");

        a.getRoles().add(role);
        accountRepository.save(a);

        return HTTPResponse.<AccountReturnObject>returnSuccess(new AccountReturnObject(a));
    }

    /** authenticates an account
     * @param authenticationRequest the data to authenticate with
     * @return failure or success
     */
    public HTTPResponse<UserResponse> authenticate(JwtRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (DisabledException e) {
            return HTTPResponse.<UserResponse>returnUserDisabled("user: " + authenticationRequest.getUsername() + " is disabled");
        } catch (BadCredentialsException e) {
            return HTTPResponse.<UserResponse>returnInvalidCredentials("");

        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        final Account user = accountRepository.findByEmail(authenticationRequest.getUsername()).get();
        return returnToken(token, user);
    }

    public HTTPResponse<UserResponse> returnToken(String response, Account account) {
        UserResponse userDetails = new UserResponse(account.getEmail(), account.getFirstName(), account.getLastName(), response);
        return HTTPResponse.<UserResponse>returnSuccess(userDetails);
    }
}