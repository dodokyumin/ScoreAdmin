package kr.ac.kopo.ctc.kopo44.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.dto.Pagination;
import kr.ac.kopo.ctc.kopo44.service.ScoreItemService;
import kr.ac.kopo.ctc.kopo44.service.ScoreItemServiceImpl;

public class ScoreItemDaoMock implements ScoreItemDao {

	@Override
	public ScoreItem create(ScoreItem ScoreItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreItem selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreItem> selectAll(int page, int countPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pagination getPagination(int currPage, int countPerPage, int pageSize, int totalCount) {
		ScoreItemService scoreItemService = new ScoreItemServiceImpl();
		
		

		
		return null;
	}
	
}
