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

@WebServlet("/SearchUserController")
public class SearchUserController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String) req.getParameter("name");
		ArrayList<UserBean> users = new UserDao().SearchUser(name);
		
		req.setAttribute("users", users);
		req.getRequestDispatcher("ListAllUsers.jsp").forward(req, resp);
//		super.doPost(req, resp);
	}

}
