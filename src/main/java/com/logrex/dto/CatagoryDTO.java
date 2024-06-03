package com.logrex.dto;

import com.logrex.entity.Brand;
import com.logrex.entity.Catagory;
import com.logrex.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CatagoryDTO {


    private Long id;


    private String name;



    private String alias;


    private String image;


    private boolean enabled = true;

    private Set<Product> products = new HashSet<>();

    private Catagory parent;


    Set<Catagory> children = new HashSet<>();
    //private Set<Brand> brands;
}
