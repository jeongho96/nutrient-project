package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.ExcelDTO;
import com.food.dto.ExcelSearchDTO;
import com.food.service.ExcelService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/excel")
public class ApiController {

	@Autowired
    private ExcelService excelService;


    @GetMapping("/search")
    public List<ExcelDTO> searchExcelData(@ModelAttribute ExcelSearchDTO searchDTO) {

//    	List<ExcelDTO> excelData = excelService.getExcelData(
//                searchDTO.getFoodCd(),
//                searchDTO.getFoodName(),
//                searchDTO.getResearchYear(),
//                searchDTO.getMakerName()
//            );
    	
    	List<ExcelDTO> excelData = excelService.getExcelData(searchDTO);
    	log.info("검색 확인");
        return excelData;
    }
}
