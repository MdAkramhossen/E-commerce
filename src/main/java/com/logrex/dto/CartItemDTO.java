package com.logrex.dto;

import com.logrex.entity.Customer;
import com.logrex.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class CartItemDTO {



    private Long id;


    private Product product;


    private Customer customer;

    private  int quantity;
}
