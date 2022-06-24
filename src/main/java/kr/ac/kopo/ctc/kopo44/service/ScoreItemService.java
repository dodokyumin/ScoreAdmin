package kr.ac.kopo.ctc.kopo44.service;

import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.dto.Pagination;
import kr.ac.kopo.ctc.kopo44.dto.ScoreItemDto;

public interface ScoreItemService {
	   
	//ScoreItem create(ScoreItem scoreItem); 
	//ScoreItemDao getScoreItemDao();
	//void setScoreItemDao(ScoreItemDao scoreItemDao);
	
	//조회
	ScoreItem selectOne(int id);
	
	ScoreItemDto selectAll(String strcPage);
	
	Pagination getPagination(int currPage, int countPerPage, int pageSize, int totalCount);
	
	//입력
	boolean scoreItemInsertOne(String name, String kor, String eng, String mat);
	
	// 수정
	boolean scoreItemUpdateOne(String name, String id, String kor, String eng, String mat);
	
	// 삭제
	boolean scoreItemDeleteOne(int id);
	
	//총 갯수
	int getRowCount();


	

}
