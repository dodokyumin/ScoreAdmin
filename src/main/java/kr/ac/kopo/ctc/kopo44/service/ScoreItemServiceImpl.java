package kr.ac.kopo.ctc.kopo44.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo44.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo44.dao.ScoreItemDaoImpl;
import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.dto.Pagination;
import kr.ac.kopo.ctc.kopo44.dto.ScoreItemDto;

public class ScoreItemServiceImpl implements ScoreItemService {

	ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();

	private int countPerPage = 10;
	final int COUNT_PER_PAGE = 10;
	final int PAGE_SIZE = 10;

	@Override
	public ScoreItemDto selectAll(String strcPage) {
		// 총 레코드 수 조회
		// 페이지네이션 계싼
		// 전제 목록 조회
		// 전체 목록 조회 결과랑 페이지 네이션을 dto로 묶어서 반환
		// 페이지네이션 계산
		Pagination pagination = new Pagination();
		int cPage = Integer.parseInt(strcPage);
		pagination.setcPage(cPage);
		pagination.setCountPerPage(countPerPage);

		// 총 레코드 수 조회
		int TOTAL_COUNT = getRowCount();

		// 전체 목록 조회
		int startIndex = ((pagination.getcPage() - 1) * pagination.getCountPerPage() + 1);
		List<ScoreItem> scoreItem = scoreItemDao.selectAll(startIndex, countPerPage);

		// 전체 목록 조회 결과랑 페이지 네이션을 dto로 묶어서 반환
		ScoreItemDto scoreItemDto = new ScoreItemDto(scoreItem,
				getPagination(cPage, COUNT_PER_PAGE, PAGE_SIZE, TOTAL_COUNT));
		
		return scoreItemDto;
	}

	@Override
	public ScoreItem selectOne(int studentid) {

		ScoreItem scoreItem = scoreItemDao.selectOne(studentid);

		return scoreItem;
	}

	@Override
	// countPerPage 한페이지당 몇개의 리스트
	// pageSize 밑에 보여줄 페이지 갯수
	// totalCount 총 게시물 수
	public Pagination getPagination(int currPage, int countPerPage, int pageSize, int totalCount) {
		Pagination p = new Pagination();

		// >>
		int totalPage;
		if ((totalCount % countPerPage) > 0) {
			totalPage = totalCount / countPerPage + 1;
		} else {
			totalPage = totalCount / countPerPage;
		}

		// currPage
		if (currPage > totalPage) {
			currPage = totalPage;
		} else if (currPage < 1) {
			currPage = 1;
		}
		p.setcPage(currPage);
		
		//pageSize
		p.setPageSize(pageSize);

		// <<
		p.setPpPage(1);
		// >>
		p.setNnPage(totalPage);

		// >
		if ((totalPage - currPage) < pageSize) {
			p.setnPage(totalPage);
		} else {
			p.setnPage((currPage / pageSize + 1) * 10 + 1);
		}
		// <
		if ((currPage / pageSize) == 0) {
			p.setpPage(1);
		} else {
			p.setpPage((currPage / pageSize) * 10);
		}

		// 첫 페이지 번호
		int startPage = (currPage / pageSize) * pageSize + 1;	
		if ((currPage % pageSize) == 0) {		
			startPage -= pageSize;
		}
		p.setFirstPage(startPage);
		
		// 마지막 페이지 번호
		int lastPage = (startPage + pageSize - 1) >= totalPage ? totalPage : (startPage + pageSize - 1);
		p.setLastPage(lastPage);
		
		return p;
	}

	@Override
	public boolean scoreItemInsertOne(String name, String kor, String eng, String mat) {

		return false;
	}

	@Override
	public boolean scoreItemUpdateOne(String name, String id, String kor, String eng, String mat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scoreItemDeleteOne(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRowCount() {

		int rowcount = scoreItemDao.RowCount();
		return rowcount;
	}


	// public ScoreItemDao getScoreItemDao() {
	// return scoreItemDao;
	// }
	//
	// public void setScoreItemDao(ScoreItemDao scoreItemDao) {
	// this.scoreItemDao = scoreItemDao;
	// }

}
