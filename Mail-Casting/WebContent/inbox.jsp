<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
    	String table = (String)request.getAttribute("table");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InBox</title>
<jsp:include page="header.jsp"></jsp:include>
<script src="script.js"></script>
<link rel="stylesheet" href="css/core.css"/>
</head>
<body>
	
	<div class="5grid">
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
	
			<div class="3u">
				<h4>InBox Messages</h4> <br> 
			
				<% if(table != null){
					out.println(table);
				}
				%>
				<% if(request.getAttribute("msg")!=null){
					out.println("\n");
					out.println("\n");
					out.println("\n");
					out.println("\n");
					
					String msg = (String)request.getAttribute("msg");
					
					out.print("<font style='color:red'>"+ msg +"</font>");
				} 
				%>
			</div>		
		</div>
	<%-- <jsp:include page="footer.jsp"></jsp:include> --%>	
</body>
</html>