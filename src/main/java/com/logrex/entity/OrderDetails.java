package com.logrex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private int quantity;
    private  float productCost;
    private  float shippingCost;
    private  float unitPrice;
    private  float subTotal;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    private Order order;

}
