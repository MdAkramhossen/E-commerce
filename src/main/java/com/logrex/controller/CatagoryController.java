package com.logrex.controller;

import com.logrex.dto.CatagoryDTO;
import com.logrex.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catagory")
public class CatagoryController {

   @Autowired
   private CatagoryService catagoryService;

    @PostMapping("")
     public ResponseEntity<String>  postCatagory(@RequestBody CatagoryDTO catagory) {

            catagory.setId(0L);
         catagoryService.postCatagory(catagory);
         return ResponseEntity.ok("successful !");
    }


    @PutMapping()
    public ResponseEntity<String>  putCatagory( @RequestBody CatagoryDTO catagory) {


        catagoryService.postCatagory(catagory);
        return ResponseEntity.ok("successfuly updated !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteById(@PathVariable Long id) {


        catagoryService.deleteById(id);
        return ResponseEntity.ok("successfuly deleted !");
    }

    @GetMapping
    public ResponseEntity<List<CatagoryDTO>> getCatagory() {

        return ResponseEntity.ok(catagoryService.getCatagory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatagoryDTO> getCatagoryById(@PathVariable Long id) {

        return ResponseEntity.ok(catagoryService.getCatagoryById(id));
    }


}
