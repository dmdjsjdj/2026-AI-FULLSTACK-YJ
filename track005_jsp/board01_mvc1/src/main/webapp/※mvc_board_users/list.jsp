<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->
    <!-- content -->
    <form class="d-flex justify-content-end gap-2 my-2">
        <input class="form-control" type="text" id="sercht"
        	   placeholder="Search" style="width: 250px;"  onkeyup="filtert()">
        <button class="btn btn-primary" type="button">Search</button>
    </form>
    <section class="container my-5">
        <h3> 글 목록 </h3>
        <table 
            class="table table-striped table-bordered table-hover " id="usertable" >
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
		    	  pstmt = conn.prepareStatement("SELECT b.*, (SELECT COUNT(*) FROM mvcboard1) `cnt` FROM mvcboard1 b ORDER BY bno DESC" , 
	                       ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                       ResultSet.CONCUR_READ_ONLY);
		    	 /*  PreparedStatement cntStmt = conn.prepareStatement( "select count(*) cnt from mvcboard1" );
				  ResultSet cntrs = cntStmt.executeQuery();
	    		  int num = 0;
	
	    		  if(cntrs.next()){ num = cntrs.getInt("cnt"); }
	    		  if(cntrs   != null) { cntrs.close();   }
	    		  if(cntStmt   != null) { cntStmt.close();   }
		    	  
			      pstmt = conn.prepareStatement("select * from mvcboard1 order by bno desc");
			      //select- executeQuery/ insert, update, delete- executeUpdate
				  rset = pstmt.executeQuery(); */
				  
				  pstmt = conn.prepareStatement("SELECT b.*, (SELECT COUNT(*) FROM mvcboard1) `cnt` FROM mvcboard1 b ORDER BY bno DESC");
			      //select- executeQuery/ insert, update, delete- executeUpdate
				  rset = pstmt.executeQuery(); //표
				  int num = 0;
					
	    		  if(rset.next()){ 
	    			  num = rset.getInt("cnt"); 
					  do {
							out.println("<tr><td>" 
					  					+ (num--) + "</td><td>" 
					  					+ "<a href='detail.jsp?bno=" + rset.getInt("bno") + "' style='text-decoration:none; color:inherit;'>" + rset.getString("btitle") + "</a></td><td>" 
										+ rset.getString("bname")  + "</td><td>" 
										+ rset.getString("bdate")  + "</td><td>" 
										+ rset.getInt("bhit")      + "</td></tr>"   ); 
						}while( rset.next() );
	    		  }
	    		  
	    		  int cnt = -1;
					
	    		  if(rset.next()){ 
	    			  cnt = rset.getInt("cnt"); //칸
					  rset.beforeFirst();  //다시 처음으로 표부터 처리
	    		  }
	    		  while( rset.next() ){
						out.println("<tr><td>" 
				  					+ (cnt--) + "</td><td>" 
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
    <script>
 // 검색 필터 
    function filtert(){
      let keyword = document.getElementById("sercht").value.toLowerCase();
      document.querySelectorAll("#usertable tbody tr").forEach(tr=>{
        tr.style.display = tr.innerText.toLowerCase().includes(keyword) ? "" : "none";
      });
    }
    window.onload = loadXml;
    </script>
	<!--  jasp014_footer.jsp -->
    <!--  jasp014_footer.jsp -->
<%@include file="inc/footer.jsp" %>