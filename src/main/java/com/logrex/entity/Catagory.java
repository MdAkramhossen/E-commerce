package com.logrex.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "catagories")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50,nullable = false,name = "name")
    private String name;


    @Column(length = 500,name = "alias")
    private String alias;

    @Column(length = 500,name = "image")
    private String image;

    @Column
   private boolean enabled = true;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parent_id")
  private  Catagory parent;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "parent")
    Set<Catagory> children = new HashSet<>();


@ManyToMany(mappedBy = "categories")
@JsonBackReference
private Set<Brand> brands = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "catagory_id",referencedColumnName = "id")
    @JsonManagedReference
     private Set<Product> products = new HashSet<>();
}
