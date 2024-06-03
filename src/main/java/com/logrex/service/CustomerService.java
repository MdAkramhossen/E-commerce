package com.logrex.service;

import com.logrex.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDTO customerDTO);

    ResponseEntity<List<CustomerDTO>> getAllCustomers();
}
