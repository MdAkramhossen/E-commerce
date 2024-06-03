package com.logrex.service.impl;

import com.logrex.dto.CartItemDTO;
import com.logrex.entity.CartItem;
import com.logrex.entity.Customer;
import com.logrex.entity.Product;
import com.logrex.repository.CartRepository;
import com.logrex.repository.CustomerRepository;
import com.logrex.repository.ProductRepository;
import com.logrex.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCart(Long customerId, Long productId, Long quantity) {

       Customer customer = customerRepository.findById(customerId).get();
        Product product = productRepository.findById(productId).get();
        Optional<CartItem> cartItem = cartRepository.findByProductId(productId);

           if (cartItem.isPresent()) {

               throw new RuntimeException("Product already exist in the cart Item !: " + productId);
           }

          CartItem cartItem1 = new CartItem();
        cartItem1.setProduct(product);
        cartItem1.setCustomer(customer);
        cartItem1.setQuantity(quantity.intValue());
        cartRepository.save(cartItem1);

        }



    @Override
    public List<CartItemDTO> findAllCart() {

        List<CartItem> cartItems = cartRepository.findAll();

        List<CartItemDTO> cartItemDTOS = cartItems.stream().map(cartItem -> modelMapper.map(cartItem, CartItemDTO.class)).collect(Collectors.toList());
        return cartItemDTOS;

    }

    @Override
    public Set<CartItemDTO> findCartByCustomerId(Long id) {

        Set<CartItem> cartItems=cartRepository.findByCustomerId(id);
        Set<CartItemDTO> cartItemDTOS =  cartItems.stream().map(cartItem -> modelMapper.map(cartItem, CartItemDTO.class)).collect(Collectors.toSet());
        return cartItemDTOS;
    }




    @Override
    public void updateQuantity(Long customerId, Long productId, int quantity) {

        Optional<CartItem> cartItems= cartRepository.findByCustomerIdAndProductId(customerId,productId);

        cartItems.ifPresentOrElse(
                cartItem -> {
                    cartItem.setQuantity(quantity);
                    cartRepository.save(cartItem);
                },
                () -> {
                    throw new RuntimeException("CartItem not found for customerId: " + customerId + " and productId: " + productId);
                }
        );

    }

    @Override
    public void deleteCart(Long customerId, Long productId) {

        Optional<CartItem> cartItems= cartRepository.findByCustomerIdAndProductId(customerId,productId);
        cartItems.ifPresentOrElse(
                cartItem -> {
                    cartRepository.delete(cartItem);
                },
                ()->{
                    throw new RuntimeException("CartItem not found for customerId: " + customerId + " and productId: " + productId);
                }
        );
    }

}
