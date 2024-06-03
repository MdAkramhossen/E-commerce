package com.logrex.service;

import com.logrex.dto.CartItemDTO;

import java.util.List;
import java.util.Set;

public interface CartService {
    void addCart(Long customerId, Long productId, Long quantity);

    List<CartItemDTO> findAllCart();

    Set<CartItemDTO> findCartByCustomerId(Long id);



    void updateQuantity(Long customerId, Long productId, int quantity);

    void deleteCart(Long customerId, Long productId);
}
