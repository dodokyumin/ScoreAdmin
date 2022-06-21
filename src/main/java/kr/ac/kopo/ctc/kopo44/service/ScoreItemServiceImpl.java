package kr.ac.kopo.ctc.kopo44.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo44.dao.ScoreItemDao;
import kr.ac.kopo.ctc.kopo44.dao.ScoreItemDaoImpl;
import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.dto.Pagination;

public class ScoreItemServiceImpl implements ScoreItemService {

	private ScoreItemDao scoreItemDao;
	
	private int countPerPage = 10;
	
	@Override
	public List<ScoreItem> selectAll(String strcPage) {
		Pagination pagination = new Pagination();
		int cPage = Integer.parseInt(strcPage);
		
		pagination.setCountPerPage(countPerPage); 
		pagination.setcPage(cPage);
		
		int startIndex = ((pagination.getcPage()-1)*pagination.getCountPerPage() +1);
		ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();
		List<ScoreItem> scoreItem = scoreItemDao.selectAll(startIndex, countPerPage);
		
		return scoreItem;
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
		int lastPage;
		if ((totalCount % countPerPage) > 0) {
			lastPage = totalCount / countPerPage + 1;
		} else {
			lastPage = totalCount / countPerPage;
		}

		//currPage
		if (currPage > lastPage) {
			currPage = lastPage;
		} else if (currPage < 1) {
			currPage = 1;
		}
		p.setcPage(currPage);

		// <<
		p.setPpPage(1);
		// >>
		p.setNnPage(lastPage);

		// >
		if ((lastPage - currPage) < pageSize) {
			p.setnPage(lastPage);
		} else {
			p.setnPage((currPage / pageSize + 1) * 10 + 1);
		}
		// <
		if ((currPage / pageSize) == 0) {
			p.setpPage(1);
		} else {
			p.setpPage((currPage / pageSize) * 10);
		}

		

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
