package mainApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet{
	
	private static final long serialVersionUID = 1 ;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws IOException   {
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		try {
			Connection connection= DbConnection.createConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from user where username = ?");
	        stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
	        if(rs.next()) {
	        	response.sendRedirect("loginsuccess.jsp");
	        }
	        else
	        	response.sendRedirect("loginunsuccess.jsp");
		}catch(SQLException se) {
			 se.printStackTrace();
		 }
		
				
	}
	

}
