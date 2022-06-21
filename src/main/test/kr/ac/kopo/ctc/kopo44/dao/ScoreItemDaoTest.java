package kr.ac.kopo.ctc.kopo44.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.service.ScoreItemService;
import kr.ac.kopo.ctc.kopo44.service.ScoreItemServiceImpl;
import kr.ac.kopo.ctc.kopo44.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo44.dao.ScoreItemDaoImpl;

class ScoreItemDaoTest {

	ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();

//	@Test
//	void testCreate() {
//		ScoreItem scoreItemInput = new ScoreItem();
//		scoreItemInput.setName("홍길동");
//		scoreItemInput.setStudentid(110);
//		scoreItemInput.setKor(100);
//		scoreItemInput.setEng(85);
//		scoreItemInput.setMat(90);
//
//		ScoreItem scoreItemOutput = scoreItemDao.insertOne(scoreItemInput);
//
//		assertEquals(scoreItemOutput.getName(), "홍길동");
//		assertEquals(scoreItemOutput.getStudentid(), 110);
//	}
//
	@Test
	void testReadOne() {
		
		ScoreItem selectedOne = scoreItemDao.selectOne(102);
		assertEquals(selectedOne.getName(), "홍길동");
		assertEquals(selectedOne.getKor(), 100);
		assertEquals(selectedOne.getEng(), 85);
		assertEquals(selectedOne.getMat(), 90);
	}
//	
//	@Test
//	void testReadAll() {
//				
//		assertEquals(scoreItemDao.RowCount(), 120);
//	}
//
//	@Test
//	void testUpdate() {
//		ScoreItem scoreItemInput = new ScoreItem();
//		scoreItemInput.setName("홍길동1");
//		scoreItemInput.setStudentid(109);
//		scoreItemInput.setKor(1);
//		scoreItemInput.setEng(2);
//		scoreItemInput.setMat(3);
//		scoreItemDao.updatetOne(scoreItemInput);
//		
//		assertEquals(scoreItemInput.getName(), "홍길동1");
//		assertEquals(scoreItemInput.getKor(), 1);
//		assertEquals(scoreItemInput.getEng(), 2);
//		assertEquals(scoreItemInput.getMat(), 3);
//	}

//	@Test
//	void testDelete() {
//		System.out.println("삭제 이전 총 rows 갯수 :" + scoreItemDao.RowCount());
//		
//		scoreItemDao.deleteOne(101);
//		
//		System.out.println("삭제 이후 총 rows 갯수 :" + scoreItemDao.RowCount());
//
//
//	}

}
