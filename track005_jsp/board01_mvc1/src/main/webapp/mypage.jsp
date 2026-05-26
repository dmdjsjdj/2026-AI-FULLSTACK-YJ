<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->
    <!-- content -->
   <div class="container my-5">
      <h3>마이페이지</h3>
       <tr>
       <th></th>
       <td></td>
       </tr>
       <table 
            class="table table-striped table-bordered table-hover " id="usertable" >
            <caption> 내 정보 </caption>
            <tbody>
            <%
		        String nickname = (String)session.getAttribute("nickname");
            
		
		        if(nickname == null){
		            out.println("<script> alert('로그인이 필요합니다'); location.href='login.jsp'; </script>");
		        }
		        
		      try{
		    	  Class.forName("com.mysql.cj.jdbc.Driver");
		    	  PreparedStatement pstmt =null;	ResultSet rset = null; Connection conn = null;
		    	  conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mbasic", "root", "1234");
		    	  
				  pstmt = conn.prepareStatement("SELECT * FROM users where nickname=?");
				  pstmt.setString(1, nickname);
			      //select- executeQuery/ insert, update, delete- executeUpdate
				  rset = pstmt.executeQuery(); //표
				  
	    		  while( rset.next() ){
						out.println(
							"<tr><th>닉네임</th><td>"+ rset.getString("nickname") + "</td></tr>" 
		  					+"<tr><th>이메일</th><td>"+ rset.getString("email") + "</td></tr>" 
							+"<tr><th>휴대폰</th><td>"+ rset.getString("mobile")  + "</td></tr>" 
							+"<tr><th>가입일</th><td>"+ rset.getString("udate")  + "</td></tr>" 
							+"<tr><th>가입IP</th><td>"+ rset.getString("bip")      + "</td></tr>"   ); 
					}
	    		  
			       if(rset   != null) { rset.close();   }
     			   if(pstmt  != null) { pstmt.close();  }
				   if(conn  != null) { conn.close();  }
		      } catch(Exception e) {  e.printStackTrace(); }
		      %>
            </tbody>
        </table>
        <div class="text-end">
        	<a href="logout.jsp" title="로그아웃" class="btn btn-danger ">로그아웃</a>
            <a href="mytable.jsp" title="내가 쓴 글" class="btn btn-primary ">내가 쓴 글</a>
        </div>
   </div>
	<!--  jasp014_footer.jsp -->
    <!--  jasp014_footer.jsp -->
<%@include file="inc/footer.jsp" %>