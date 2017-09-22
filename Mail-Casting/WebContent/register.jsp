<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Registration</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
			<script src="viewport.js"></script>
			<link rel="stylesheet" href="css/style.css"/>
			<link rel="stylesheet" href="css/core.css"/>
	</head>
	<body>
		<div id="wrapper">
					<div id="header">
						<h1 align="center">Welcome to Mail Casting</h1>	
					</div>
		</div>
		
			<div class="5grid">
				<div class="main-row">
					<div class="4u-first">
						<div id="msg">
							<p> Welcome to the mail casting system.<br> This system helps you to send 
							   email <br> your intended person after registering.<br> You can send email.<br>
							   All your sent email will be saved in database <br> and you can delete 
							   them according to your<br> convenience.</p>
						</div>
					</div>
					<div class="4u">
						<div id = "wrapper">
						<h3 style="color:#007897;">Registration Form</h3><br>
						<div>
							<% 
								if(request.getAttribute("registererror")!=null){
								String msg=(String)request.getAttribute("registererror");
								out.print("<font style='color:red'>"+msg);
								out.print("</font><br/>");
								}
							%>
						 <form name=registerUser action=register method=post id="form">
						 <table style="table-layout: fixed;">
						<tr><td>EmailId:</td><td> <input type="text" name="email"/><br/><br/></td></tr>
						<tr><td>Password: </td><td><input type="password" name="password"/><br/><br/></td></tr>
						<tr><td>Name: </td><td><input type="text" name="name"/><br/><br/></td></tr>
						<tr><td>Gender:</td><td>
						Male<input type="radio" name="gender" value="male">Female<input type="radio" name="gender" value="female"/><br/><br/></td></tr>
						<tr><td>Contact Number:</td><td> <input type="text" name="mname"/><br/><br/></td></tr>
						<tr><td>Country: </td><td><input type="text" name="country"/><br/><br/></td></tr>
						<tr><td></td><td><input type="submit" value="Submit"/></td></tr>
						</table>
						 </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<%@ include file="footer.jsp" %>	
	</body>
</html>