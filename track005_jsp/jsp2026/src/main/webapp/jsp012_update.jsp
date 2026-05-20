<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
request.setCharacterEncoding("UTF-8");
//2. request.getParameter() 이용해서 데이터 받기
int ono1 = Integer.parseInt(request.getParameter("ono1"));
String oname1 = request.getParameter("oname1");
int onum1 = Integer.parseInt(request.getParameter("onum1"));
out.println(oname1 + " / " + onum1);

//3. insert 구문처리
try{
	Connection conn = null;  PreparedStatement pstmt = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/mbasic";
    String sql = "update milk_order set oname=?, onum=? where ono=?";
    conn = DriverManager.getConnection(url , "root","1234");
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, oname1);
    pstmt.setInt(2, onum1);
    pstmt.setInt(3, ono1);
    
    int result = pstmt.executeUpdate();  // insert, update, delete 실행한 줄 수
	//4. jsp012_milks.jsp로 돌아가기	 - 알림창				주소표시창줄
	if(result>0){ 
		out.println("<script> alert('주문수정 성공했습니다'); location.href='jsp012_milks.jsp'; </script>"); 
	} else{ 
		out.println("<script> alert('관리자에게 문의해주세요'); location.href='jsp012_milks.jsp'; </script>"); 
	}
	
	if(pstmt != null){ pstmt.close();}
	if(conn != null){ conn.close();}
}catch(Exception e){e.printStackTrace();}

%>