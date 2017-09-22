package com.bimal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimal.dbhelper.RegisterUser;
import com.bimal.model.UserModel;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "Controller for registering user", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//get data
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String contact = request.getParameter("mname");
		String country = request.getParameter("country");
		
		//set up usermodel
		UserModel userModel = new UserModel();
		userModel.setEmail(email);
		userModel.setPassword(password);
		userModel.setName(name);
		userModel.setGender(gender);
		userModel.setContact(contact);
		userModel.setCountry(country);
		
		RegisterUser register = new RegisterUser();
		try {
			int status = register.registerUser(userModel);
			if (status==1) {
				String registerMsg= "You are Successfully registered";
				request.setAttribute("registerMsg",registerMsg);
				RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
				rd.include(request, response);
			} else {
				String Errormsg="Sorry,Registration failed. please try again";
				request.setAttribute("registererror",Errormsg);
				RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

}
