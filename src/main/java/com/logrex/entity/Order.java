package com.logrex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address-line_2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

   private Date orderDate;
   private float shippingCost;
   private float productCost;

   private float subtotal;
   private float tax;
   private float total;

   private  int delivaryDays;

   private  Date deliveryDate;
//   @Enumerated(EnumType.STRING)
//private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

@ManyToOne
@JoinColumn(name = "customer_id")
  private Customer customer;

@OneToMany
@JoinColumn(name = "order_id",referencedColumnName = "id")
private Set<OrderDetails> orderDetails = new HashSet<>();



}
