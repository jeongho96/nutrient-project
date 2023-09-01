package com.food.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExcelDTO2 {
	
	private int id; // 번호(0)
	private String foodCd; // 식품코드 (입력)(2)
	private String groupName; // 식품군(3)
	private String foodName; // 식품이름 (입력)(5)
	private String researchYear; // 조사년도 (입력)(6)
	private String makerName; // 지역/제조사 (입력)(7)
	private int servingSize; // 1회 제공량(11)
	private double calorie; //열량(kcal)(1회제공량당)(15)
	private double carbohydrate; // 탄수화물(19)
	private double protein; //단백질(17)
	private double province; // 지방(18)
	private double sugars; // 총당류(20)
	private double salt; // 나트륨(33)
	private double cholesterol; // 콜레스테롤(67)
	private double saturatedFattyAcides; // 포화지방산(68)
	private double transFat; // 트랜스지방(92)
	private String refName; // 자료출처(98)

}
