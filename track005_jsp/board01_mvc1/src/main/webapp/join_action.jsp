<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	request.setCharacterEncoding("UTF-8");
	
	String nickname = request.getParameter("nickname");
	String bpass = request.getParameter("bpass");
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	String bip = request.getParameter("bip");
	
	try{
		Connection conn = null;   PreparedStatement pstmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mbasic";
	    String sql = "insert into users (nickname, bpass, email, mobile, bip) values (?,?,?,?,?)";
	    conn = DriverManager.getConnection(url , "root","1234");
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, nickname);
	    pstmt.setString(2, bpass);
	    pstmt.setString(3, email);
	    pstmt.setString(4, mobile);
	    pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
	    
	    int result = pstmt.executeUpdate();  // insert, update, delete 실행한 줄 수
		//4. jsp012_milks.jsp로 돌아가기	 - 알림창				주소표시창줄
		if(result>0){ 
			out.println("<script> alert('가입 성공'); location.href='list.jsp'; </script>"); 
		} else{ 
			out.println("<script> alert('관리자에게 문의해주세요'); history.go(-1); </script>"); 
		}
		
		if(pstmt != null){ pstmt.close();}
		if(conn != null){ conn.close();}
		
	}catch(Exception e){e.printStackTrace();}
%>