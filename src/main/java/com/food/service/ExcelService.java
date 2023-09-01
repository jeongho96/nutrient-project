package com.food.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.food.dto.ExcelDTO;
import com.food.dto.ExcelSearchDTO;

public interface ExcelService {
	
	public void insertExcelFile(MultipartFile file);
//	List<ExcelDTO> getExcelData(String foodCd, String foodName, String researchYear, String makerName);
	List<ExcelDTO> getExcelData(ExcelSearchDTO searchDTO);
}
