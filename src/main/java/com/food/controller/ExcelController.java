package com.food.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.food.dto.ExcelDTO;
import com.food.dto.ExcelSearchDTO;
import com.food.service.ExcelServiceImpl;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ExcelController {
	
	@Autowired
	private ExcelServiceImpl excelService;
	
	@GetMapping("/excel/input")
	public String excelInputView() {
		return "excelInput";
	}
	
	@PostMapping("/excel/input")
	public String excelInput(@RequestParam(value = "justFileName", required = false) MultipartFile file) {
		excelService.insertExcelFile(file);
		return "success";
		
	}
	
	@GetMapping("/excel")
	public String showExcelData(@ModelAttribute("searchDTO") ExcelSearchDTO searchDTO, Model model) {
		    // 검색 폼에서 입력된 값으로 데이터를 조회합니다.
//		List<ExcelDTO> excelData = excelService.getExcelData(
//	            searchDTO.getFoodCd(),
//	            searchDTO.getFoodName(),
//	            searchDTO.getResearchYear(),
//	            searchDTO.getMakerName()
//	        );
			List<ExcelDTO> excelData = excelService.getExcelData(searchDTO);
			log.info("화면 검색");

		    model.addAttribute("excelData", excelData);
		    return "excelView";
		}
}
