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
   <div class="container card my-5 text-white bg-primary">
    	<h2 class="card-header"> Milks Search </h2>
       	<p> </p>
       	
       	<table class="table table-bordered table-striped table-hover">
       		<caption class="caption-top text-white">우유메뉴</caption>
	        <thead >
	            <tr>
	                <th scope="col">NO</th>
	                <th scope="col">NAME</th>
	                <th scope="col">PRICE</th>
	            </tr>
	        </thead>
	
	        <tbody>
	        <%@ page import="java.sql.*" %>
	        <%
	        String ono3 = request.getParameter("ono3");
	        
		      try{
			      //1. 드라이버로딩 필요한 코드? Class.forName()
		    	  Class.forName("com.mysql.cj.jdbc.Driver");
		    	  PreparedStatement pstmt =null;	ResultSet rset = null; Connection conn = null;
			      //2. JDBC 연동 필요한 코드? DriverManager.getConnection()
		    	  conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mbasic", "root", "1234");
			      ///////////////////////////////////////////////
			      
			      pstmt = conn.prepareStatement("SELECT * FROM milk WHERE mno = ?");
			      pstmt.setString(1, ono3);
				  rset = pstmt.executeQuery();
			      
				  while( rset.next() ){
						out.println("<tr><td>" + rset.getInt("mno") + "</td><td>" 
							+ rset.getString("mname")  + "</td><td>" 
							+ rset.getInt("mprice") + "</td></tr>"   );  // 칸 rset.getInt("필드명")
					}
			      ///////////////////////////////////////////////
			      //3. JDBC 끊기 필요한 코드? conn.close()
			       if(rset   != null) { rset.close();   }
     			   if(pstmt  != null) { pstmt.close();  }
				   if(conn  != null) { conn.close();  }
		      } catch(Exception e) {  e.printStackTrace(); }
		      %>
	        </tbody>
	    </table>
	    <button type="button" class="btn btn-info" onclick="history.back();">뒤로가기</button>
	    
   	</div>
</body>
</html>