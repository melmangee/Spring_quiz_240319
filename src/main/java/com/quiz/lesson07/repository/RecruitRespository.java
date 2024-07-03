package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRespository extends JpaRepository<RecruitEntity, Integer>{
	
	public List<RecruitEntity> findById(int id);
}
