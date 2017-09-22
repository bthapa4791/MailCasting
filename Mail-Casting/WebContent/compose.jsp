<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compose Mail</title>
	<jsp:include page="header.jsp"></jsp:include>
	<script src="script.js"></script>
	<link rel="stylesheet" href="css/core.css"/>
</head>
<body>
		<div class="5grid">
		<div class="main-row">
		<div class="3u-first">
			<div id="nav">
				<nav>
				 	<a href="home.jsp">Homepage</a><br><br>
					<a href="compose.jsp">Compose Mail</a><br><br>
					<a href=inboxServlet>Inbox</a><br><br>
					<a href="logout">Logout</a><br><br>
					<a href="contact.jsp">Contact Us</a><br><br>
				</nav>
			</div>
		</div>
		</div>
		
			<div class="3u">
				<h4>Compose Message</h4> 
				<form action=composeServlet method=post >
					<table>
					 	<tr><td>To: <input type="text" name="reciever_id" size="30"/><br></td></tr>
					 	<tr><td>Message:<br></td></tr>
					 	<tr><td><textarea rows="10" cols="50" name="message"></textarea><br><br></td></tr>
					 	<tr><td><input type="submit" value="Send"/></td></tr>
			 		</table>
			 	</form>
			</div>
			
			<div class="4u">
					<div> 
					<br> <br> <br> <br> <br>
						<% if(request.getAttribute("Success")!=null){
								String successMsg = (String)request.getAttribute("Success");
								
								out.print("<font style='color:red'>"+ successMsg +"</font>");
							}
						%>
					</div>
					
				</div>
					
		</div>
	<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>