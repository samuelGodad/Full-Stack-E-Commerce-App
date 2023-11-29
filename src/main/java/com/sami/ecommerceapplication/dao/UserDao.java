package com.sami.ecommerceapplication.dao;

import com.sami.ecommerceapplication.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	private final Connection connection;
	private  String query;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

	public User userLogin(String email, String password) {
		User user = null;
		try {
			query = "select * from users where email=? and password=?";
			preparedStatement=this.connection.prepareStatement(query);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				user =new User();
				user.setId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("username"));
				user.setEmail(resultSet.getString("email"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return user;

	}
}
