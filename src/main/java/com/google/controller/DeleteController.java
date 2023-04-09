package com.google.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.dao.UserDao;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(req.getParameter("id"));
		new UserDao().DeleteUser(id);
		
		resp.sendRedirect("ListUserController");
//		super.doGet(req, resp);
	}
	
}
