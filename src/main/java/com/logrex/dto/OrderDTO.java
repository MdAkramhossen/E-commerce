package com.logrex.dto;

import com.logrex.entity.Customer;
import com.logrex.entity.OrderDetails;
import com.logrex.entity.OrderStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO {

    private int id;



    private String firstName;


    private String lastName;


    private String phoneNumber;


    private String addressLine1;


    private String addressLine2;


    private String city;


    private String state;


    private String postalCode;


    private String country;

    private Date orderDate;
    private float shippingCost;
    private float productCost;

    private float subtotal;
    private float tax;
    private float total;

    private  int delivaryDays;

    private  Date deliveryDate;

    private OrderStatus status;


    private Customer customer;


    private Set<OrderDetails> orderDetails = new HashSet<>();
}
