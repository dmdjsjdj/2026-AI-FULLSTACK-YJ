package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.BoardMapper;
import com.the703.dao.TestMapper;
import com.the703.dto.BoardDto;


@RunWith(SpringJUnit4ClassRunner.class)   //spring 구동
@ContextConfiguration(locations = "classpath:config/root-context.xml")  // 위치설정
public class ModelTest01 {
	@Autowired ApplicationContext context; //3. Bean  (스프링이 관리하는 객체)  생성~소멸
	@Autowired DataSource   dataSource;
	@Autowired SqlSession   sqlSession;
	@Autowired TestMapper	test;
	
	@Autowired BoardMapper		board;
	
	@Test public void test4() throws UnknownHostException {
//		//삭제
//		System.out.println("DELETE > "+board.delete(17)+"줄 삭제");
//		//수정
//		BoardDto dto2 = new BoardDto();  dto2.setBtitle("hi");  dto2.setBcontent("합니다"); dto2.setBno(1);
//		System.out.println("UPDATE > "+board.update(dto2));  //실행 줄수 1
//		//검색
//		System.out.println("SELECT > "+ board.select(1));
//		//삽입
//		BoardDto dto = new BoardDto();  dto.setBname("hi");  dto.setBpass("asdfg123"); 
//				 dto.setBtitle("안녕"); dto.setBcontent("하세요"); 
//				 dto.setBip(InetAddress.getLocalHost().getHostAddress());  //#1
//		System.out.println("INSERT > "+board.insert(dto));  //실행한 줄수 1
		//전체검색
		System.out.println("SELECTALL > "+ board.selectAll());
	}

	@Ignore @Test public void test3() { System.out.println(test.now()); }
	@Ignore @Test public void test1() { System.out.println(context); }
	@Ignore @Test public void test2() { System.out.println(sqlSession); }
}
