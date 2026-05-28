<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">회원가입결과</h3>
      
<pre>
<%=request.getAttribute("nickname") %>
<%=request.getAttribute("email") %>
<%=request.getAttribute("mobile") %>
</pre>
      <!-- nickname ,  email , mobile -->
         <%-- <div class="my-3">
            <label for="nickname"  class="form-label">닉네임</label>
            <input type="text" class="form-control"  
            		id="nickname"  value="<%=request.getAttribute("nickname") %>" name="nickname" readonly/>
         </div>
         <div class="my-3">
            <label for="email"  class="form-label">이메일</label>
            <input type="text" class="form-control"  
            		id="email"  value="<%=request.getAttribute("email") %>"  name="email" readonly/>
         </div>
         <div class="my-3">
            <label for="mobile"  class="form-label">휴대폰</label>
            <input type="text" class="form-control"  
            		id="mobile" value="<%=request.getAttribute("mobile") %>"  name="mobile" readonly/>
         </div> --%>
   </div>
</body>
</html>