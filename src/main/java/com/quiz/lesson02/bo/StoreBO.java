package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service // spring bean
public class StoreBO {

	@Autowired // Dependency Injection (DI 의존성 주입)
	private StoreMapper storeMapper;
	
	// input: controller 로부터 들어온 요청 X
	// output: (Repository로 받은것을) List<Store> (controller에게 준다.)
	public List<Store> getStoreList() {
//		List<Store> storeList = storeMapper.selectStoreList();
//		return storeList; // 컨트롤러한테 전달
		
		return storeMapper.selectStoreList();
	}
}
