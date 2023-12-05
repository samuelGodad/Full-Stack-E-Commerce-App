package com.sami.ecommerceapplication.servlet.pagedispatcher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/", "/login_page", "/order", "/cart"})
public class PageDispatcherServlets extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri =request.getServletPath();
		switch (uri) {
			case "/":
				showHomePage(request, response);
				break;
			case "/login_page":
				showLoginPage(request, response);
				break;
			case "/order":
				showOrderPage(request, response);
				break;
			case "/cart":
				showCartPage(request, response);
				break;
		}
	}
	protected  void showCartPage(HttpServletRequest request, HttpServletResponse response) {
		String cartPage = "/WEB-INF/jsp/cart.jsp";
		RequestDispatcher cartDispatcher = request.getRequestDispatcher(cartPage);
		try {
			cartDispatcher.forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	protected void showOrderPage(HttpServletRequest request, HttpServletResponse response) {
		String orderPage = "/WEB-INF/jsp/order.jsp";
		RequestDispatcher orderDispatcher = request.getRequestDispatcher(orderPage);
		try {
			orderDispatcher.forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void showHomePage(HttpServletRequest request, HttpServletResponse response) {
		String homePage = "/WEB-INF/jsp/index.jsp";
		RequestDispatcher homeDispatcher = request.getRequestDispatcher(homePage);
		try {
			homeDispatcher.forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	protected void showLoginPage(HttpServletRequest request, HttpServletResponse response) {
		String loginPage = "/WEB-INF/jsp/login.jsp";
		RequestDispatcher loginDispatcher = request.getRequestDispatcher(loginPage);
		try {
			loginDispatcher.forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
