package com.the703.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Users() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		// 1. 로그인한 정보 확인
		HttpSession session = request.getSession(); 
		String email = (String)session.getAttribute("email");
		
		// 로그인이 안 되어 있는 경우 
		if (email == null) {
			out.println("<script> alert('로그인이 필요합니다'); location.href='LoginAction'; </script>");
			response.sendRedirect("login.jsp");
			return;
		}
		if(!email.equals("admin@gmail.com")) {
			out.println("<script> alert('관리자가 아닙니다'); location.href='list.jsp'; </script>");
		}

		// 2. sql - 내정보 가져오기
		PreparedStatement pstmt = null;	
		ResultSet rset = null; 
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/mbasic";
	    String sql = "SELECT * FROM users ";	
	    
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  conn = DriverManager.getConnection(url, "root", "1234");
			  pstmt = conn.prepareStatement(sql);
			  
			  rset = pstmt.executeQuery();
			  
			  List<Map<String, Object>> userList = new ArrayList<>();
			  
			  while (rset.next()) {
				  Map<String, Object> map = new HashMap<>();
				  map.put("nickname", rset.getString("nickname"));
				  map.put("email", rset.getString("email"));
				  map.put("mobile", rset.getString("mobile"));
				  map.put("udate", rset.getString("udate"));
				  map.put("bip", rset.getString("bip"));
				  userList.add(map);
			  }
			  request.setAttribute("userList", userList);
			  // 3. 데이터를 담아 users.jsp로 이동
			  request.getRequestDispatcher("users.jsp").forward(request, response);
			  
	      } catch(Exception e) {  
	    	  e.printStackTrace(); 
	      } finally {
	    	  try { if(rset != null) rset.close(); } catch(Exception e) {}
	    	  try { if(pstmt != null) pstmt.close(); } catch(Exception e) {}
	    	  try { if(conn != null) conn.close(); } catch(Exception e) {}
	      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
