package com.cafe24.memory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.memory.domain.AnimalCenter;
import com.cafe24.memory.domain.SearchReportAnimal;

@Mapper
public interface AnimalCenterMapper {

	/**
	 * 처리 안한 동물 리스트
	 * @return
	 */
	public List<AnimalCenter> selectNoDisposal();
	
	/**
	 * 모든 보호동물 ,타입별 보호동물 보호공간 코드 조회
	 * @param send_type
	 * @return
	 */
	public List<String> selectProtectAnimalCenter(String send_type);
	public List<String> selectProtectAnimalCenter();
	
	/**
	 * 센터 동물 삭제
	 * @param send_code
	 * @return
	 */
	public int deleteAnimalCenter(String send_code);
	
	/**
	 * 센터 동물 수정
	 * @param animal
	 * @return
	 */
	public int updateAnimalCenter(AnimalCenter animal);
	
	/**
	 * animalInsertCode로 searchReportCode 검색
	 * @param send_code
	 * @return
	 */
	public String getsearchReportCode(String send_code);
	
	/**
	 * searchReportCode로 acceptCode 검색
	 * @param reCode
	 * @return
	 */
	public String searchReportManager(String reCode);
	
	/**
	 * 보호동물 센터 등록 - 설채원
	 * @param animal
	 * @return
	 */
	public int insertAnimalCenter(AnimalCenter animal);
	
	/**
	 * 센터 동물 조회(전체) - 설채원
	 * @return
	 */
	public List<AnimalCenter> selectAnimalCenter();
	
	/**
	 * 센터 동물 조회(타입선택) - 설채원
	 * @param send_type
	 * @return
	 */
	public List<AnimalCenter> selectAnimalCenter(String send_type);
	
	/**
	 * 센터 동물 종류 및 종류에 따른 등록 동물 수 조회 - 설채원
	 * @return
	 */
	public List<Map<String,Object>> selectCenterCnt();
	
	/**
	 * 센터 동물 개체 조회(한 개체) -설채원
	 * @param send_code
	 * @return
	 */
	public AnimalCenter selectCenterAnimal(String send_code);
	
	/**
	 * 신고 내역 조회 이름+전화번호-> searchReport- 설채원
	 * @param memberName
	 * @param memberPhone
	 * @return
	 */
	public List<SearchReportAnimal> selectCenterReport(String memberName,String memberPhone);
	
	/**
	 * 신고내역 조회 센터등록 코드 -> searchReport - 설채원
	 * @param acceptCode
	 * @return
	 */
	public SearchReportAnimal selectReportCodeAnimal(String send_code);
}

