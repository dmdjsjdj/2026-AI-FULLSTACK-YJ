<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>MILK</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- 		header			 -->
<!-- 		header			 -->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_jumbotron.php -->
<div class="p-5 bg-primary text-white">
  <h1>MILK ORDER Project</h1>
  <p>MVC1 - PreparedStatement Ex</p>
</div>

<!-- 		메뉴판테이블			 -->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_tables.php -->
   	<div class="container card my-5 text-white bg-primary">
    	<h2 class="card-header"> Milks Menu </h2>
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
	        
	        <%
		      try{
			      //1. 드라이버로딩 필요한 코드? Class.forName()
		    	  Class.forName("com.mysql.cj.jdbc.Driver");
		    	  PreparedStatement pstmt =null;	ResultSet rset = null; Connection conn = null;
			      //2. JDBC 연동 필요한 코드? DriverManager.getConnection()
		    	  conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mbasic", "root", "1234");
			      ///////////////////////////////////////////////
			      
			      pstmt = conn.prepareStatement("select * from milk");
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
   	</div>
<!-- 		메뉴판테이블			 -->

<!-- 		주문현황표			 -->   	
   	<div class="container card my-5 text-white bg-secondary">
    	<h3 class="card-header"> Milks ORDER </h3>
    	<table class="table table-striped ">
    		<caption class="caption-top text-white">주문내역</caption>
	        <thead>
	            <tr>
	                <th >NO</th>
	                <th >NAME</th>
	                <th >NUM</th>
	                <th >주문날짜</th>
	            </tr>
	        </thead>
	        
	        <tbody>
	        <%
		      try{
			      //1. 드라이버로딩 필요한 코드? Class.forName()
		    	  Class.forName("com.mysql.cj.jdbc.Driver");
		    	  PreparedStatement pstmt =null;	ResultSet rset = null; Connection conn = null;
			      //2. JDBC 연동 필요한 코드? DriverManager.getConnection()
		    	  conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mbasic", "root", "1234");
			      ///////////////////////////////////////////////
			      pstmt = conn.prepareStatement("select * from milk_order");
				  rset = pstmt.executeQuery();
				  while( rset.next() ){
						out.println("<tr><td>" + rset.getString("ono") + "</td><td>" 
							+ rset.getString("oname")  + "</td><td>" 
							+ rset.getInt("onum") + "</td><td>" 
							+ rset.getString("odate") + "</td></tr>"  );  // 칸 rset.getInt("필드명")
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
    </div>
<!-- 		주문현황표			 -->

<!-- 		주문 삽입, 수정, 삭제			 -->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_collapse.php -->
	<div id="accordion">
         <div class="card">
            <div class="card-header text-white bg-success">
               <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
                  주문하기 </a>
            </div>
            <div id="collapseOne" class="collapse show"
               data-bs-parent="#accordion">
               <div class="card-body">
				<form  action="Milk.jsp"  method="post"  onsubmit="return check()">
					<div class="my-3">
						<label for="mname"   class="form-label">주문할 우유이름 : </label>
						<input type="text"  class="form-control"  id="mname"  name="oname"/>      
					</div>
					<div class="my-3">
						<label for="mnum"   class="form-label">주문할 우유갯수 : </label>
						<input type="number"  class="form-control"  id="mnum"  name="onum"
						min="0"   max="100" />      
					</div>
					<div class="my-3"  style="text-align:right" > 
						<button type="submit"    class="btn btn-primary" 
							  title="주문하기">주문하기</button>
					</div>	
				</form>
				<script>
					function check(){
			      		let name = document.getElementById("mname");
			      		let num = document.getElementById("mnum");
			      		if(name.value.trim() == ""){
			      			alert("이름을 입력해주세요");
			      			name.focus();
			      			return false;
			      		} 
			      		if(num.value.trim() == ""){
			      			alert("갯수를 입력해주세요");
			      			num.focus();
			      			return false;
			      		}
			      		
			      		return true;
			      	}
			      </script>
			</div>
		</div>
			<%
			try{
				String name = request.getParameter("oname");
				String num = request.getParameter("onum");
				if(name != null && num != null){
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection conn = DriverManager.getConnection( 
				    			"jdbc:mysql://localhost:3306/mbasic", "root", "1234" );
				    PreparedStatement pstmt = conn.prepareStatement( 
				    				"insert into milk_order (oname, onum, oip) values (?, ?, ?)" );
	
				    pstmt.setString(1, name);
				    pstmt.setInt(2, Integer.parseInt(num));
				    pstmt.setString(3, InetAddress.getLocalHost().getHostAddress());
				    pstmt.executeUpdate();
	
				    pstmt.close();
				    conn.close();
				    response.sendRedirect("Milk.jsp");
				    return;
				}
			}catch(Exception e){
			    e.printStackTrace();
			}
			%>
		</div>
		
		<div class="card">
            <div class="card-header text-white bg-success">
               <a class="collapsed btn" data-bs-toggle="collapse"
                  href="#collapseTwo"> 주문 수정 </a>
            </div>
            <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
				<form  action="Milk.jsp"  method="post"  onsubmit="return check2()">
					<div class="my-3">
						<label for="ono"   class="form-label">수정할 번호 : </label>
						<input type="number"  class="form-control"  id="ono"  name="ono"/>      
					</div>
					<div class="my-3">
						<label for="oname"   class="form-label">수정할 우유이름 : </label>
						<input type="text"  class="form-control"  id="oname"  name="oname1"/>      
					</div>
					<div class="my-3">
						<label for="mnum"   class="form-label">수정할 우유갯수 : </label>
						<input type="number"  class="form-control"  id="onum"  name="onum1"
						min="0"   max="100" />      
					</div>
					<div class="my-3"  style="text-align:right" > 
						<button type="submit"    class="btn btn-primary" 
							  title="수정하기">수정하기</button>
					</div>	
				</form>
				<script>
				function check2(){
				
				    let name1 = document.getElementById("oname1");
				    let num1 = document.getElementById("onum1");
				    let no1 = document.getElementById("ono");
				
				    if(no1.value.trim() == ""){
				        alert("주문번호 입력");
				        no1.focus();
				        return false;
				    }
				    if(name1.value.trim() == ""){
				        alert("이름 입력");
				        name1.focus();
				        return false;
				    }
				
				    if(num1.value.trim() == ""){
				        alert("수량 입력");
				        num1.focus();
				        return false;
				    }
				
				    return true;
				}
				</script>
			</div>
			<%
			try{
				String oname = request.getParameter("oname1");
				String onum = request.getParameter("onum1");
				String ono = request.getParameter("ono");
				if(oname != null && onum != null){
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection conn = DriverManager.getConnection( 
				    			"jdbc:mysql://localhost:3306/mbasic", "root", "1234" );
				    PreparedStatement pstmt = conn.prepareStatement( 
				    				"update milk_order set oname=?, onum=? where ono=?" );
	
				    pstmt.setString(1, oname);
				    pstmt.setInt(2, Integer.parseInt(onum));
				    pstmt.setInt(3, Integer.parseInt(ono));
				    pstmt.executeUpdate();
					
				    pstmt.close();
				    conn.close();
				    response.sendRedirect("Milk.jsp");
				    return;
				}
			}catch(Exception e){
			    e.printStackTrace();
			}
			%>
		</div>
		
		<div class="card">
            <div class="card-header text-white bg-success">
               <a class="collapsed btn" data-bs-toggle="collapse"
                  href="#collapseThree"> 주문 삭제 </a>
            </div>
            <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
				<form  action="Milk.jsp"  method="post"  onsubmit="return check3()">
					<div class="my-3">
						<label for="ono"   class="form-label">삭제할 번호 : </label>
						<input type="number"  class="form-control"  id="ono1"  name="ono1"/>      
					</div>
					<div class="my-3"  style="text-align:right" > 
						<button type="submit"    class="btn btn-primary" 
							  title="삭제하기">삭제하기</button>
					</div>
				</form>
				<script>
				function check3(){
				    let no2 = document.getElementById("ono1");
				
				    if(no2.value.trim() == ""){
				        alert("주문번호 입력");
				        no2.focus();
				        return false;
				    }
				
				    return true;
				}
				</script>
			</div>
			<%
			try{
				String ono1 = request.getParameter("ono1");
				if(ono1 != null){
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection conn = DriverManager.getConnection( 
				    			"jdbc:mysql://localhost:3306/mbasic", "root", "1234" );
				    PreparedStatement pstmt = conn.prepareStatement( 
				    				"delete from milk_order where ono=?" );
	
				    pstmt.setInt(1, Integer.parseInt(ono1));
				    pstmt.executeUpdate();
					
				    pstmt.close();
				    
				    Statement stmt = conn.createStatement();
				    stmt.execute("SET @COUNT = 0");
				    stmt.execute( "UPDATE milk_order SET ono = @COUNT:=@COUNT+1" );
				    // AUTO_INCREMENT 재설정
				    stmt.execute( "ALTER TABLE milk_order AUTO_INCREMENT = 1" );
				    stmt.close();
				    conn.close();
				    
				    response.sendRedirect("Milk.jsp");
				    return;
				}
			}catch(Exception e){
			    e.printStackTrace();
			}
			%>
		</div>
    </div>
</body>
</html>