package com.food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExcelDTO {
	
	private int id; // 번호(0)
	private String foodCd; // 식품코드 (입력)(2)
	private String groupName; // 식품군(3)
	private String foodName; // 식품이름 (입력)(5)
	private String researchYear; // 조사년도 (입력)(6)
	private String makerName; // 지역/제조사 (입력)(7)
	private String servingSize; // 1회 제공량(11)
	private String calorie; //열량(kcal)(1회제공량당)(15)
	private String carbohydrate; // 탄수화물(19)
	private String protein; //단백질(17)
	private String province; // 지방(18)
	private String sugars; // 총당류(20)
	private String salt; // 나트륨(33)
	private String cholesterol; // 콜레스테롤(67)
	private String saturatedFattyAcides; // 포화지방산(68)
	private String transFat; // 트랜스지방(92)
	private String refName; // 자료출처(98)

}
