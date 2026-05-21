<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
//1. utf-8
	request.setCharacterEncoding("UTF-8");
//2. userage 나이 넘어오는 데이터 확인
	int age = Integer.parseInt(request.getParameter("userage"));
	out.println(age);
//3. 만약 19세 미만-jsp013_child.jsp파일 넘기기(sendRedirect)
									 //jsp013_child.jsp만 적으면 null값으로 넘어감
								//  쿼리스트링   주소?name1=value1&name2=value2
	if(age<19){ response.sendRedirect("jsp013_child.jsp?userage="+age); }
//아니라면 jsp013_adult.jsp(경로 안보이게 Dispatcher)
	else if(age>=19){ request.getRequestDispatcher("jsp013_adult.jsp").forward(request, response); }
%>