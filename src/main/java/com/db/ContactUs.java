package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Contact")
public class ContactUs extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Obtain the form data from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        
        // JDBC variables
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // Register the JDBC driver (if needed)
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:33061/test","root","himesh");
            
            // Create the SQL statement
            String sql = "INSERT INTO ContactMessages (name, email, message) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, message);
            
            // Execute the statement
            int rowsAffected = stmt.executeUpdate();
            
            // Display success message
            PrintWriter out = response.getWriter();
            out.println("<html><head><script>");
            out.println("window.onload = function() {");
            out.println("alert('Message stored successfully!');");
            out.println("location.href = 'home.jsp';"); // Replace with your contact page URL
            out.println("}");
            out.println("</script></head><body></body></html>");
        } catch (ClassNotFoundException | SQLException ex) {
            // Handle any errors
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Error storing message</h2>");
            out.println("<p>" + ex.getMessage() + "</p>");
            out.println("</body></html>");
        } finally {
            // Close the resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                // Log the exception or handle it as needed
            }
        }
    }
}
