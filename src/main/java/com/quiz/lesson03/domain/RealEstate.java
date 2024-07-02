package com.quiz.lesson03.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RealEstate {
	private int id;
	private int realtorId;
	private String address;
	private int area;
	private String type;
	private int price;
	private Integer rentPrice;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
