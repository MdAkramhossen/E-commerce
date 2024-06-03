package com.logrex.controller;

import com.logrex.dto.BrandDTO;
import com.logrex.dto.CatagoryDTO;
import com.logrex.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

   @Autowired
   private BrandService brandService;

    @PostMapping
     public ResponseEntity<String> postBrand(@RequestBody BrandDTO brandDTO) {

        brandDTO.setId(0L);
        brandService.postBrand(brandDTO);
         return ResponseEntity.ok("successful !");
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteById(@PathVariable Long id) {


        brandService.deleteById(id);
        return ResponseEntity.ok("successfuly deleted !");
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getBrand() {

        return ResponseEntity.ok(brandService.getCatagory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatagoryDTO> getBrandById(@PathVariable Long id) {

        return ResponseEntity.ok(brandService.getBrandById(id));
    }


}
