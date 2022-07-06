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
	public List<ScoreItem> selectAll(String strcPage) {
		// 총 레코드 수 조회
		// 페이지네이션 계싼
		// 전제 목록 조회
		// 전체 목록 조회 결과랑 페이지 네이션을 dto로 묶어서 반환
		// 페이지네이션 계산
		Pagination pagination = new Pagination();
		int cPage = Integer.parseInt(strcPage);
		pagination.setcPage(cPage);
		pagination.setCountPerPage(countPerPage);

		

		// 전체 목록 조회 
		int startIndex = ((pagination.getcPage() - 1) * pagination.getCountPerPage() + 1);
		
		List<ScoreItem> scoreItem = scoreItemDao.selectAll(startIndex, countPerPage);

		// 전체 목록 조회 결과랑 페이지 네이션을 dto로 묶어서 반환
//		ScoreItemDto scoreItemDto = new ScoreItemDto(scoreItem,
//				getPagination(cPage, COUNT_PER_PAGE, PAGE_SIZE, TOTAL_COUNT));
//		
		return scoreItem;
	}

	@Override
	public ScoreItem selectOne(String strStudentid) {
		int studentid = Integer.parseInt(strStudentid);
		ScoreItem scoreItem = scoreItemDao.selectOne(studentid);

//		if (searchid.length() == 0) {
//			searchid = "0";
//		}
//		name = "해당 학번 없음.";
		return scoreItem;
	}

	@Override
	// countPerPage 한페이지당 몇개의 리스트
	// pageSize 밑에 보여줄 페이지 갯수
	// totalCount 총 게시물 수
	public Pagination getPagination(String strcPage) {
		
		int currPage = Integer.parseInt(strcPage);
		
		Pagination p = new Pagination();
		
		// 총 레코드 수 조회
		int totalCount = getRowCount();
		
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
		p.setPageSize(PAGE_SIZE);

		// <<
		p.setPpPage(1);
		// >>
		p.setNnPage(totalPage);

		// >
		if ((totalPage - currPage) < PAGE_SIZE) {
			p.setnPage(totalPage);
		} else {
			p.setnPage((currPage / PAGE_SIZE + 1) * PAGE_SIZE + 1);
		}
		// < 
		if ((currPage / PAGE_SIZE) == 0) {
			p.setpPage(1);
		} else {
			p.setpPage((currPage-PAGE_SIZE / PAGE_SIZE)); //이 부분 문데
		}

		// 첫 페이지 번호
		int startPage = (currPage / PAGE_SIZE) * PAGE_SIZE + 1;	
		if ((currPage % PAGE_SIZE) == 0) {		
			startPage -= PAGE_SIZE;
		}
		p.setFirstPage(startPage);
		
		// 마지막 페이지 번호
		int lastPage = (startPage + PAGE_SIZE - 1) >= totalPage ? totalPage : (startPage + PAGE_SIZE - 1);
		p.setLastPage(lastPage);
		
		if(lastPage >= totalPage) {
			p.setLastPage(totalPage);
		}
		
		return p;
	}

	@Override
	public ScoreItem scoreItemInsertOne(String name, String strKor, String strEng, String strMat) {
		
//		boolean result = false;
		
		ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();
		ScoreItem scoreItem = new ScoreItem();
		
		int studentid = scoreItemDao.newStudentid();
		int kor = Integer.parseInt(strKor);
		int eng = Integer.parseInt(strEng);
		int mat = Integer.parseInt(strMat);

		scoreItem.setName(name);
		scoreItem.setStudentid(studentid);
		scoreItem.setKor(kor);
		scoreItem.setEng(eng);
		scoreItem.setMat(mat);
		
		scoreItemDao.insertOne(scoreItem);
//		if(scoreItemDao.insertOne(scoreItem) != null) {
//			result = true;
//		}
		
		return scoreItem;
	}

	@Override
	public ScoreItem scoreItemUpdateOne(String name, String strStudentid, String strKor, String strEng, String strMat) {

		int studentid = Integer.parseInt(strStudentid);
		int kor = Integer.parseInt(strKor);
		int eng = Integer.parseInt(strEng);
		int mat = Integer.parseInt(strMat);
		
		ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();
		ScoreItem scoreItem = new ScoreItem();

		scoreItem.setName(name);
		scoreItem.setStudentid(studentid);
		scoreItem.setKor(kor);
		scoreItem.setEng(eng);
		scoreItem.setMat(mat);
		
		scoreItemDao.updatetOne(scoreItem);
		
		return scoreItem;
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
