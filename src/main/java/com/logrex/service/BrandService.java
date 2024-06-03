package com.logrex.service;

import com.logrex.dto.BrandDTO;
import com.logrex.dto.CatagoryDTO;

import java.util.List;

public interface BrandService {

    void postBrand(BrandDTO brandDTO);

    void deleteById(Long id);

    List<BrandDTO> getCatagory();

    CatagoryDTO getBrandById(Long id);
}
