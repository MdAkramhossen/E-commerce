package com.logrex.dto;

import com.logrex.entity.Catagory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BrandDTO {


    private Long id;

    private String name;


    private String image;

    //Set<Catagory> categories;

}
