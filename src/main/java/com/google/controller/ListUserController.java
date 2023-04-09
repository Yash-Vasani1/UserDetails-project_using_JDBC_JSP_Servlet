package com.google.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<UserBean> users = new UserDao().getAllUsers();
//		System.out.println(users);
		
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("ListAllUsers.jsp").forward(req, resp);
		
	
//		super.doGet(req, resp);
	}

}
