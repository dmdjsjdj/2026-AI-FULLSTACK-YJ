<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
	request.setCharacterEncoding("UTF-8");
	//2. request.getParameter() 이용해서 데이터 받기
	String bname = request.getParameter("bname");
	String bpass = request.getParameter("bpass");
	String btitle = request.getParameter("btitle");
	String bcontent = request.getParameter("bcontent");
	String bip = request.getParameter("bip");
	
	//3. insert 구문처리
	try{
		Connection conn = null;  PreparedStatement pstmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mbasic";
	    String sql = "insert into mvcboard1 (bname, bpass, btitle, bcontent, bip) values (?,?,?,?,?)";
	    conn = DriverManager.getConnection(url , "root","1234");
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, bname);
	    pstmt.setString(2, bpass);
	    pstmt.setString(3, btitle);
	    pstmt.setString(4, bcontent);
	    pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
	    
	    int result = pstmt.executeUpdate();  // insert, update, delete 실행한 줄 수
		//4. jsp012_milks.jsp로 돌아가기	 - 알림창				주소표시창줄
		if(result>0){ 
			out.println("<script> alert('글쓰기 성공'); location.href='list.jsp'; </script>"); 
		} else{ 
			out.println("<script> alert('관리자에게 문의해주세요'); location.href='list.jsp'; </script>"); 
		}
		
		if(pstmt != null){ pstmt.close();}
		if(conn != null){ conn.close();}
	}catch(Exception e){e.printStackTrace();}

%>