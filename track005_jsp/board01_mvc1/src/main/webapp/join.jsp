<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->
    <!-- content -->
   <div class="container card my-5">
      <h3 class="card-header">회원가입</h3>
      <%
       nickname = (String)session.getAttribute("nickname");
		
      if(nickname != null){
          out.println("<script> alert('로그인중인 사용자입니다'); location.href='list.jsp'; </script>");
      }
      %>
       <form  action ="join_action.jsp"  method="post"   onsubmit="return joinmember()">
	         <div  class="my-3">
	            <label for="nickname"   class="form-label">닉네임</label>
	            <input type="text"   class="form-control"    id="nickname"  name="nickname"  />
	         </div> 
	         <div  class="my-3">
	            <label for="bpass"   class="form-label">비밀번호</label>
	            <input type="password"   class="form-control"    id="bpass"  name="bpass"  />
	         </div>
	         <div  class="my-3">
	            <label for="email"  class="form-label">이메일</label>
	            <input type="email"   class="form-control"    id="email"  name="email"  />
	         </div>
	         <div  class="my-3">
	            <label for="mobile"  class="form-label">휴대폰</label>
	            <input type="tel" class="form-control"    id="mobile"  name="mobile" />
	         </div>
	         <div  class="my-3  text-end"> 
	            <button type="reset"   class="btn btn-outline-primary"  title="가입취소">취소</button>
	            <button type="submit"  class="btn btn-primary"  title="회원가입">가입하기</button>
	         </div>
	      </form> 
        
        <script>
			function joinmember(){
			
			    let nickname = document.getElementById("nickname");
			    let bpass = document.getElementById("bpass");
			    let email = document.getElementById("email");
			    let mobile = document.getElementById("mobile");
			
			    if(nickname.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요."); nickname.focus(); return false; }
			    if(bpass.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요."); bpass.focus(); return false; } 
			    if(email.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요."); email.focus(); return false; } 
			    if(mobile.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요."); mobile.focus(); return false; }
			    
			    return true;
			}
		</script>
   </div>
	<!--  jasp014_footer.jsp -->
    <!--  jasp014_footer.jsp -->
<%@include file="inc/footer.jsp" %>