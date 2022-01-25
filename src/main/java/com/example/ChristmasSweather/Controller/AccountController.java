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
}
