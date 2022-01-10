package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Reposetory.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
