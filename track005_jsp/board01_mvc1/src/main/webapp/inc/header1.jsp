<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MVC1-BOARD</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    <link href="./css/board.css" rel="stylesheet">
</head>
<body>
    <!--  header  -->
    <header>
        <div class="p-5 bg-info text-white text-center myvisual">
            <h1>THEJOA703</h1>
            <p>MVC1 JSP PROJECT</p>
        </div> 
        <nav class="navbar navbar-expand-sm navbar-dark bg-primary">
            <h2  class="myhidden">주메뉴</h2>
            <div class="container-fluid">
                <a class="navbar-brand" href="list.jsp">Logo</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav ms-auto">
                <!-- 애플리케이션 루트기준 -->
                <%
                request.setCharacterEncoding("UTF-8");
        		response.setContentType("text/html; charset=UTF-8"); 
        		String email = (String)session.getAttribute("email");
        		String nickname = "";
        		// 2. sql - 내정보 가져오기
        		PreparedStatement pstmt2 =null;	ResultSet rset2 = null; Connection conn2 = null;
        		String url = "jdbc:mysql://localhost:3306/mbasic";
        	    String sql = "SELECT *, count(*) cnt FROM users where email=?";	
        		try{
        	    	  Class.forName("com.mysql.cj.jdbc.Driver");
        	    	  conn2 = DriverManager.getConnection(url, "root", "1234");
        			  pstmt2 = conn2.prepareStatement(sql);
        			  pstmt2.setString(1, email);
        		      //select- executeQuery/ insert, update, delete- executeUpdate
        			  rset2 = pstmt2.executeQuery(); //표
        			  
        			  if(rset2.next()){
        				  request.setAttribute("nickname", rset2.getString("nickname"));
        			  }
        			  // 3. mypage.jsp로 경로 넘기기
        			  request.getRequestDispatcher("mypage.jsp").forward(request, response);
        			  if(rset2   != null) { rset2.close();   }
        			  if(pstmt2 != null){ pstmt2.close();}
        			  if(conn2 != null){ conn2.close();}
        	      } catch(Exception e) {  e.printStackTrace(); }
        		
                if(email == null){
                	out.println(	
                    "<li class='nav-item'>"+
                    "<a class='nav-link' href='JoinAction'>login</a>"+
                    "</li>"+
                    "<li class='nav-item'>"+
                    "<a class='nav-link' href='LoginAction'>join</a>"+
                    "</li>");
                }
                
                if(email != null){
                	out.println(	
                    "<li class='nav-item'>"+
                    "<a class='nav-link' href='MyAction'>mypage</a>"+
                    "</li>" );
                    if(nickname.equals("admin")){out.println("<li class='nav-item'>"+
                    "<a class='nav-link' href='Users'>users</a>"+
                    "</li>");}
                   
                }
                  %>
                </ul> 
                </div>
            </div>
        </nav>
    </header>
    <!--  header -->
    <!--  header -->
    <!--  header -->
    <!--  header -->
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->

    