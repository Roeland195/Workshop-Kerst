package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Models.Address;
import com.example.ChristmasSweather.Reposetory.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/Address")
    public @ResponseBody String addAddress(){

        Address address = new Address("katwijk","Netherlands","Boerslaan",31,"none");
        addressRepository.save(address);
        return "saved";
    }

}
