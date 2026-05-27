<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>
    <!--  jasp014_header.jsp -->
    <!--  jasp014_header.jsp -->
    <!-- content -->
    <form class="d-flex justify-content-end gap-2 my-2">
        <input class="form-control" type="text" id="sercht"
        	   placeholder="Search" style="width: 250px;"  onkeyup="myfiltert()">
        <button class="btn btn-primary" type="button">Search</button>
    </form>
    <section class="container my-5">
        <h3> 내가 쓴 글 목록 </h3>
        <table 
            class="table table-striped table-bordered table-hover " id="mytable" >
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
            
	            nickname = (String)session.getAttribute("nickname");
	            
		        if(nickname == null){
		            out.println("<script> alert('로그인이 필요합니다'); location.href='login.jsp'; </script>");
		        }
            
		      try{
		    	  Class.forName("com.mysql.cj.jdbc.Driver");
		    	  PreparedStatement pstmt =null;	ResultSet rset = null; Connection conn = null;
		    	  conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mbasic", "root", "1234");
		    	  pstmt = conn.prepareStatement("SELECT b.*, (SELECT COUNT(*) FROM mvcboard1 where bname=?) cnt FROM mvcboard1 b where b.bname=? ORDER BY bno DESC" 
		    			  , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    	  
		    	  /* pstmt = conn.prepareStatement("SELECT b.*, (SELECT COUNT(*) FROM mvcboard1) `cnt` FROM mvcboard1 b where bname=? ORDER BY bno DESC"); */
			      pstmt.setString(1, nickname);
			      pstmt.setString(2, nickname);
				  //select- executeQuery/ insert, update, delete- executeUpdate
				  rset = pstmt.executeQuery(); //표
	    		  
	    		  int cnt = -1;
					
	    		  if(rset.next()){ 
	    			  cnt = rset.getInt("cnt"); //칸
					  rset.beforeFirst();  //다시 처음으로 표부터 처리
	    		  }
	    		  while( rset.next() ){
						out.println("<tr><td>" 
				  					+ (cnt--) + "</td><td>" 
				  					+ "<a href='detail.jsp?bno=" + rset.getInt("bno") + "' style='text-decoration:none; color:inherit;'>" + rset.getString("btitle") + "</a></td><td>" 
									+ nickname  + "</td><td>" 
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
        	<a href="javascript:history.go(-1)" title="뒤로가기" class="btn btn-info "> ← </a>
            <a href="write.jsp" title="글쓰기 폼" class="btn btn-primary ">글쓰기</a>
        </div>
    </section>
    <script>
 // 검색 필터 
    function myfiltert(){
      let keyword = document.getElementById("sercht").value.toLowerCase();
      document.querySelectorAll("#mytable tbody tr").forEach(tr=>{
        tr.style.display = tr.innerText.toLowerCase().includes(keyword) ? "" : "none";
      });
    }
    </script>
	<!--  jasp014_footer.jsp -->
    <!--  jasp014_footer.jsp -->
<%@include file="inc/footer.jsp" %>