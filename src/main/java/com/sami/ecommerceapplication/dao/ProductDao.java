package com.sami.ecommerceapplication.dao;

import com.sami.ecommerceapplication.model.Cart;
import com.sami.ecommerceapplication.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ProductDao {
	private final Connection connection;
	private String query;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	public ProductDao(Connection connection) {
		this.connection = connection;
	}
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			query = "select * from products";
			preparedStatement = this.connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product row;
				row = new Product();
				row.setId(resultSet.getInt("product_id"));
				row.setName(resultSet.getString("product_name"));
				row.setCategory(resultSet.getString("category"));
				row.setPrice(resultSet.getInt("price"));
				row.setImage(resultSet.getString("image"));
				products.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Cart> getAllCartProducts(ArrayList<Cart> cartList) {
		List<Cart> cartProducts = new ArrayList<Cart>();
		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select * from products where product_id =?";
					preparedStatement = this.connection.prepareStatement(query);
					preparedStatement.setInt(1, item.getId()); // Set the parameter value
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						Cart row = new Cart();
						row.setId(resultSet.getInt("product_id"));
						row.setName(resultSet.getString("product_name"));
						row.setPrice(resultSet.getInt("price") * item.getQuantity());
						row.setQuantity(item.getQuantity());
						row.setCategory(resultSet.getString("category"));
						row.setImage(resultSet.getString("image"));
						cartProducts.add(row);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartProducts;
	}
	public double totalCartPrice(ArrayList<Cart> cartList) {
		double total = 0;

		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select * from products where product_id =?";
					preparedStatement = this.connection.prepareStatement(query);
					preparedStatement.setInt(1, item.getId()); // Set the parameter value
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						total += resultSet.getDouble("price") * item.getQuantity();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
}
