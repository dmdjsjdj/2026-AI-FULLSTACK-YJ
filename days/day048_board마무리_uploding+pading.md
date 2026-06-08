

### Todo: 

1. 

<!-- img upload -->   
<!-- img upload -->    
   <!-- commons-fileupload -->
   <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.3.1</version>
   </dependency>

   <!-- commons-io -->
   <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.11.0</version>
   </dependency>
<!-- img upload -->   
<!-- img upload -->    

2. servlet-context.xml


진행2. board 에 이미지 업로드 추가
0) 테이블에 이미지 경로추가
    bfile  varchar(500) 기본값 the703.png

- 테이블수정
- dto 수정
- board-mapper.xml 수정

1) 글삽입에서 이미지 업로드 추가
2) 상세보기 이미지 나오게
3) 글수정에서 이미지 업로드 추가 - 이미지 안올리면 이전 이미지
                             - 아예 이미지가 없다면 me.png이미지


3. Paging
진행1. paging?
cmd)
   insert into mvcboard2 (bname , bpass , btitle ,  bcontent , bip ,  bfile) 
   select bname, bpass, btitle, bcontent, bip, bfile from mvcboard2;

100개 이상

진행2. Paging 컴포넌트 만들기

paging 1 - Model 1) Mapper
   1) 최신글 기준으로 10개씩 가져오기

      select * from mvcboard2 by bno desc limit 0,10;    -- 어디서부터 , 몇개
      select * from mvcboard2 by bno desc limit 10,10;
      select * from mvcboard2 by bno desc limit 20,10;

   2) 전체 게시글 갯수
      select count(*) from mvcboard2;

paging 2 - Model 2) PagingUtil

Paging 3 - Controller) BoardController 사용

Paging 4 - jsp) View

