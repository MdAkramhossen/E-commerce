package com.logrex.controller;

import com.logrex.dto.CartItemDTO;
import com.logrex.repository.CartRepository;
import com.logrex.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cart")
public class CartController {

     @Autowired
    private CartService cartService;



     @PostMapping("/post/{customerId}/{productId}/{quantity}")
     public ResponseEntity <String> addCart(@PathVariable Long customerId, @PathVariable Long  productId, @PathVariable Long quantity) {

         cartService.addCart(customerId,productId,quantity);
         return ResponseEntity.ok("added to cart") ;
     }

    @PutMapping("/update/{customerId}/{productId}/{quantity}")
    public ResponseEntity <String> updateQuantity(@PathVariable Long customerId, @PathVariable Long  productId, @PathVariable int quantity) {

        cartService.updateQuantity(customerId,productId,quantity);
        return ResponseEntity.ok("Quantity updated !") ;
    }

//// For test
     @GetMapping
    public  ResponseEntity<List<CartItemDTO>> findAllCart() {

         return ResponseEntity.ok(cartService.findAllCart());
     }

     ///Get by customer id
    @GetMapping("/{id}")
    public  ResponseEntity<Set<CartItemDTO>> findCartByCustomerId(@PathVariable Long id) {

         return ResponseEntity.ok(cartService.findCartByCustomerId(id));
    }

    @DeleteMapping("/{customerId}/{productId}")
    public ResponseEntity<String> deleteCart(@PathVariable Long customerId ,@PathVariable Long productId) {

        cartService.deleteCart(customerId , productId);
         return ResponseEntity.ok("Deleted Cart") ;
    }


}
