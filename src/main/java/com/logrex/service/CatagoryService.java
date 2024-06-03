package com.logrex.service;

import com.logrex.dto.CatagoryDTO;

import java.util.List;

public interface CatagoryService {
    void postCatagory(CatagoryDTO catagory);

    List<CatagoryDTO> getCatagory();

    void deleteById(Long id);

    CatagoryDTO getCatagoryById(Long id);
}
