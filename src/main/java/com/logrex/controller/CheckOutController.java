package com.logrex.controller;

import com.logrex.dto.CartItemDTO;
import com.logrex.entity.CheckOutInfo;
import com.logrex.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/checkout")
public class CheckOutController {

    @Autowired
    CheckOutService checkOutService;

//    @GetMapping("/{id}")
//    public ResponseEntity<Set<CartItemDTO>> findCartByCustomerId(@PathVariable Long id) {
//
//        return ResponseEntity.ok(checkOutService.findCartByCustomerId(id));
//    }




}
