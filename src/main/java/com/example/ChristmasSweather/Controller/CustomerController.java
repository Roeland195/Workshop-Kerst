package com.example.ChristmasSweather.Controller;

import com.example.ChristmasSweather.Models.Customer;
import com.example.ChristmasSweather.Reposetory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/User")
    public @ResponseBody String addCustomer(@RequestParam String name,
                @RequestParam String email){

        Customer customer = new Customer(name, email);
        customerRepository.save(customer);
        return "saved";
    }

    @GetMapping("/User")
    public Iterable<Customer> getAllUsers(@RequestParam(name="name", defaultValue = "") String name){
        if(!name.equals("")){
            List<Customer> data = customerRepository.findByName(name);
            return data;
        }
        List<Customer> data = customerRepository.findAll();
        if(data.isEmpty()) return null;
        return data;
    }
}
