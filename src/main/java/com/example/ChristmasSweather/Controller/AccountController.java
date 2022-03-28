package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.DAO.AccountDao;
import com.example.ChristmasSweather.Models.Role;
import com.example.ChristmasSweather.Repository.RoleRepo;
import com.example.ChristmasSweather.RequestObject.AccountRequestObject;
import com.example.ChristmasSweather.RequestObject.AccountReturnObject;
import com.example.ChristmasSweather.jwt.JwtRequest;
import com.example.ChristmasSweather.jwt.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private RoleRepo roleRepo;

    @PostMapping("/authenticate")
    public HTTPResponse<UserResponse> createAuthToken(@RequestBody JwtRequest authenticationRequest) {
        return accountDao.authenticate(authenticationRequest);
    }

    @PostMapping("/register")
    public HTTPResponse<AccountReturnObject> registerAccount(@RequestBody AccountRequestObject o) {
        return accountDao.registerAccount(o);
    }

    @PostMapping("/addRole")
    public HTTPResponse<Role> addRole(@RequestBody String name){
        Role role = new Role(name);
        roleRepo.save(role);
        return HTTPResponse.returnSuccess(role);
    }
}
