package com.bimal.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bimal.dbhelper.SaveMsg;
import com.bimal.model.InboxModel;

/**
 * Servlet implementation class ComposeServlet
 */
@WebServlet(description = "Controller for composing mail", urlPatterns = { "/composeServlet" })
public class ComposeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComposeServlet() {
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
		String toEmail = request.getParameter("reciever_id");
		String msg = request.getParameter("message");
		
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("username");
		String password = (String) httpSession.getAttribute("password");
			
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(props, 
			    new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication(
			                username, password );// Specify the Username and the PassWord
			        }
			});

		try {

			Message message = new MimeMessage(session);
		 	message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toEmail));
			message.setSubject("Testing Subject");
			message.setText(msg);

			Transport.send(message);

			System.out.println("Mail Sent");
			
			
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 Date date = new Date();
			 String dat = dateFormat.format(date);
			 System.out.println(dat);
			
			InboxModel inboxModel = new InboxModel();
			inboxModel.setDate(dat);
			inboxModel.setSender(username);
			inboxModel.setReceiver(toEmail);
			inboxModel.setMessage(msg);
			
			SaveMsg saveMsg =  new SaveMsg();
			int status = saveMsg.saveMsg(inboxModel);
			
			if (status == 1) {
				String successMsg = "Message sent successfully.";
				request.setAttribute("Success", successMsg);
				RequestDispatcher rd = request.getRequestDispatcher("compose.jsp");
				rd.include(request, response);
			} else {
				System.out.println("no");
			}
		

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} 
	}

}
