package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02Restcontroller {

	@Autowired
	RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public List<RecruitEntity> select1() {
		return recruitRepository.findById(8); 
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> select2() {
		return recruitRepository.findByCompanyId(1);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> select3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자" ,"정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> select4() {
		return recruitRepository.findByTypeOrSalary("정규직", 9000); 
		
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> select5() {
		return recruitRepository.findByTypeByOrderBySalaryDESC("계약직");
	}
}
