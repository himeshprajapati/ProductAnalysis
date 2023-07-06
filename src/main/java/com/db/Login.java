package com.db;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class Login
 */

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33061/test","root","himesh");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from users");
			
			int a = 0;
			while (resultSet.next()) {
				System.out.println(resultSet.getString(3) +":"+request.getParameter("email"));
				System.out.println(resultSet.getString(4) + ":" + request.getParameter("pass"));
				
				if(resultSet.getString(3).equalsIgnoreCase(request.getParameter("email"))) {
					a = 1; // user found
					if(resultSet.getString(4).equals(request.getParameter("pass"))){
						response.sendRedirect("home.jsp");

					} else {
						System.out.println("Incorrect password");
	                    request.setAttribute("errorMessage", "Invalid user or password");

					      RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				          dispatcher.forward(request, response);
					}
				} 
			}
			
			if(a==0) {
				System.out.println("Incorrect password");
                request.setAttribute("errorMessage", "No user found");

			      RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		          dispatcher.forward(request, response);
			}
			
			statement.close();
	        connection.close();
		} catch (Exception e) {
	            e.printStackTrace();
	        }
		    
		}	
		}
