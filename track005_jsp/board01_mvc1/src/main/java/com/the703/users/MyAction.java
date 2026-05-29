package com.the703.users;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyAction() { super(); }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		// 1. 로그인한 정보 확인
		HttpSession session = request.getSession(); 
		String email = (String)session.getAttribute("email");
		
		// 로그인이 안 되어 있는 경우 예외 처리 (방어 코드)
		if (email == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		// 2. sql - 내정보 가져오기 (count(*) cnt 구문 제거)
		PreparedStatement pstmt = null;	
		ResultSet rset = null; 
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/mbasic";
	    String sql = "SELECT * FROM users WHERE email = ?";	
	    
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  conn = DriverManager.getConnection(url, "root", "1234");
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, email);
			  
			  rset = pstmt.executeQuery();
			  
			  if (rset.next()) {
				  request.setAttribute("nickname", rset.getString("nickname"));
				  request.setAttribute("email", rset.getString("email"));
				  request.setAttribute("mobile", rset.getString("mobile"));
				  request.setAttribute("udate", rset.getString("udate"));
				  request.setAttribute("bip", rset.getString("bip"));
			  }
			  
			  // 3. 데이터를 담아 mypage.jsp로 이동
			  request.getRequestDispatcher("mypage.jsp").forward(request, response);
			  
	      } catch(Exception e) {  
	    	  e.printStackTrace(); 
	      } finally {
	    	  // 4. 어떤 상황에서든 데이터베이스 자원이 확실히 닫히도록 예외 처리
	    	  try { if(rset != null) rset.close(); } catch(Exception e) {}
	    	  try { if(pstmt != null) pstmt.close(); } catch(Exception e) {}
	    	  try { if(conn != null) conn.close(); } catch(Exception e) {}
	      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}
}
