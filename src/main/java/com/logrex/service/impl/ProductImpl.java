package com.logrex.service.impl;

import com.logrex.dto.ProductDTO;
import com.logrex.entity.Product;
import com.logrex.repository.ProductRepository;
import com.logrex.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
     private ModelMapper modelMapper;


    @Override
    public void postProduct(ProductDTO productDTO) {
      Product product = modelMapper.map(productDTO, Product.class);
     //   System.out.println(product.getCatagory().getId());
          productRepository.save(product);

    }

    @Override
    public void putProduct(ProductDTO productDTO) {

        Product product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);

    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
        return productDTOs;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return  modelMapper.map(productRepository.findById(id), ProductDTO.class);
    }

    @Override
    public void productService(List<ProductDTO> productDTOList) {

         List<Product> allProducts= productDTOList.stream().map(productDTO -> modelMapper.map(productDTO, Product.class)).collect(Collectors.toList());
         productRepository.saveAll(allProducts);

    }
}
