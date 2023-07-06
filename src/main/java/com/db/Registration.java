package com.db;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     String fullname = request.getParameter("fullname");
		 String email = request.getParameter("email");
	     String password = request.getParameter("pass");
	     String cpassword = request.getParameter("cpass");

	     System.out.println(fullname +":"+email +":"+password +":"+cpassword);
	     
	     try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33061/test","root","himesh");
			
			PreparedStatement st = connection
	                .prepareStatement("insert into users(fullname, email, password) values(?, ?, ?)");

	         // For the first parameter,
	         // get the data using request object
	         // sets the data to st pointer
	         // Same for second parameter
	         st.setString(1, fullname);
	         st.setString(2, email);
	         st.setString(3, password);

	         // Execute the insert command using executeUpdate()
	         // to make changes in database
	         st.executeUpdate();

	         // Close all the connections
	         st.close();
	         connection.close();
	         // Get a writer pointer 
	            // to display the successful result
	            PrintWriter out = response.getWriter();
	           
	            request.setAttribute("Success", "Registration successful");

			      RequestDispatcher dispatcher = request.getRequestDispatcher("/signup.jsp");
		          dispatcher.forward(request, response);	            

	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
}
