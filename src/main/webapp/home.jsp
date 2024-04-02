<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Controller.loginuser" %>
    <%@ page import="DTO.user" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% user u=(user)request.getSession().getAttribute("user");
   String image= new String(Base64.getEncoder().encode(u.getImage()));
%>

<h1>welcome <%= u.getUsername() %></h1>
<h3>email : <%= u.getUseremail() %></h3>
<img src="data:image/jpeg;base64,<%= image %>">
<img>
</body>
</html>