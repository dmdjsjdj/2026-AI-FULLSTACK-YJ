<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
	session.removeAttribute("userage");

	// response.sendRedirect("jsp015_1_session.jsp");  alert x
	out.println("<script> location.href='jsp015_1_session.jsp'; </script>"); // alert o
%>