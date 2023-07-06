package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PrintWriter out = resp.getWriter();
        String productId = req.getParameter("prodId");
    	System.out.println(productId);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:33061/test", "root", "himesh");

                pstmt = con.prepareStatement("Delete FROM products WHERE id = ?");
                pstmt.setInt(1, Integer.parseInt(productId));
                pstmt.executeUpdate();

                RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
                rd.forward(req, resp);
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            // Close JDBC resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                out.println("<p>Error closing JDBC resources: " + e.getMessage() + "</p>");
            }
        }
	}
}

