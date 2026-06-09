package com.the703.dao;

import java.util.HashMap;
import java.util.List;

import com.the703.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public int insert(BoardDto dto);
    public List<BoardDto> selectAll();
    public BoardDto select(int bno);
    public int update(BoardDto dto);
    public int delete(BoardDto  bno);
    public int updateHit(int bno);
	
    /*  paging
     	paging		*/
    public List<BoardDto> select10(HashMap<String,Integer> map);
    
    public int selectCnt();
}

/*
> 실습
1. project 만들기
    1. dynamic web project - ex02
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path
    5. build path - add Libraries - JUnit 4
    
2. pom.xml 에  jar 파일 다운로드 받기
3. root-context 에   내용설정
   1) DataSource
   2) Mybatis
   3) Mapper
4. 각종 설정파일들설정
    com.the703.dao   - @Mapper 
    com.the703.dto    
    config       
      ㄴ db.properties
      ㄴ mybatis-config.xml
      ㄴ test-mapper.xml
      ㄴ board-mapper.xml
5. 테스트파일설정
  
6. test-mapper.xml
select now()   
    
7. mvcboard
mysql> desc mvcboard2;
+----------+---------------+------+-----+-------------------+-------------------+
| Field    | Type          | Null | Key | Default           | Extra             |
+----------+---------------+------+-----+-------------------+-------------------+
| bno      | int           | NO   | PRI | NULL              | auto_increment    |
| bname    | varchar(20)   | NO   |     | NULL              |                   |
| bpass    | varchar(50)   | NO   |     | NULL              |                   |
| btitle   | varchar(1000) | NO   |     | NULL              |                   |
| bcontent | text          | NO   |     | NULL              |                   |
| bdate    | timestamp     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bhit     | int           | NO   |     | 0                 |                   |
| bip      | varchar(50)   | NO   |     | NULL              |                   |
+----------+---------------+------+-----+-------------------+-------------------+
8 rows in set (0.00 sec)
(해당 번호의 글읽기,글수정, 삭제)
create: INSERT INTO mvcboard2 (bname, bpass, btitle, bcontent, bip) 
		VALUES (#{bname}, #{bpass}, #{btitle}, #{bcontent}, #{bip});
read  :  select * from mvcboard2 order by bno desc
		 select * from mvcboard2 where bno=#{bno}
update:  update  mvcboard2  set  btitle=#{btitle}  , bcontent=#{bcontent}  where bno= #{bno}
delete : delete  from mvcboard2  where bno= #{bno} 

mysql>      

*/