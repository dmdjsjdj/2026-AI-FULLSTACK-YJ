<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	request.setCharacterEncoding("UTF-8");
	
	String bpass = request.getParameter("bpass");
	String email = request.getParameter("email");
	
	try{
		Connection conn = null;   PreparedStatement pstmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mbasic";
	    String sql = "select * from users where bpass=? and email=?";
	    conn = DriverManager.getConnection(url , "root","1234");
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, bpass);
	    pstmt.setString(2, email);
	    
	    ResultSet reset = pstmt.executeQuery();  // insert, update, delete 실행한 줄 수
		//4. jsp012_milks.jsp로 돌아가기	 - 알림창				주소표시창줄
		if(reset.next()){ 
			String nickname = reset.getString("nickname");
			session.setAttribute("nickname", nickname);
			out.println("<script> alert('로그인 성공'); location.href='list.jsp'; </script>"); 
		} else{ 
			out.println("<script> alert('관리자에게 문의해주세요'); history.go(-1); </script>"); 
		}
		if(reset   != null) { reset.close();   }
		if(pstmt != null){ pstmt.close();}
		if(conn != null){ conn.close();}
		
	}catch(Exception e){e.printStackTrace();}
%>