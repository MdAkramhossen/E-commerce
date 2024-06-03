package com.logrex.service.impl;

import com.logrex.dto.CartItemDTO;
import com.logrex.entity.CartItem;
import com.logrex.repository.CartRepository;
import com.logrex.service.CheckOutService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CheckOutInfoImpl implements CheckOutService {

   @Autowired
    private CartRepository cartRepository;

    @Autowired
   ModelMapper modelMapper;

    @Override
    public Set<CartItemDTO> findCartByCustomerId(Long id) {

        Set<CartItem> cartItems=cartRepository.findByCustomerId(id);
        float totalPrice= calculateTotalProductPrice(cartItems);
        Set<CartItemDTO> cartItemDTOS =  cartItems.stream().map(cartItem -> modelMapper.map(cartItem, CartItemDTO.class)).collect(Collectors.toSet());
        return cartItemDTOS;
    }

    private float calculateTotalProductPrice(Set<CartItem> cartItems) {

        float totalProductPrice=0.0f,totalDiscountPrice=0.0f;

        for (CartItem cartItem : cartItems){

              totalProductPrice+= cartItem.getQuantity()*cartItem.getProduct().getPrice();
            totalDiscountPrice+=cartItem.getQuantity()*cartItem.getProduct().getDiscount();

        }
        System.out.println(totalProductPrice+"total discount"+totalDiscountPrice);
        return 0;
    }
}
