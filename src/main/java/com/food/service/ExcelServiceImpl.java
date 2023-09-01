package com.food.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.food.dto.ExcelDTO;
import com.food.dto.ExcelSearchDTO;
import com.food.mapper.ExcelMapper;

import lombok.extern.slf4j.Slf4j;

@Service // 서비스임을 선언
@Slf4j
public class ExcelServiceImpl implements ExcelService {

	@Autowired // Mapper와 연결
	private ExcelMapper excelMapper;

	public void insertExcelFile(MultipartFile file) {
		log.info("전달 완료");
		 // 파일을 업로드한 경로\파일명 의 경로를 설정 후, justFileName에 담긴 파일명을 붙여서 경로완성!
	    String filePath = "C:\\FileUpload/Upload/" + file.getOriginalFilename();
	    log.info("경로 정보 확인 : " + filePath);
	    
	    
	    // 특정 폴더에 파일 저장
	    File saveFile = new File(filePath);
	    if(!saveFile.exists())
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    try {
	    	ExcelDTO excelDto = new ExcelDTO();
	    	
	        // FileInputStream을 이용해서 완성한 파일경로에 있는 파일의 정보를 받는다
	        FileInputStream excelFile = new FileInputStream(new File(filePath));
	        log.info("파일 정보 확인 : " + excelFile);
	        // XSSFWorkbook 객체를 이용해서 엑셀파일의 정보를 읽어들인다
	        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
	        
	        log.info("액셀 정보 확인 : " + workbook);
	        // XSSFSheet 객체를 이용해서 시트의 정보를 읽어들인다 (getSheetAt(번호), 0 = 맨 첫번째 시트)
	        XSSFSheet sheet = workbook.getSheetAt(0);
	        
	        // getPhysicalNumberOfRows(); 메소드를 사용해서 데이터가 있는 마지막 행의 번호를 받는다
	        int rowEnd = sheet.getPhysicalNumberOfRows();
	        
	        // 읽어들이고 싶은 행의 번호는 '읽어들이고 싶은 행 - 1'로 설정 ( 0은 첫번째줄부터 ~ )
	        // 0번 행은 각 열의 제목이므로, i는 1번부터 실행.
	        for ( int i = 1; i <= rowEnd; i++) {

	            // 차례대로 한줄씩 데이터를 읽어들인다
	            XSSFRow row = sheet.getRow(i);
	            
	            // 반복문을 통해 선택된 row에 데이터가 있으면
	            if ( row != null ) {
	                
	                // getPhysicalNumberOfCells(); 메소드를 사용해서 데이터가 있는 마지막 cell의 열 번호를 받는다
	                int cellEnd = row.getPhysicalNumberOfCells();
	                
	                // 읽어들이고 싶은 cell의 열번호는 '읽어들이고 싶은 열번호 - 1'로 설정
	                for ( int j = 0; j <= cellEnd; j++) {
	                    
	                    // 차례대로 하나의 셀씩 데이터를 읽어들인다
	                    XSSFCell cell = row.getCell(j);
	                    
	                    // 읽어들인 데이터는 자료형에 맞게 출력하는 메소드가 다르다
	                    String value = "";
	                    if ( cell == null) continue;
	                    else {
	                        
	                        switch( cell.getCellType() ) {
	                        case XSSFCell.CELL_TYPE_FORMULA:
	                            value = cell.getCellFormula();
	                            break;    
	                        case XSSFCell.CELL_TYPE_NUMERIC:
	                            value = cell.getNumericCellValue() + "";
	                            break;
	                        case XSSFCell.CELL_TYPE_STRING:
	                            value = cell.getStringCellValue() + "";
	                            break;
	                        case XSSFCell.CELL_TYPE_BLANK:
	                            value = cell.getBooleanCellValue() + "";
	                            break;
	                        case XSSFCell.CELL_TYPE_ERROR:
	                            value = cell.getErrorCellValue() + "";
	                            break;
	                        }
	                    }
	                    
//	                    System.out.println(i + "번 행 : " + j + "번 열 값 : " + value);
	                    // DB에 Dto형태로 cell번호를 구분하여 Setter메소드를 사용해서 값을 받는다
	                    switch (j) {
	                    case 0:
	                    	excelDto.setId(Integer.parseInt(value));
	                        break;
	                    case 2:
	                    	excelDto.setFoodCd(value);
	                        break;
	                    case 3:
	                    	excelDto.setGroupName(value);
	                        break;
	                    case 5:
	                    	excelDto.setFoodName(value);
	                        break;
	                    case 6:
	                    	excelDto.setResearchYear(value);
	                        break;
	                    case 7:
	                    	excelDto.setMakerName(value);
	                        break;
	                    case 11:
	                    	excelDto.setServingSize(value);
	                        break;
	                    case 15:
	                    	excelDto.setCalorie(value);
	                        break;
	                    case 17:
	                    	excelDto.setProtein(value);
	                        break;
	                    case 18:
	                    	excelDto.setProvince(value);
	                        break;
	                    case 19:
	                    	excelDto.setCarbohydrate(value);
	                        break;
	                    case 20:
	                    	excelDto.setSugars(value);
	                        break;
	                    case 33:
	                    	excelDto.setSalt(value);
	                        break;
	                    case 67:
	                    	excelDto.setCholesterol(value);
	                        break;
	                    case 68:
	                    	excelDto.setSaturatedFattyAcides(value);
	                        break;
	                    case 92:
	                    	excelDto.setTransFat(value);
	                        break;
	                    case 98:
	                    	excelDto.setRefName(value);
	                        break;

	                }
	                    
	                }
	                System.out.println(excelDto);
	                // VO형태로 받은 데이터를 DB에 저장하는 클래스의 메소드와 연결한다
	                excelMapper.insertExcel(excelDto);
	            }
	 
	        }
	 
	    } catch ( Exception e ) {
	        e.printStackTrace();
	    }
		
	}

	@Override
    public List<ExcelDTO> getExcelData(ExcelSearchDTO searchDTO) {
        return excelMapper.selectExcelDTO(searchDTO);
    }
	
//	@Override
//	public List<ExcelDTO> getExcelData(String foodCd, String foodName, String researchYear, String makerName) {
//		return excelMapper.selectExcelDTO(foodCd, foodName, researchYear, makerName);
//	}
}
