package com.logrex.controller;

import com.logrex.dto.CustomerDTO;
import com.logrex.entity.Customer;
import com.logrex.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customerDTO) {

        customerService.createCustomer(customerDTO);

        return  ResponseEntity.ok("Customer created");
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {


        return customerService.getAllCustomers();
    }



}
