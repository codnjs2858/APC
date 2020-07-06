package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.Adoptee;

@Mapper
public interface AdopteeMapper {
	
	public List<Adoptee> selectAdoptee();
	
	public int insertAdoptee(Adoptee adt); 
	
	public Adoptee selectAdopteeById(String MemberId);
}
