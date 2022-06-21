package kr.ac.kopo.ctc.kopo44.dto;

import java.util.List;

import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.service.ScoreItemService;
import kr.ac.kopo.ctc.kopo44.service.ScoreItemServiceImpl;

public class ViewStudentsDto {
	
	//private List<ScoreItem> selectAll(int startIndex,int countPerPage);
	private List<ScoreItem> scoreItems;
	private Pagination pagenation;
	
	public List<ScoreItem> getScoreItems() {
		return scoreItems;
	}
	public Pagination getPagenation() {
		return pagenation;
	}
}
