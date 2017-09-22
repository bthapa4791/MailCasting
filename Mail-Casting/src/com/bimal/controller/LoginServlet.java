package com.bimal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimal.dbhelper.LoginUser;
import com.bimal.model.UserModel;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Controller for login user", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//get data
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// set up login object
		UserModel userModel = new UserModel();
		userModel.setEmail(email);
		userModel.setPassword(password);
		
		// set up an LoginQuery Object
		LoginUser lq = new LoginUser();
		
		boolean status = lq.checkLogin(userModel);
		
		// use the status
		if (status == true) {
			HttpSession session=request.getSession();
			session.setAttribute("username",email);
			session.setAttribute("password", password);
			String url = "home.jsp";	
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			String Error = "Please check your Email and Password";
			request.setAttribute("Error", Error);
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.include(request, response);
		}
	}

}
