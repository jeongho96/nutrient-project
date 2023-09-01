package com.food.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.food.dto.ExcelDTO;
import com.food.dto.ExcelSearchDTO;



@Mapper		// Mapper라고 선언함
public interface ExcelMapper { 
	public void insertExcel(ExcelDTO dto);
	
	
//	List<ExcelDTO> selectExcelDTO(
//	        @Param("foodCd") String foodCd,
//	        @Param("foodName") String foodName,
//	        @Param("researchYear") String researchYear,
//	        @Param("makerName") String makerName
//	    );
	List<ExcelDTO> selectExcelDTO(ExcelSearchDTO searchDTO);
	
}
