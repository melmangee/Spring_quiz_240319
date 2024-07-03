package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRespository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02Restcontroller {

	@Autowired
	RecruitRespository recruitRespository;
	
	@GetMapping("/1")
	public List<RecruitEntity> select1() {
		return recruitRespository.findById(8); 
	}
}
