package kr.ac.kopo.ctc.kopo44.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.dto.Pagination;
import kr.ac.kopo.ctc.kopo44.dto.ScoreItemDto;

public interface ScoreItemService {
	   
	//ScoreItem create(ScoreItem scoreItem); 
	//ScoreItemDao getScoreItemDao();
	//void setScoreItemDao(ScoreItemDao scoreItemDao);
	
	//조회
	ScoreItem selectOne(String id);
	
	List<ScoreItem> selectAll(String strcPage);
	
	//페이지 불러오기
	Pagination getPagination(String strcPage);
	
	//입력
	ScoreItem scoreItemInsertOne(String name, String kor, String eng, String mat);
	
	// 수정
	ScoreItem scoreItemUpdateOne(String name, String id, String kor, String eng, String mat);
	
	// 삭제
	boolean scoreItemDeleteOne(int id);
	
	//총 갯수
	int getRowCount();
	
	


	

}
