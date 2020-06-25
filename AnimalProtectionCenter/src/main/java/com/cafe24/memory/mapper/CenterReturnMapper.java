package com.cafe24.memory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.CenterReturn;
import com.cafe24.memory.domain.PetAdoption;

@Mapper
public interface CenterReturnMapper {
	
	public List<CenterReturn> selectCenterReturn();
	
	public int insertCenterReturn(CenterReturn centerReturn);
	
	public int updateCenterReturn(CenterReturn centerReturn);
	
	public int deleteCenterReturn(String centerReturnCode);
	
	public CenterReturn selectCenterReturnCode(String centerReturnCode);
}
