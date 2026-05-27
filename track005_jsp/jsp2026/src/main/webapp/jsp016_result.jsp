<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
	// 1. 데이터 넘겨받기
	request.setCharacterEncoding("UTF-8");
	String email = request.getParameter("email");
	String bpass = request.getParameter("pass");

	// 2. sql 구문처리 - select * from users where email=? and bpass=?
	//로그인 성공시
	
	try{
		Connection conn = null;   PreparedStatement pstmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mbasic";
	    String sql = "select * from users where bpass=? and email=?";
	    conn = DriverManager.getConnection(url , "root","1234");
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, bpass);
	    pstmt.setString(2, email);
	    ResultSet reset = pstmt.executeQuery();  
	    
		if(reset.next()){ 
			session.setAttribute("email", email);
			response.sendRedirect("jsp016_login.jsp");
		} else{ 
			out.println("<script> alert('관리자에게 문의해주세요'); history.go(-1); </script>"); 
		}
		if(reset   != null) { reset.close();   }
		if(pstmt != null){ pstmt.close();}
		if(conn != null){ conn.close();}
		
	}catch(Exception e){e.printStackTrace();}

%>