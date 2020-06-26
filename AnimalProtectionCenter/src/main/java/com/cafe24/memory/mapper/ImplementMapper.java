package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Implement;

@Mapper
public interface ImplementMapper {
	
	//구현 못하게됬음
	int deleteImplement(String implementCode);
	
	/**
	 * 시설 사용과 사용량 코드로 검색 - 손충기
	 * @return
	 */
	Map<String, Object> selectImplementUseCountByCode(String implementCode);
	
	/**
	 * 시설 사용과 사용량 전체 검색 - 손충기
	 * @return
	 */
	List<Map<String, Object>> selectImplementUseCount();
	
	/**
	 * 시설 수정 처리 - 손충기
	 * @param implement
	 * @return
	 */
	int updateImplement(Implement implement);
	
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
