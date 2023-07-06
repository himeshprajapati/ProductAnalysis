package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/addProduct")
public class AddProductsCon extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String functionality = request.getParameter("functionality");
        String performance = request.getParameter("performance");
        String usability = request.getParameter("usability");
        String cost = request.getParameter("cost");
        String value = request.getParameter("value");
        String environmentalImpact = request.getParameter("environmentalImpact");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33061/test", "root", "himesh");
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO products (productName, functionality, performance, usability, cost, value, environmentalImpact) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            pstmt.setString(1, productName);
            pstmt.setString(2, functionality);
            pstmt.setString(3, performance);
            pstmt.setString(4, usability);
            pstmt.setString(5, cost);
            pstmt.setString(6, value);
            pstmt.setString(7, environmentalImpact);
            
            pstmt.executeUpdate();
            
            pstmt.close();
            con.close();

            String message = "Product added successfully!";
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("alert('" + message + "');");
            out.println("window.location.href='home.jsp';"); // Redirect to the product form page
            out.println("</script>");
        } catch (Exception e) {
            // Display error message in a pop-up dialog
            String errorMessage = "Error: " + e.getMessage();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("alert('" + errorMessage + "');");
            out.println("window.location.href='AddProducts.jsp';"); // Redirect to the product form page
            out.println("</script>");
        }
    }
}
