package com.logrex.service;

import com.logrex.dto.CartItemDTO;

import java.util.Set;

public interface CheckOutService {
    Set<CartItemDTO> findCartByCustomerId(Long id);
}
