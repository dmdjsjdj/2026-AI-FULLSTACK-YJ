<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->
    <div class="container my-5">
        <h3 >글 상세보기 </h3>
        <%
		    String bno = request.getParameter("bno"); 
		    
		    // HTML에 출력할 변수 초기화
		    String bname = "";
		    String btitle = "";
		    String bcontent = "";
		    int bhit = 0;
		
		    // 2. DB 연동하여 데이터 가져오기
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");  //1. 드라이버 로딩
		        String url = "jdbc:mysql://localhost:3306/mbasic";
		        conn = DriverManager.getConnection(url, "root", "1234");  //2. jdbc연동
		
		        String hitsql = "update mvcboard1 set bhit=bhit+1 where bno=?";
		        pstmt = conn.prepareStatement(hitsql);
		        pstmt.setString(1, bno);
		        pstmt.executeUpdate();
		        pstmt.close();
		        
		        String sql = "select * from mvcboard1 where bno = ?"; 
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, bno);
		        rs = pstmt.executeQuery();  //표
		
		        if (rs.next()) {  //줄
		            bname = rs.getString("bname");  //칸
		            btitle = rs.getString("btitle");
		            bcontent = rs.getString("bcontent");
		            bhit = rs.getInt("bhit");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        if(rs != null) rs.close();
		        if(pstmt != null) pstmt.close();
		        if(conn != null) conn.close();
		    }
		%>
        <form  action ="#"  method="post"   onsubmit="return checkForm()">
        	<div  class="my-3">
	            <label for="bhit"   class="form-label">조회수</label>
	            <p><%=bhit %></p>
	         </div> 
	         <div  class="my-3">
	            <label for="bname"   class="form-label">이름</label>
	            <input type="text"   class="form-control"    id="bname"  
	            	   name="bname" value="<%=bname %>" readonly />
	         </div> 
	         <div  class="my-3">
	            <label for="btitle"  class="form-label">제목</label>
	            <input type="text"   class="form-control"    
	            	   id="btitle"  name="btitle" value="<%=btitle %>" readonly/>
	         </div>
	         <div  class="my-3">
	            <label for="bcontent"  class="form-label">내용</label>
	            <textarea  class="form-control"    id="bcontent"  
	            		   name="bcontent" readonly ><%=bcontent %></textarea>
	         </div>
	         <div  class="my-3  text-end"> 
	         <%
	         nickname = (String)session.getAttribute("nickname");
                if(nickname.equals(bname)){
	            out.println("<a href='edit.jsp?bno=" + bno + "'  class='btn btn-outline-success'  title='글수정'>수정</a>"+
	            "<a href='delete.jsp?bno=" + bno + "' class='btn btn-outline-primary'  title='글삭제'>삭제</a>");
	            }
	           %>
	            <a href='list.jsp'     class="btn btn-primary"  title="목록보러가기">목록</a>
	         </div>
	      </form> 
   </div>
	<!--  jasp014_footer.jsp -->
    <!--  jasp014_footer.jsp -->
<%@include file="inc/footer.jsp" %>