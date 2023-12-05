package com.sami.ecommerceapplication.dao;
import com.sami.ecommerceapplication.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
	private  Connection connection;
	private  String query;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	public OrderDao(Connection connection) {
		this.connection = connection;
	}
	public boolean insertOrder(Order ordermodel){
		boolean result = false;
		try {
			query = "insert into orders (product_id,total_amount,order_date,user_id) values (?,?,?,?)";
			preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, ordermodel.getId());
			preparedStatement.setInt(2, ordermodel.getQuantity());
			preparedStatement.setTimestamp(3, ordermodel.getDate());
			preparedStatement.setInt(4, ordermodel.getUser_id());
			preparedStatement.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}


