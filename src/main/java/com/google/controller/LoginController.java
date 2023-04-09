package com.google.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailname = req.getParameter("emailname");
		String password = req.getParameter("password");
		
//		System.out.println("\nFrom login !!");
		System.out.println("Email: " + emailname);
		System.out.println("Password: " + password);
		
		System.out.println();
		
//		UserBean ubean = new UserBean();
//		ubean.setEmail(emailname);
//		ubean.setPassword(password);
//		
//		UserDao udao = new UserDao();
//		udao.authenticate(emailname, password);
//		UserBean ubean1 = udao.authenticate(ubean);
		
		UserBean user = new UserDao().authenticate(emailname, password);
//		RequestDispatcher rd = null; ------> this will also work, for that we have to wright rd = req.GRD(path);   -->  rd.forword(req,resp);
		if(user==null)
		{
//			resp.sendError("error", "Plea");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("user", user);
			req.getRequestDispatcher("List.jsp").forward(req, resp);			
		}
//		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer ID = Integer.valueOf(req.getParameter("id"));
		
		UserBean ubean = new UserDao().getUserById(ID);
		RequestDispatcher rd = null;
		if(ubean==null)
		{
			rd = req.getRequestDispatcher("ListAllUsers.jsp");
		}
		else
		{
			req.setAttribute("user", ubean);
			rd = req.getRequestDispatcher("List.jsp");
		}
		rd.forward(req, resp);
//		super.doGet(req, resp);
	}

}
