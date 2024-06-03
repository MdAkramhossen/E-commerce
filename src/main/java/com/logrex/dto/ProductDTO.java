package com.logrex.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.logrex.entity.Brand;
import com.logrex.entity.Catagory;
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
public class ProductDTO {

    private Long id;

    private String name;


    private String shortDesxription;

    private String fullDescription;


    private String mainImage;

    private Date createdTime;
    private Date updatedTime;

    private  boolean enable ;

    private  boolean instock;


    private double price;


    private double discount;


    private double length;


    private double width;


    private double height;


    private double avgRating;


    private int reviewCount;


    private double cost;


//    private Brand brand;
//

    private Catagory catagory;


}
