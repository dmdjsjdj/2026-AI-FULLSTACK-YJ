package spring002_db_mysql;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.TestMapper;
import com.the703.dao.UserInfoMapper;
import com.the703.dto.UserInfoDto;

@RunWith(SpringJUnit4ClassRunner.class) //1. spring 구동
@ContextConfiguration(locations = "classpath:config/root-context.xml")  //2. 설정파일

public class ModelTest001 {
	@Autowired ApplicationContext context; //3. Bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired DataSource	   dataSource;
	@Autowired SqlSession	   sqlSession;
	@Autowired TestMapper	   test;
	
	@Autowired UserInfoMapper  userinfo;
	
	@Test
	public void test5() { 
		//5. 삭제
		int dto3 = 5;
		System.out.println("DELETE > "+userinfo.delete(dto3)+"줄 삭제");
		//4. 수정
		UserInfoDto dto2 = new UserInfoDto();  dto2.setName("hi");  dto2.setAge(24); dto2.setNo(2);
		System.out.println("UPDATE > "+userinfo.update(dto2));
		//3. 한명검색
		int dto1 = 5;
		System.out.println("SELECT > "+userinfo.select(dto1));
		//2. 삽입
		UserInfoDto dto = new UserInfoDto();  dto.setName("hi");  dto.setAge(24);
		System.out.println("INSERT > "+userinfo.insert(dto));
		//1. 전체검색
		System.out.println("SELECTALL > "+userinfo.selectAll());
	}
	
	@Ignore   //@Test
	public void test1() { System.out.println(context); }
	
	@Ignore   //@Test
	public void test2() { System.out.println(dataSource); }
	
	@Ignore   //@Test
	public void test3() { System.out.println(sqlSession); }
	
	@Ignore   //@Test
	public void test4() { System.out.println(test.now()); }
}
