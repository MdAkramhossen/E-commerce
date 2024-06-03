package com.logrex.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false,name = "brand_name")
    private String name;

    @Column(name = "image_url")
    private String image;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "brand_category",
            joinColumns = { @JoinColumn(name = "brand_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    @JsonManagedReference
    private Set<Catagory> categories = new HashSet<>();


//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "brand")
//    @JsonManagedReference
//   List<Product> products;

}
