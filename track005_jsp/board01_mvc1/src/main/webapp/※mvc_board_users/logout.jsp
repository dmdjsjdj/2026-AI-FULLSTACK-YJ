<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	session.invalidate();
	out.println("<script> alert('로그아웃 성공'); location.href='list.jsp'; </script>");
%>