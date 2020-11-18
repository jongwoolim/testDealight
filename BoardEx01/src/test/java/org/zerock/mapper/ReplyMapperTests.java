package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	//테스트 전 해당 번호의 게시물이 존재하는 지 확인할 것
	private Long[] bnoArr = { 15l,17l,18l,19l,20l,21l};
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testList2() {
		
		Criteria cri = new Criteria(2, 10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 4l);
		replies.forEach(reply -> log.info(reply));
	}
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply->  log.info(reply));
	}
	@Test
	public void testUpdate() {
		Long targetRno = 10l;
		
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("update reply");
		int count = mapper.update(vo);
		
		log.info("update count: " + count) ;
	}
	@Test
	public void testDelete() {
		Long targetRno = 5l;
		
		mapper.delete(targetRno);
	}
	@Test
	public void testRead() {
		Long targetRno = 5l;
		
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}
	@Test
	public void testCreate() {
		IntStream.range(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			//게시물의 번호
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer " + i);
			
			mapper.insert(vo);
			
		});
	}
	@Test
	public void testMapper() {
		log.info(mapper);
	}
}
