package com.logrex.service.impl;

import com.logrex.controller.CatagoryController;
import com.logrex.dto.CatagoryDTO;
import com.logrex.entity.Catagory;
import com.logrex.entity.Product;
import com.logrex.exceptions.NotFoundExceptions;
import com.logrex.repository.CatagoryRepository;
import com.logrex.repository.ProductRepository;
import com.logrex.service.CatagoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CatagoryImpl implements CatagoryService {

    @Autowired
    ModelMapper modelMapper ;

    @Autowired
    CatagoryRepository catagoryRepository ;
    @Autowired
    ProductRepository productRepository ;
    @Override
    public void postCatagory(CatagoryDTO catagory) {

        Catagory catagory1 = modelMapper.map(catagory, Catagory.class);

        catagoryRepository.save(catagory1);


    }

    @Override
    public List<CatagoryDTO> getCatagory() {

        List<Catagory> catagoryList = catagoryRepository.findAllParentCategories();
        List<CatagoryDTO> catagoryDTOList = catagoryList.stream().map(catagory ->modelMapper.map(catagory,CatagoryDTO.class)).collect(Collectors.toList());

        return catagoryDTOList;
    }

    @Override
    public void deleteById(Long id) {

        catagoryRepository.deleteById(id);
    }

    @Override
    public CatagoryDTO getCatagoryById(Long id) {

        Catagory catagory= catagoryRepository.findById(id).get();

        return modelMapper.map(catagory,CatagoryDTO.class);
    }
}
