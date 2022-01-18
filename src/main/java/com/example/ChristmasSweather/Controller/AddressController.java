package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/Address")
    public @ResponseBody String addAddress(){

        return "saved";
    }

}
