package com.logrex.service;

import com.logrex.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void postProduct(ProductDTO productDTO);

    void putProduct(ProductDTO productDTO);

    void deleteById(Long id);

    List<ProductDTO> getProduct();

    ProductDTO getProductById(Long id);

    void productService(List<ProductDTO> productDTOList);
}
