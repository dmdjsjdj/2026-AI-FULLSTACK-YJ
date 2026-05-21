<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_MILK</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
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
    <div class="container card my-5  bg-warning  text-white ">
      <h2 class="card-header">Milk 주문현황표</h2>  
      <table  class="table table-striped table-bordered table-hover">
         <caption>주문현황표</caption>
         <thead>
         <tr>
            <th scope="col">NO</th>
            <th scope="col">NAME</th>
            <th scope="col">NUM</th>
            <th scope="col">DATE</th>
         </tr>
	      </thead>
	      <tbody>
	      <%@page import="java.sql.*"%>
	      <%
	      try{
	         //1. 드라이버연동 Class.forName
	         Class.forName("com.mysql.cj.jdbc.Driver");
	          
	         Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
	         String url = "jdbc:mysql://localhost:3306/mbasic";
	         String sql = "select * from milk_order";
	         
	         //2. jdbc 연동 DriverManager.getConnection
	         conn = DriverManager.getConnection(url , "root","1234");
	         //3. pstmt 사용sql-처리   pstmt.executeQuery()   
	         pstmt = conn.prepareStatement(sql);
	         rset  = pstmt.executeQuery(); //표  executeQuery(select)   
	                                //   executeUpdate(insert,update,delete)
	         while(rset.next()){ //줄
	            out.println("<tr><td>"+rset.getInt("ono")  //칸
	                  +"</td><td>"+rset.getString("oname")
	                  +"</td><td>"+rset.getInt("onum")
	                  +"</td><td>"+rset.getString("odate")+"</td></tr>");
	         }
	         //4. jdbc close
	         if( rset != null ){ rset.close(); }
	         if( pstmt != null){ pstmt.close();}
	         if( conn != null ){ conn.close(); }
	      }catch(Exception e){e.printStackTrace();   }
	      %>
	      </tbody>
      </table>
   </div>   
   
   <div id="accordion">
         <div class="card">
            <div class="card-header text-white bg-success">
               <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
                  주문하기 </a>
            </div>
            <div id="collapseOne" class="collapse show"
               data-bs-parent="#accordion">
               <div class="card-body">
                  <form action="jsp012_insert.jsp" method="post" onsubmit="return order()">
                     <div class="my-3">
                        <label for="oname" class="form-label">주문할 우유 이름</label>
                        <input type="text" class="form-control" placeholder="주문할 우유 이름을 적어주세요!!" id="oname" name="oname" /> <br>
                     </div>
                     <div class="my-3">
                        <label for="onum" class="form-label">주문할 우유 갯수</label>
                        <input type="number" class="form-control" placeholder="우유 갯수를 적어주세요!!" id="onum" name="onum" />
                     </div>
                     <div class="my-3">
                        <button type="submit" class="btn btn-success" title="주문하기">주문하기</button>
                     </div>
                  </form>
                  <script>
					function order(){
			      		let name = document.getElementById("oname");
			      		let num = document.getElementById("onum");
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
         </div>
         <div class="card">
            <div class="card-header text-white bg-success">
               <a class="collapsed btn" data-bs-toggle="collapse"
                  href="#collapseTwo"> 주문 수정 </a>
            </div>
            <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
               <form  action="jsp012_update.jsp"  method="post"  onsubmit="return order1()">
					<div class="my-3">
						<label for="ono1"   class="form-label">수정할 번호 : </label>
						<input type="number"  class="form-control"  id="ono1"  name="ono1"/>      
					</div>
					<div class="my-3">
						<label for="oname1"   class="form-label">수정할 이름 : </label>
						<input type="text"  class="form-control"  id="oname1"  name="oname1"/>      
					</div>
					<div class="my-3">
						<label for="onum1"   class="form-label">수정할 수량 : </label>
						<input type="number"  class="form-control"  id="onum1"  name="onum1"/>      
					</div>
					<div class="my-3"  style="text-align:right" > 
						<button type="submit"    class="btn btn-primary" 
							  title="수정하기">수정하기</button>
					</div>	
				</form>
				<script>
				function order1(){
				
				    let name1 = document.getElementById("oname1");
				    let num1 = document.getElementById("onum1");
				    let no1 = document.getElementById("ono1");
				
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
         </div>
         <div class="card">
            <div class="card-header text-white bg-success">
               <a class="collapsed btn" data-bs-toggle="collapse"
                  href="#collapseThree"> 주문 삭제 </a>
            </div>
            <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
               <form  action="jsp012_delete.jsp"  method="post"  onsubmit="return order2()">
					<div class="my-3">
						<label for="ono2"   class="form-label">삭제할 번호 : </label>
						<input type="number"  class="form-control"  id="ono2"  name="ono2"/>      
					</div>
					<div class="my-3"  style="text-align:right" > 
						<button type="submit"    class="btn btn-primary" 
							  title="삭제하기">삭제하기</button>
					</div>
				</form>
				<script>
				function order2(){
				    let no2 = document.getElementById("ono2");
				
				    if(no2.value.trim() == ""){
				        alert("주문번호 입력");
				        no2.focus();
				        return false;
				    }
				
				    return true;
				}
				</script>
            </div>
         </div>
         
         <div class="card">
            <div class="card-header text-white bg-success">
               <a class="collapsed btn" data-bs-toggle="collapse"
                  href="#collapseFour"> 메뉴 검색 </a>
            </div>
            <div id="collapseFour" class="collapse" data-bs-parent="#accordion">
               <form  action="jsp012_search.jsp"  method="get"  onsubmit="return order3()">
					<div class="my-3">
						<label for="ono3"   class="form-label">찾는 메뉴번호 : </label>
						<input type="number"  class="form-control"  id="ono3"  name="ono3"/>      
					</div>
					<div class="my-3"  style="text-align:right" > 
						<button type="submit"    class="btn btn-primary" 
							  title="검색하기">검색하기</button>
					</div>
				</form>
				<script>
				function order3(){
				    let no3 = document.getElementById("ono3");
				
				    if(no3.value.trim() == ""){
				        alert("번호 입력");
				        no3.focus();
				        return false;
				    }
				
				    return true;
				}
				</script>
            </div>
         </div>
      </div>
</body>
</html>