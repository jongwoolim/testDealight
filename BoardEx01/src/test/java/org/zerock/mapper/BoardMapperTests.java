package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	//페이징 처리
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		//10개씩 3페이지
		cri.setPageNum(5);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
		
	}
	@Test
	public void testUpdate() {
		
		//수정할 게시글
		BoardVO board = BoardVO.builder()
			.bno(8l)
			.title("수정된 제목")
			.content("수정된 내용")
			.writer("user00")
			.build();
		
		int count = mapper.update(board);
		log.info("Update Count : " + count);
	}
	
	@Test
	public void testDelete() {
		
		//해당 게시글을 삭제한다
		log.info("Delete Count : "+ mapper.delete(9l));
	}
	
	@Test
	public void testRead() {
		//해당 게시글을 조회한다
		BoardVO board = mapper.read(9l);
		
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		//등록할 게시글
		BoardVO board = BoardVO.builder()
			.title("새로 작성하는 글 select Key")
			.content("새로 작성하는 내용 select Key")
			.writer("newbie")
			.build();
				
		//게시글을 등록한다
		mapper.insertSelectKey(board);
		
		log.info(board);
	}

	@Test
	public void testInsert() {
		
		//등록할 게시글
		BoardVO board = BoardVO.builder()
			.title("새로 작성하는 글")
			.content("새로 작성하는 내용")
			.writer("newbie")
			.build();
		
		//게시글을 등록한다
		mapper.insert(board);
		
		log.info(board);
			
	}
	
}
