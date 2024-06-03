package com.logrex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CheckOutInfo {

    private float productCost;
    private float productTotal;
    private  float shippingCostTotal;
    private  float paymentTotal;
    private Date deliverDate;
    private  boolean codSupported;

}
