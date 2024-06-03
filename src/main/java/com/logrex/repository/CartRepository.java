package com.logrex.repository;

import com.logrex.entity.Brand;
import com.logrex.entity.CartItem;
import com.logrex.entity.Customer;
import com.logrex.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {

    public List<CartItem> findByCustomer(Customer customer);
    public CartItem findByCustomerAndProduct(Customer customer, Product product);

    Set<CartItem> findByCustomerId(Long id);

    Optional<CartItem> findByProductId(Long id);

    Optional<CartItem> findByCustomerIdAndProductId(Long customerId, Long productId);


}
