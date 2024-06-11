package com.logrex.controller;

import com.logrex.dto.CustomerDTO;
import com.logrex.entity.Customer;
import com.logrex.repository.CustomerRepository;
import com.logrex.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
CustomerRepository customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder ;

//    @PostMapping("/resister")
//    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customerDTO) {
//
//        customerService.createCustomer(customerDTO);
//
//        return  ResponseEntity.ok("Customer created");
//    }

        @PostMapping("/resister")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {

            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customerRepository.save(customer);

        return  ResponseEntity.ok("Customer created");
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {


        return  customerService.getAllCustomers();
    }



}
