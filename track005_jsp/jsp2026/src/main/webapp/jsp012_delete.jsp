<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
request.setCharacterEncoding("UTF-8");
int ono2 = Integer.parseInt(request.getParameter("ono2"));

//3. insert 구문처리
try{
	Connection conn = null;  PreparedStatement pstmt = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/mbasic";
    String sql = "delete from milk_order where ono=?";
    conn = DriverManager.getConnection(url , "root","1234");
    pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, ono2);
    
    int result = pstmt.executeUpdate();  // insert, update, delete 실행한 줄 수
	//4. jsp012_milks.jsp로 돌아가기	 - 알림창				주소표시창줄
	if(result>0){ 
		out.println("<script> alert('주문삭제 성공했습니다'); location.href='jsp012_milks.jsp'; </script>"); 
	} else{ 
		out.println("<script> alert('관리자에게 문의해주세요'); location.href='jsp012_milks.jsp'; </script>"); 
	}
	
	if(pstmt != null){ pstmt.close();}
	Statement stmt = conn.createStatement();
    stmt.execute("SET @COUNT = 0");
    stmt.execute( "UPDATE milk_order SET ono = @COUNT:=@COUNT+1" );
    // AUTO_INCREMENT 재설정
    stmt.execute( "ALTER TABLE milk_order AUTO_INCREMENT = 1" );
    stmt.close();
	if(conn != null){ conn.close();}
}catch(Exception e){e.printStackTrace();}

%>