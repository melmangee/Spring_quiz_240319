package com.quiz.lesson07.repository;

import java.util.List;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository JpaRepository<RecruitEntity, Integer> {

	public List<RecruitEntity> findById(int id);
	public List<RecruitEntity> findByCompanyId(int companyId);
	public List<RecruitEntity> findByPositionAndType(String position , String type);
	public List<RecruitEntity> findByTypeOrSalary(String type , int salary);
	public List<RecruitEntity> findByTypeByOrderBySalaryDESC(String type);
}
