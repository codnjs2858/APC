package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Implement;

@Mapper
public interface ImplementMapper {
	
	/**
	 * 시설코드로 찾기 - 손충기
	 * @param implementCode
	 * @return
	 */
	Implement selectImplementByCode(String implementCode);
	
	/**
	 * 시설 리스트 - 손충기
	 * @return
	 */
	List<Implement> selectImplement();
	
}
