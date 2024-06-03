package com.logrex.repository;

import com.logrex.entity.Customer;
import com.logrex.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    UserDetails findByEmail(String username);
}
