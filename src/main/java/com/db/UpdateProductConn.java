package com.db;

import java.io.*;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateProduct")
public class UpdateProductConn extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int id = 0;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PrintWriter out = resp.getWriter();
        String productId = req.getParameter("prodId");
    	System.out.println(productId);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:33061/test", "root", "himesh");

            if (productId != null) {
                pstmt = con.prepareStatement("SELECT * FROM products WHERE id = ?");
                pstmt.setInt(1, Integer.parseInt(productId));
                rs = pstmt.executeQuery();

                if (rs.next()) {
                	//store table details
                    String productName = rs.getString("productName");
                    String functionality = rs.getString("functionality");
                    String performance = rs.getString("performance");
                    String usability = rs.getString("usability");
                    String cost = rs.getString("cost");
                    String value = rs.getString("value");
                    String environmentalImpact = rs.getString("environmentalImpact");

                    // Set the request attributes
                    req.setAttribute("id", productId);
                    req.setAttribute("productName", productName);
                    req.setAttribute("functionality", functionality);
                    req.setAttribute("performance", performance);
                    req.setAttribute("usability", usability);
                    req.setAttribute("cost", cost);
                    req.setAttribute("value", value);
                    req.setAttribute("environmentalImpact", environmentalImpact);

                    // Forward the request to the JSP for rendering
                    RequestDispatcher rd = req.getRequestDispatcher("UpdateDetails.jsp");
                    rd.forward(req, resp);
                } else {
                    // No data found for the provided ID
                    out.println("<p>No data found for the provided ID.</p>");
                }
            } else {
                // No ID provided
                out.println("<p>No ID provided.</p>");
            }
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
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:33061/test", "root", "himesh");
            String productId = request.getParameter("prodId");
            String productName = request.getParameter("productName");
            String functionality = request.getParameter("functionality");
            String performance = request.getParameter("performance");
            String usability = request.getParameter("usability");
            String cost = request.getParameter("cost");
            String value = request.getParameter("value");
            String environmentalImpact = request.getParameter("environmentalImpact");
            
            System.out.println(productId +":"+ productName +":"+ functionality);
            pstmt = con.prepareStatement("Update products SET productName = ?, functionality=?, performance=?, usability=?, cost=?, value=?, environmentalImpact=? WHERE id = ?");
                
                pstmt.setString(1, productName);
                pstmt.setString(2, functionality);
                pstmt.setString(3, performance);
                pstmt.setString(4, usability);
                pstmt.setString(5, cost);
                pstmt.setString(6, value);
                pstmt.setString(7, environmentalImpact);
                
                pstmt.setInt(8, Integer.parseInt(productId));
                pstmt.executeUpdate();
                
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);

                
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

