<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt(request.getParameter("bno"));
	String bpass = request.getParameter("bpass");
	
	try{
		Connection conn = null;  PreparedStatement pstmt = null; ResultSet rs = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mbasic";
	    String delsql = "delete from mvcboard1 where bno=?  and  bpass=?";
	    conn = DriverManager.getConnection(url , "root","1234");
	    	pstmt = conn.prepareStatement(delsql);
		    pstmt.setInt(1, bno);
		    pstmt.setString(2, bpass);
	    int result = pstmt.executeUpdate();  
	    
	    if(result>0){ 
			out.println("<script> alert('글삭제 성공'); location.href='list.jsp'; </script>"); 
		} else{ 
			out.println("<script> alert('비밀번호가 다릅니다'); location.href='list.jsp'; </script>"); 
		}
		
		if(pstmt != null){ pstmt.close();}
		Statement stmt = conn.createStatement();
	    stmt.execute("SET @COUNT = 0");
	    stmt.execute( "update mvcboard1 set bno = @count:=@count+1" );
	    // AUTO_INCREMENT 재설정
	    stmt.execute( "alert table mvcboard1 auto_increment = 1" );
	    stmt.close();
		if(conn != null){ conn.close();}
	}catch(Exception e){e.printStackTrace();}

%>