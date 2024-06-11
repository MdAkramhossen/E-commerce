package com.logrex.repository;

import com.logrex.entity.Customer;
import com.logrex.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer>  findByEmail(String username);
   /// Customer findByEmail(String email);
}
