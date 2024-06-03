package com.logrex.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;


    private String email;


    private String password;


    private String firstName;


    private String lastName;


    private String phoneNumber;


    private String addressLine1;


    private String addressLine2;


    private String city;


    private String state;


    private String postalCode;


    private String country;

    protected Time creationTime;
    private boolean enable;


}
