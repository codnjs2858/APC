package com.cafe24.memory.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.memory.domain.Implement;
import com.cafe24.memory.mapper.ImplementMapper;

@Service
@Transactional
public class ImplementService {
	
	private final static Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);

	@Autowired
	ImplementMapper implementMapper;
	
	public int insertImplement(Implement implement) {
		return implementMapper.insertImplement(implement);
	}
	
	public int deleteImplement(String implementCode) {
		return implementMapper.deleteImplement(implementCode);
	}
	
	public Map<String, Object> selectImplementUseCountByCode(String implementCode){
		return implementMapper.selectImplementUseCountByCode(implementCode);
	}
	
	public List<Map<String, Object>> selectImplementUseCount(){
		return implementMapper.selectImplementUseCount();
	}
	
	public int modifyImplement(Implement implement) {
		int amount = implement.getImplementAmount();
		int remainAmount = implement.getImplementRemain();
		int buyAmount = implement.getBuyAmount();
		int breakageAmount = implement.getImplementBreakageAmount();
		
		//List<Map<String, Integer>> impleUseCnt = selectImplementUseCount(implement.getImplementCode());
		Map<String, Object> impleUseCnt = selectImplementUseCountByCode(implement.getImplementCode());
		
		if(impleUseCnt != null) {
			String useCode = (String) impleUseCnt.get("implementCode");
			long useCnt = (long) impleUseCnt.get("cnt");			
			logger.info("시설 사용과 사용량 {}", impleUseCnt);
			logger.info("사용중인 시설 {}", useCode);
			logger.info("사용중인 시설의 사용량 {}", useCnt);
			
			implement.setImplementAmount(amount + buyAmount);
			implement.setImplementRemain(remainAmount + buyAmount);
			implement.setImplementRemain(amount - breakageAmount - (int)useCnt);
			implement.setBuyAmount(0);		
		}
		
		
		return updateImplement(implement);
	}
	
	public int updateImplement(Implement implement) {
		return implementMapper.updateImplement(implement);
	}
	
	public Implement selectImplementByCode(String implementCode) {
		return implementMapper.selectImplementByCode(implementCode);
	}
	
	public List<Implement> selectImplement(){
		return implementMapper.selectImplement();
	}
	
}
