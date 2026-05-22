<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->
    <!-- content -->
    <form class="d-flex">
        <input class="form-control my-2" type="text" placeholder="Search">
        <button class="btn btn-primary" type="button">Search</button>
    </form>
    <section class="container my-5">
        <h3> 글 목록 </h3>
        <table 
            class="table table-striped table-bordered table-hover " >
            <caption> 글 목록 </caption>
            <thead>
            <tr>
                <th scope="col">NO</th>
                <th scope="col">TITLE</th>
                <th scope="col">WRITER</th>
                <th scope="col">DATE</th>
                <th scope="col">HIT</th>
            </tr>
            </thead>
            <tbody>
            <%
		      try{
		    	  Class.forName("com.mysql.cj.jdbc.Driver");
		    	  PreparedStatement pstmt =null;	ResultSet rset = null; Connection conn = null;
		    	  conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mbasic", "root", "1234");
			      
			      pstmt = conn.prepareStatement("select * from mvcboard1");
			      //select- executeQuery/ insert, update, delete- executeUpdate
				  rset = pstmt.executeQuery();
			      
				  while( rset.next() ){
						out.println("<tr><td>" 
				  					+ rset.getInt("bno") + "</td><td>" 
				  					+ "<a href='detail.jsp?bno=" + rset.getInt("bno") + "' style='text-decoration:none; color:inherit;'>" + rset.getString("btitle") + "</a></td><td>" 
									+ rset.getString("bname")  + "</td><td>" 
									+ rset.getString("bdate")  + "</td><td>" 
									+ rset.getInt("bhit")      + "</td></tr>"   ); 
					}
			       if(rset   != null) { rset.close();   }
     			   if(pstmt  != null) { pstmt.close();  }
				   if(conn  != null) { conn.close();  }
		      } catch(Exception e) {  e.printStackTrace(); }
		      %>
            </tbody>
        </table>
        <div class="text-end">
            <a href="write.jsp" title="글쓰기 폼" class="btn btn-primary ">글쓰기</a>
        </div>
    </section>
	<!--  jasp014_footer.jsp -->
    <!--  jasp014_footer.jsp -->
<%@include file="inc/footer.jsp" %>