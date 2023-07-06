package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import java.util.ArrayList;

public class FetchProducts {
	
	public static ArrayList<ProductModal> getProductsList() {
        ArrayList<ProductModal> itemList = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33061/test","root","himesh");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from products");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(2));
				int id = resultSet.getInt(1);
				String productName = resultSet.getString(2);
				String functionality = resultSet.getString(3);
				String performance = resultSet.getString(4);
				String usability = resultSet.getString(5);
				String cost = resultSet.getString(6);
				String value = resultSet.getString(7);
				String environmentalImpact = resultSet.getString(8);


				ProductModal item = new ProductModal(id, productName, functionality, performance, usability, cost, value, environmentalImpact);
				itemList.add(item);
//				if(resultSet.getString(3).equalsIgnoreCase(request.getParameter("email"))) {
//					a = 1; // user found
//					if(resultSet.getString(4).equals(request.getParameter("pass"))){
//						response.sendRedirect("home.jsp");
//
//					} else {
//						System.out.println("Incorrect password");
//	                  
//					}
//				} 
			}

			statement.close();
	        connection.close();

		}catch (Exception e) {
	        e.printStackTrace();
	       
	    }
		return itemList;

	}
	
    
	 
}
