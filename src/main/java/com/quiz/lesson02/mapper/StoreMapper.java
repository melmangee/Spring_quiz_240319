package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;

@Mapper
public interface StoreMapper {
	
	// input: Bo로부터 받아옴 X
	// output: Bo로 전달 List<Store>
	public List<Store> selectStoreList();

}
