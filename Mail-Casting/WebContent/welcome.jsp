<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Mail Casting</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<script src="viewport.js"></script>
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/core.css" />
	</head>
	
	<body>
		<div id="wrapper">
					<div id="header">
						<h1 align="center">Welcome to Mail Casting</h1>	
					</div>
		</div>
		
		<div id="main">
			<div class="5grid">
				<div class="main-row">
					<div class="4u-first">
						<div id="msg">
							<p>Hello, <br> This is a prototype application for mail casting. <br> Let's try it....</p>
					</div>
					</div>
					<div class="4u">
						<div id = "wrapper">
						<h3 style="color:#007897;">Login Form</h3><br>
						 <form name=loginUser action=login method=post id="form">
								Email Address:<br> 
								<input type="text" name="email" size="30"><br>
								Password:<br>      
								<input type="password" name="password" size="30">
								<br><br>
								<input type=submit name=submit value="Sign in">
								&nbsp &nbsp &nbsp  &nbsp  
								<a href="register.jsp">Signup</a>
						</form>
					</div>
					</div>
					</div>
					
					<div class="4u">
					<div> 
					<br> <br> <br> <br> <br>
						<% if(request.getAttribute("Error")!=null){
								String Error=(String)request.getAttribute("Error");
								
								out.print("<font style='color:red'>"+ Error+"</font>");
							}
						%>
					</div>
					
				</div>
			</div>
		</div>
	<%@ include file="footer.jsp" %>
	</body>
</html>