package com.sami.ecommerceapplication.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {
private  static Connection connection= null;
public static Connection getConnection(){
	if (connection==null){

		try {
			Class.forName("org.postgresql.Driver");
			try {
				connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce cart","postgres","20082011ec!");
				System.out.println("connected successfully");


			} catch (SQLException e) {
				System.out.println("you cannot connect");
				throw new RuntimeException(e);

			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	return  connection;
	}
}

