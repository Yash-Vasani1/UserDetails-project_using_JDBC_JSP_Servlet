package com.google.controller;

import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

@WebServlet("/EditUserController")
public class EditUserController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(req.getParameter("id"));
		
//		String name = req.getParameter("name");
//		String email = req.getParameter("email");
//		String password = req.getParameter("password");
		
		UserBean ubean = new UserDao().getUserById(id);
//		 new UserBean();
//		ubean.setName(name);
//		ubean.setEmail(email);
//		ubean.setPassword(password);
		
		req.setAttribute("user", ubean);
		req.getRequestDispatcher("EditUser.jsp").forward(req, resp);
		
//		new UserDao().EditUser(ubean);
		
		
		
//		resp.sendRedirect("ListUserController");
//		super.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserBean ubean = new UserBean();
		ubean.setId(id);
		ubean.setName(name);
		ubean.setEmail(email);
		ubean.setPassword(password);
		
		new UserDao().EditUser(ubean);
		
		resp.sendRedirect("ListUserController");
//		super.doPost(req, resp);
	}
}
