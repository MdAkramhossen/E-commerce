package com.logrex.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false,name = "product_name")
    private String name;

    @Column( name = "short_desxription")
    private String shortDesxription;


    @Column( name = "full_description")
    private String fullDescription;

    @Column( name = "main_image")
    private String mainImage;

    @Column( name = "created_time")
    private Date createdTime;

    @Column( name = "updated_time")
    private Date updatedTime;

    private  boolean enable ;

    private  boolean instock;

    @Column( name = "price")
    private double price;

    @Column( name = "discount")
    private double discount;

    @Column( name = "length")
    private double length;

    @Column( name = "width")
    private double width;

    @Column( name = "height")
    private double height;

    @Column( name = "avg_rating")
    private double avgRating;

    @Column( name = "review_count")
    private int reviewCount;

    @Column( name = "cost")
    private double cost;

//    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
//    @JsonBackReference
//    @JoinColumn(name = "brand_id")
//    private Brand brand;
//
    @ManyToOne
    //@JoinColumn(name = "catagory_id")
    @JsonBackReference
    private Catagory catagory;



}
