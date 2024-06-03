package com.logrex.controller;

import com.logrex.dto.BrandDTO;
import com.logrex.dto.CatagoryDTO;
import com.logrex.dto.ProductDTO;
import com.logrex.service.BrandService;
import com.logrex.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

   @Autowired
   private ProductService productService;

    @PostMapping
     public ResponseEntity<String>  postProduct(@RequestBody ProductDTO productDTO) {

        productDTO.setId(0L);
        productService.postProduct(productDTO);
         return ResponseEntity.ok("successful !");
    }

    @PostMapping("createallproduct")
    public ResponseEntity<String> createAllProduct(@RequestBody List<ProductDTO> productDTOList) {
        productService.productService(productDTOList);
        return ResponseEntity.ok("successful !");
    }

    @PutMapping()
    public ResponseEntity<String>  putProduct( @RequestBody  ProductDTO productDTO) {


        productService.putProduct(productDTO);
        return ResponseEntity.ok("successfuly updated !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteById(@PathVariable Long id) {


        productService.deleteById(id);
        return ResponseEntity.ok("successfuly deleted !");
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProduct() {

        return ResponseEntity.ok(productService.getProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {

        return ResponseEntity.ok(productService.getProductById(id));
    }


}
