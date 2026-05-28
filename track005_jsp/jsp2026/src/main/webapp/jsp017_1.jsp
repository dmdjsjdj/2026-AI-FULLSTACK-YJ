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
     <div class="container card  my-5">
      <h3 class="card-header"> 클라이언트측(브라우저)에 저장되는 정보 </h3>
      <table  class="table table-striped table-bordered table-hover my-3">
         <caption>cookie 상태확인</caption>
         <tbody> 
         </tbody>
      </table>
      <div>
         <a href="jsp017_cookie2.jsp" class="btn  btn-danger">쿠키저장</a> 
         <a href="jsp017_cookie3.jsp" class="btn  btn-danger">쿠키삭제</a> 
      </div>
   </div>
</body>
</html>