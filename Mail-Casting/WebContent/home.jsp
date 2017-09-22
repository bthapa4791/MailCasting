<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
	<jsp:include page="header.jsp"></jsp:include>
	<script src="script.js"></script>
	<link rel="stylesheet" href="css/core.css"/>
</head>
	<body>
			<div class="5grid">
			<div class="main-row">
			<div class="4u-first">
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
				<div class = "4u">
					<marquee direction="up">
						<font style="color: navy;">
						<h4><br><br>Perform any sorts of activities<br>
							related to mailing. For Example,<br>
							Compose Email, Check Inbox, Delete<br>
							your sent emails. Please Contact us<br>
							if you have any issue by clicking Contact<br>
							tab.<br>
						</h4>
						</font>
					</marquee></li>
				</div>
			</div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>