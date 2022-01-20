package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.Account;
import com.example.ChristmasSweather.DAO.AccountDao;
import com.example.ChristmasSweather.Models.Address;
import com.example.ChristmasSweather.Models.Role;
import com.example.ChristmasSweather.RequestObject.AccountRequestObject;
import com.example.ChristmasSweather.RequestObject.AccountReturnObject;
import com.example.ChristmasSweather.RequestObject.RoleUserRequestObject;
import com.example.ChristmasSweather.jwt.JwtRequest;
import com.example.ChristmasSweather.jwt.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AccountController {
    @Autowired
    private AccountDao accountDao;

    @PostMapping("/authenticate")
    public HTTPResponse<UserResponse> createAuthToken(@RequestBody JwtRequest authenticationRequest) {
        return accountDao.authenticate(authenticationRequest);
    }

    @PostMapping("/register")
    public HTTPResponse<AccountReturnObject> registerAccount(@RequestBody AccountRequestObject o) {
        Address a = new Address(o.getCity(),o.getCountry(),o.getStreet(),o.getNumber(),o.getExtra());
        return accountDao.registerAccount(o.getFirstName(), o.getLastName(), o.getEmail(), o.getPassword(), a);
    }

    @PostMapping("/role/save")
    public HTTPResponse<Role> saveRole(@RequestBody Role role) {
        return accountDao.saveRole(role);
    }

    @PostMapping("/role/addtouser")
    public HTTPResponse<String> addRoleRoUser(@RequestBody RoleUserRequestObject form) {
        return accountDao.addRoleToUser(form.getEmail(), form.getRoleName());
    }

    @PostMapping("/role/removefromuser")
    public HTTPResponse<String> removeRoleFromUser(@RequestBody RoleUserRequestObject form) {
        return accountDao.removeRoleFromUser(form.getEmail(), form.getRoleName());
    }

    @GetMapping("/account")
    public HTTPResponse<AccountReturnObject> getAccountDetails(@RequestParam(name="id", defaultValue="") String id, @RequestParam(name="email", defaultValue = "") String email) {
        // todo make sure top check if this is the account thats logged in!!!
        if (id.equals(""))
            return accountDao.getIdBelongingToEmail(email);
        return accountDao.getAccountDetails(id);
    }

    @PutMapping("/account/mod")
    public HTTPResponse<Account[]> changeAccount(@RequestBody Account[] accounts) {
        if (accounts.length == 2) {
            return accountDao.changeAccount(accounts);
        }
        return HTTPResponse.<AccountReturnObject>returnFailure("input length is not 2");
    }

    @GetMapping("/account/mod")
    public HTTPResponse<List<AccountReturnObject>> getAllMods(){
        return accountDao.getAllMods();
    }

    @PostMapping("/account/mod")
    public HTTPResponse<AccountReturnObject> createMod(@RequestBody AccountRequestObject acc){
        return accountDao.createMod(acc);
    }
}
