<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->
    <div class="container my-5">
        <h3 >글 삭제 </h3>
        <%
		    String bno = request.getParameter("bno"); 
		
		%>
        <form  action ="delete_action.jsp"  method="post"   onsubmit="return checkForm()">
	         <input type="hidden" name="bno" value="<%=bno%>" />
	         <div  class="my-3">
	            <label for="bpass"   class="form-label">비밀번호</label>
	            <input type="password"   class="form-control"    id="bpass"  name="bpass"  />
	         </div>
	         <div  class="my-3  text-end"> 
	            <button type="reset"   class="btn btn-outline-primary"  title="글취소">취소</button>
	            <a href='list.jsp'             class="btn btn-outline-success"  title="목록보러가기">목록</a>
	            <button type="submit"  class="btn btn-primary"  title="글삭제">글삭제</button>
	         </div>
	      </form> 
        
        <script>
			function checkForm(){
			    let pass = document.getElementById("bpass");
				if(pass.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요."); pass.focus();
			    return true;
			}
		</script>
   </div>
	<!--  jasp014_footer.jsp -->
    <!--  jasp014_footer.jsp -->
<%@include file="inc/footer.jsp" %>