package com.logrex.service.impl;

import com.logrex.dto.CatagoryDTO;
import com.logrex.dto.CustomerDTO;
import com.logrex.entity.Customer;
import com.logrex.helper.AppConstants;
import com.logrex.repository.CustomerRepository;
import com.logrex.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void createCustomer(CustomerDTO customerDTO) {

       Customer customer = modelMapper.map(customerDTO, Customer.class);
       List<Customer> checkCustomer=customerRepository.findByEmail(customer.getEmail());
         if(checkCustomer.get(0)!=null){
             throw new RuntimeException("Already resisterds");

         }
       customerRepository.save(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = customers.stream().map(cs ->modelMapper.map(cs, CustomerDTO.class)).collect(Collectors.toList());
        return customerDTOList;
    }


}

