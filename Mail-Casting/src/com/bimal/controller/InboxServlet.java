package com.bimal.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimal.dbhelper.InBoxMsg;

/**
 * Servlet implementation class InboxServlet
 */
@WebServlet(description = "Controller for getting user inbox mail", urlPatterns = { "/inboxServlet" })
public class InboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InboxServlet() {
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
		HttpSession httpSession = request.getSession();
		String sender = (String) httpSession.getAttribute("username");
		
		InBoxMsg inboxMsg = new InBoxMsg();
		boolean status = false;
		try {
			status = inboxMsg.doReadInBoxMsg(sender);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (status == true) {
			String table = inboxMsg.getHTMLTable();
			
			request.setAttribute("table", table);
			
			RequestDispatcher dispatcher  = request.getRequestDispatcher("inbox.jsp");
			dispatcher.forward(request, response);	
		} else {
			String msg = "Empty InBox!";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("inbox.jsp");
			dispatcher.forward(request, response);
		}
	}

}
