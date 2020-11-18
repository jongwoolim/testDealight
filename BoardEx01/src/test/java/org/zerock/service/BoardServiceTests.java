package org.zerock.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testDelete() {
		
		//게시물 번호의 존재 여부 확인하고 테스트 하기
		log.info("Remove result: " + service.remove(10l));
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(10l);
		
		if(board == null)
			return;
		
		board.setTitle("제목을 수정합니다.");
		log.info("Modify result : " + service.modify(board));
	}
	
	@Test
	public void testGet() {
		//해당 게시글 조회
		log.info(service.get(10l));
	}
	@Test
	public void testGetList(){
		//모든 게시글을 조회한다
		//service.getList().forEach(board -> log.info(board));
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
	
	@Test
	public void testRegister() {
		
		//등록할 게시글
		BoardVO board = BoardVO.builder()
			.title("새로 작성하는 글 select Key")
			.content("새로 작성하는 내용 select Key")
			.writer("newbie")
			.build();
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
	}
	@Test
	public void testExist() {
		
		log.info(service);
		
		assertNotNull(service);
	}
}
