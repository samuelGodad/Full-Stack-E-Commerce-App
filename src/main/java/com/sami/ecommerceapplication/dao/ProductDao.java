package com.sami.ecommerceapplication.dao;

import com.sami.ecommerceapplication.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private Connection connection;
	private String query;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public ProductDao(Connection connection) {
		this.connection = connection;


	}
	public List<Product> getAllProducts(){
		List<Product> products =new ArrayList<Product>();
		try {
			query ="select * from products";
			preparedStatement= this.connection.prepareStatement(query);
			resultSet =preparedStatement.executeQuery();

			while (resultSet.next()){
				Product row;
				row = new Product();
				row.setId(resultSet.getInt("product_id"));
				row.setName(resultSet.getString("product_name"));
				row.setCategory(resultSet.getString("category"));
				row.setPrice(resultSet.getString("price"));
				row.setImage(resultSet.getString("image"));
				products.add(row);

			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return  products;
	}

}