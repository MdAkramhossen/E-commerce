package com.logrex.service.impl;

import com.logrex.dto.BrandDTO;
import com.logrex.dto.CatagoryDTO;
import com.logrex.entity.Brand;
import com.logrex.repository.BrandRepository;
import com.logrex.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public void postBrand(BrandDTO brandDTO) {

        Brand brand = modelMapper.map(brandDTO, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void deleteById(Long id) {

       brandRepository.deleteById(id);
    }

    @Override
    public List<BrandDTO> getCatagory() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandDTO> brandDTOs= brands.stream().map(brand -> modelMapper.map(brand, BrandDTO.class)).collect(Collectors.toList());
        return brandDTOs;
    }

    @Override
    public CatagoryDTO getBrandById(Long id) {
        return  modelMapper.map(brandRepository.findById(id).get(), CatagoryDTO.class);
    }
}
