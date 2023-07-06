<%@ page import="java.sql.*" %>

<%
    String productName = request.getParameter("productName");
    String functionality = request.getParameter("functionality");
    String performance = request.getParameter("performance");
    String usability = request.getParameter("usability");
    String cost = request.getParameter("cost");
    String value = request.getParameter("value");
    String environmentalImpact = request.getParameter("environmentalImpact");

    // Insert the data into the database
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33061/test", "root", "himesh");
        Statement stmt = con.createStatement();
        String query = "INSERT INTO products (productName, functionality, performance, usability, cost, value, environmentalImpact) VALUES ('"
                + productName + "', '" + functionality + "', '" + performance + "', '" + usability + "', '" + cost + "', '" + value + "', '" + environmentalImpact + "')";
        stmt.executeUpdate(query);
        stmt.close();
        con.close();
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
