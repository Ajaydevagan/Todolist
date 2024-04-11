<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<div id="div">
		<form action="loginuser" method="post">
			<label for="email">Email :</label> <input type="email"
				name="loginemail" id="email"> <br> <br> <label
				for="password">Password :</label> <input type="text"
				name="loginpassword" id="password"> <br> <br> <input
				type="submit">
			<%
			if (request != null) {
				String msg1 = (String) request.getAttribute("message");
				if (msg1 != null) {
			%>
			<span id="span"><br>
			<br> <%=msg1%></span>
			<%
			}
			}
			%>
		</form>
	</div>
</body>
</html>