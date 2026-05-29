<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->
    <!-- content -->
   <div class="container my-5">
      <h3>마이페이지</h3>
      <!-- 
      3. Mypage
		> 마이페이지 - Get 
		1) 처리서블릿   : MyAction
		2) 로그인한정보로 서버에서 해당이메일의 정보가져오기
		3) 처리후  mypage.jsp로 사용자 정보 넘겨주기
       -->
       <table 
            class="table table-striped table-bordered table-hover " id="usertable" >
            <caption> 내 정보 </caption>
            <thead>
            <tr>
                <th scope="col">NO</th>
                <th scope="col">NAME</th>
                <th scope="col">EMAIL</th>
                <th scope="col">DATE</th>
                <th scope="col">MOBILE</th>
                <th scope="col">IP</th>
            </tr>
            </thead>
            
           <tbody>
           
           <c:if test="${not empty userList}">
                <c:forEach var="user" items="${userList}" varStatus="status">
                <tr>
	           		<td scope="col"> ${status.count} </td>
	           		<td scope="col"> ${user.nickname} </td>
	           		<td scope="col"> ${user.email} </td>
	           		<td scope="col"> ${user.udate} </td>
	           		<td scope="col"> ${user.mobile} </td>
	           		<td scope="col"> ${user.bip} </td>
	           	</tr>
           		</c:forEach>
           	</c:if>
          
           </tbody>
        </table>
        <div class="text-end">
        	<a href="Logout" title="로그아웃" class="btn btn-danger ">로그아웃</a>
            <a href="mytable.jsp" title="내가 쓴 글" class="btn btn-primary ">내가 쓴 글</a>
        </div>
   </div>
	<!--  jasp014_footer.jsp -->
    <!--  jasp014_footer.jsp -->
<%@include file="inc/footer.jsp" %>