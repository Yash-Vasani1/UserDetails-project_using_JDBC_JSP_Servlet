package com.google.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
//import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet{
	public void init() {
		System.out.println("RegistrationController::init()");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			System.out.println(name);
			System.out.println(email);
			System.out.println(password);
			
			// validation part
			boolean isError = false;
			StringBuffer error = new StringBuffer("");
			UserBean ubean = new UserBean();
			
			// name validation
			if(name=="" || name.trim().length()==0)
			{
				isError = true;
				request.setAttribute("nameerror", "Please Enter Name !!");
			}else if(name.trim().length()<2)
			{
				isError = true;
				request.setAttribute("nameerror", "Please enter atleaset 2 characters in name !!");
				ubean.setName(name);
				
			}else
			{
				String alpha = "[a-zA-Z]+"; // minimum 1 char max n
				if(name.matches(alpha) == false)
				{
					isError = true;
					request.setAttribute("nameerror", "Please enter valid name !! ");
					ubean.setName(name);
				}else
				{
					ubean.setName(name);
				}
			}
			
			//email validation
			if(email=="" || email.trim().length()==0)
			{
				isError = true;
				request.setAttribute("emailerror", "Please  Enter EmailId !!");
//				ubean.setEmail(email);
			}
			else if(email.trim().length()<11)
			{
				isError = true;
				request.setAttribute("emailerror", "Please Enter atleast 11 characters in email!!");
				ubean.setEmail(email);
			}
			else
			{
				String alpha = "[a-zA-Z]+[0-9]+@[g][m][a][i][l][.][c][o][m]";
				if(email.matches(alpha)==false)
				{
					isError = true;
					request.setAttribute("emailerror", "Please Enter Valid EmailId !!");
					ubean.setEmail(email);
				}else
				{
					ubean.setEmail(email);
				}
			}
			
			//password validation
			if(password=="" || password.trim().length()==0)
			{
				isError = true;
				request.setAttribute("passworderror", "Please Enter Password !!");
			}else if(password.trim().length()<8)
			{
				isError = true;
				request.setAttribute("passworderror", "Please enter atleast 8 chatacters !!");
			}else
			{
				String alpha = "[A-Z][a-z0-9]+";
				if(password.matches(alpha))
				{
					isError = true;
					request.setAttribute("passworderror", "Please Enterr Valid Password !!");
				}
				else
				{
					ubean.setPassword(password);
				}
			}
			
			request.setAttribute("user", ubean);
			
//1			RequestDispatcher rd1 = null;
			
			if(isError)
			{
				System.out.println("Error occurs !!");
//				System.out.println(isError);
//	2			rd1 = req.getRequestDispatcher("Registration.jsp");
//				request.setAttribute("xyz", "xyz");
				request.getRequestDispatcher("Registration.jsp").forward(request, response);				
			}
			else
			{
//				System.out.println("Error occurs234567 !!");
				UserDao udao = new UserDao();
				udao.addUser(ubean);
				request.getRequestDispatcher("Login.jsp").forward(request, response);

//3				rd1 = req.getRequestDispatcher("Login.jsp");
			}
//			ubean.setName(name);
//			ubean.setEmail(email);
//			ubean.setPassword(password);
			
//	4		rd1.forward(req, resp);
			
			
			
			
//		super.doPost(req, resp);
	}

}
