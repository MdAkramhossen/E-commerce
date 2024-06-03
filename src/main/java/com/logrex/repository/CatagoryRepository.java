package com.logrex.repository;

import com.logrex.entity.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatagoryRepository extends JpaRepository<Catagory, Long> {

    @Query("SELECT c FROM Catagory c WHERE c.parent IS NULL")
    List<Catagory> findAllParentCategories();

}
