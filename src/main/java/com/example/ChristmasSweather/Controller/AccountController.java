package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.HTTPResponse;
import com.example.ChristmasSweather.Models.Account;
import com.example.ChristmasSweather.Models.Address;
import com.example.ChristmasSweather.Reposetory.AccountRepository;
import com.example.ChristmasSweather.RequestObject.AccountRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/Register")
    public HTTPResponse registerAccount(@RequestBody AccountRequestObject object){
        System.out.println(object.getName());
        if(object.getName().equals("") || object.getEmail().equals("") || object.getPassword().equals("")){
            return HTTPResponse.<AccountRequestObject>returnFailure("Niet alles is ingevuld");
        }else if (accountRepository.findByEmail(object.getEmail()).isPresent()){
            return HTTPResponse.<AccountRequestObject>returnFailure("Dit email address bestaat al.");
        }
        Address address = new Address(object.getCity(), object.getCountry(), object.getStreet(), object.getNumber(), object.getExtra());
        Account account = new Account(object.getName(), object.getEmail(),object.getPassword(), (Set<Address>) address);
        accountRepository.save(account);
        return HTTPResponse.returnSuccess(account);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/User")
    public Iterable<Account> getAllUsers(@RequestParam(name="name", defaultValue = "") String name){
        if(!name.equals("")){
            List<Account> data = accountRepository.findByName(name);
            return data;
        }
        List<Account> data = accountRepository.findAll();
        if(data.isEmpty()) return null;
        return data;
    }
}
