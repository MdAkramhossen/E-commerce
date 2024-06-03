package com.logrex.dto;

import com.logrex.entity.Order;
import com.logrex.entity.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderDetailDTO {

    private int id;

    private int quantity;
    private  float productCost;
    private  float shippingCost;
    private  float unitPrice;
    private  float subTotal;
    private Product product;
    private Order order;
}
