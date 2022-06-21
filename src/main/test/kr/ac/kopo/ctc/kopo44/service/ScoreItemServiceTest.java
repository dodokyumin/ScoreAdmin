package kr.ac.kopo.ctc.kopo44.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kr.ac.kopo.ctc.kopo44.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo44.dao.ScoreItemDaoImpl;
import kr.ac.kopo.ctc.kopo44.dao.ScoreItemDaoMock;
import kr.ac.kopo.ctc.kopo44.dto.Pagination;

class ScoreItemServiceTest {

	private ScoreItemDao scoreItemDao = new ScoreItemDaoMock();
	private ScoreItemService scoreItemService = new ScoreItemServiceImpl();
	
	
	@BeforeEach
	void setUp() throws Exception {
		//scoreItemService.setScoreItemDao(scoreItemDao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
//기본 PageSize보다 총 PageSIze가 더 적을 때.	
	
	@Test //현재 페이지 : 첫번째(1p)
	void testGetPagination() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(1, 10, 10, 51);
		assertEquals(1, p.getPpPage());
		assertEquals(1, p.getpPage());
		assertEquals(6, p.getnPage());
		assertEquals(6, p.getNnPage());
		assertEquals(1, p.getcPage());
	}
	
	@Test //현재 페이지 : 마지막(6p)
	void testGetPagination2() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(6, 10, 10, 51);
		assertEquals(1, p.getPpPage());
		assertEquals(1, p.getpPage());
		assertEquals(6, p.getnPage());
		assertEquals(6, p.getNnPage());
		assertEquals(6, p.getcPage());
	}

	@Test //현제 페이지 : 페이지 중에서(3p)
	void testGetPagination3() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(3, 10, 10, 51);
		assertEquals(1, p.getPpPage());
		assertEquals(1, p.getpPage());
		assertEquals(6, p.getnPage());
		assertEquals(6, p.getNnPage());
		assertEquals(3, p.getcPage());
	}
	
	@Test //현제 페이지 : 경계 밖(-100p)
	void testGetPagination4() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(-100, 10, 10, 51);
		assertEquals(1, p.getPpPage());
		assertEquals(1, p.getpPage());
		assertEquals(6, p.getnPage());
		assertEquals(6, p.getNnPage());
		assertEquals(1, p.getcPage());
	}
	
	@Test //현제 페이지 : 경계 밖(+100p)
	void testGetPagination5() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(100, 10, 10, 51);
		assertEquals(1, p.getPpPage());
		assertEquals(1, p.getpPage());
		assertEquals(6, p.getnPage());
		assertEquals(6, p.getNnPage());
		assertEquals(6, p.getcPage());
	}
	
	//기본 PageSize보다 총 PageSIze가 더 클 때.	
	
	@Test //현재 페이지 : 첫번째(1p)
	void testGetPagination6() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(1, 10, 10, 281);
		assertEquals(1, p.getPpPage());
		assertEquals(1, p.getpPage());
		assertEquals(11, p.getnPage());
		assertEquals(29, p.getNnPage());
		assertEquals(1, p.getcPage());
	}

	@Test //현재 페이지 : 마지막(29p)
	void testGetPagination7() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(29, 10, 10, 281);
		assertEquals(1, p.getPpPage());
		assertEquals(20, p.getpPage());
		assertEquals(29, p.getnPage());
		assertEquals(29, p.getNnPage());
		assertEquals(29, p.getcPage());
	}

	@Test //현재 페이지 : 페이지 중에서(15p)
	void testGetPagination8() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(15, 10, 10, 281);
		assertEquals(1, p.getPpPage());
		assertEquals(10, p.getpPage());
		assertEquals(21, p.getnPage());
		assertEquals(29, p.getNnPage());
		assertEquals(15, p.getcPage());
	}
	
	@Test //현재 페이지 : 경계 밖(-1000p)
	void testGetPagination9() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(-1000, 10, 10, 281);
		assertEquals(1, p.getPpPage());
		assertEquals(1, p.getpPage());
		assertEquals(11, p.getnPage());
		assertEquals(29, p.getNnPage());
		assertEquals(1, p.getcPage());
	}
	
	@Test //현재 페이지 : 경계 밖(+1000p)
	void testGetPagination10() {
		//(int currPage, int countPerPage, int pageSize, int totalCount)
		Pagination p = scoreItemService.getPagination(1000, 10, 10, 281);
		assertEquals(1, p.getPpPage());
		assertEquals(20, p.getpPage());
		assertEquals(29, p.getnPage());
		assertEquals(29, p.getNnPage());
		assertEquals(29, p.getcPage());
	}
}
