package project2;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml" //, "classpath:config/security-context.xml"
})
public class Test1_Model {
	@Autowired  ApplicationContext context;
	@Autowired  DataSource		   ds;
	@Autowired  SqlSession		   sqlSession;
	@Autowired  TestMapper		   test;
	
	@Test public void test2() { System.out.println(".......now. " + test.now()); }
	
	@Ignore @Test public void test1() {
		System.out.println("...........3. " + sqlSession);
		System.out.println("...........2. " + ds);
		System.out.println("...........1. " + context);
	}
}
