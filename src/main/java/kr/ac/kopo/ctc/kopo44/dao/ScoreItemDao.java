package kr.ac.kopo.ctc.kopo44.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.dto.Pagination;

public interface ScoreItemDao {
	final static String COLUMN_ID = "studentid";
	final static String TABLE_NAME = "examtable";

	// create
	// 정상적으로 작성create 되었을 때 리턴받을 값(리턴을 받을 때 DaoImpl에서 시스템 내부적으로
	// 정해진 글 번호 같은 것들을 같이 받는다.
	ScoreItem insertOne(ScoreItem ScoreItem);

	// read
	// 한개만 읽는(가져오는)
	ScoreItem selectOne(int studentid);

	// 여러개(리스트) 읽는(가져오는)
	List<ScoreItem> selectAll(int startIndex, int countPerPage);

	// update
	ScoreItem updatetOne(ScoreItem ScoreItem);

	// delete
	int deleteOne(int studentid);

	// 테이블 내용 총 갯수 확인하기
	int RowCount();
	
	int newStudentid();
}
