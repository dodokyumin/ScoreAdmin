package kr.ac.kopo.ctc.kopo44.dto;

import java.util.List;

import kr.ac.kopo.ctc.kopo44.domain.ScoreItem;
import kr.ac.kopo.ctc.kopo44.service.ScoreItemService;
import kr.ac.kopo.ctc.kopo44.service.ScoreItemServiceImpl;

public class ScoreItemDto {
	
	//private List<ScoreItem> selectAll(int startIndex,int countPerPage);
	private List<ScoreItem> scoreItems;
	private Pagination pagination;
	
	// DB에서 꺼낸 값을 임의로 변경할 필요가 없기 때문에 DTO클래스에는 setter가 없다.
	//대신 생성자에서 값을 할당한다. setter는 접근 제한이 public으로 되기 때문. 보안상의 이유.
	public ScoreItemDto(List<ScoreItem> scoreItems,Pagination pagination){
		this.scoreItems = scoreItems;
		this.pagination = pagination;
	}
	
	public List<ScoreItem> getScoreItems() {
		return scoreItems;
	}
	public Pagination getPagenation() {
		return pagination;
	}
}
