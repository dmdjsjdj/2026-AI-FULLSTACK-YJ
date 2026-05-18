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
   <!-- jsp007_result.jsp -->
   <div class="container card my-5">
	    <h3 class="card-header">MY SCORE</h3>
	
	    <%
	        int ko = Integer.parseInt(request.getParameter("ko"));
	        int en = Integer.parseInt(request.getParameter("en"));
	        int ma = Integer.parseInt(request.getParameter("ma"));
	
	        int total = ko + en + ma;
	        double avg = total / 3.0;
	    %>
	
	    <table class="table table-bordered text-center table-striped table-hover">
	        <thead class="table-info">
	            <tr>
	                <th scope="col">KOR</th>
	                <th scope="col">ENG</th>
	                <th scope="col">MATH</th>
	                <th scope="col">TOTAL</th>
	                <th scope="col">AVG</th>
	            </tr>
	        </thead>
	
	        <tbody>
	            <tr>
	                <td><%=ko%></td>
	                <td><%=en%></td>
	                <td><%=ma%></td>
	                <td><%=total%></td>
	                <td><%=String.format("%.2f", avg)%></td>
	            </tr>
	        </tbody>
	    </table>
	
	    <p class="text-end">
	        <a href="javascript:history.go(-1)" class="btn btn-danger">
	            BACK
	        </a>
	    </p>
	</div>
</body>
</html>