package com.logrex.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_items")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
   private  Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id")
   private Customer customer;

   private  int quantity;
}
