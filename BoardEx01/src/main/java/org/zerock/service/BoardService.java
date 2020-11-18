package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	
	//등록
	void register(BoardVO board);
	
	//조회
	BoardVO get(Long bno);
	
	//수정
	boolean modify(BoardVO board);
	
	//삭제
	boolean remove(Long bno);
	
	//전체 조회
	//List<BoardVO> getList();
	
	List<BoardVO> getList(Criteria cri);
	
	int getTotal(Criteria cri);
}
