<%@page import="DTO.Task"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" href="home.css">
</head> 
<body>
<% user u=(user)request.getSession().getAttribute("user");
   String image= new String(Base64.getEncoder().encode(u.getImage()));
%>
<div id="main">
<div id="main_left">
<img src="data:image/jpeg;base64,<%= image %>" height="200px" width="200px">
</div>
<div id="main_right">
<h1>welcome <%= u.getUsername() %></h1>
<h3>email : <%= u.getUseremail() %></h3>

<a href="task.jsp">add task</a>
</div>
</div>
<div id="mainbody">
<% List<Task> tasks=(List)request.getAttribute("tasks");
if(!tasks.isEmpty()){%>
<h1>Task</h1>
<table id="table">
<thead>
<tr>
<th>Id</th>
<th>Title</th>
<th>Description</th>
<th>Priority</th>
<th>Due Date</th>
<th>Status</th>
<th>Edit</th>
<th>Delete Task</th>
</tr>
</thead>
<tbody>
<% for(Task task:tasks){ %>
<tr>
<td><%= task.getTaskid() %></td>
<td><%= task.getTasktitle() %></td>
<td><%= task.getTaskdescription() %></td>
<td><%= task.getTaskpriority() %></td>
<td><%= task.getTaskduedate() %></td>
<td><%= task.isTaskstatus() %></td>
<td><a href="edittask?taskid=<%=task.getTaskid() %>" >Edit</a>
<td><a href="delete?taskid=<%= task.getTaskid() %>" >Delete</a>
</tr>
<% } %>
</tbody>
</table>
<% }
else{%>
<h1>there is no task yet!</h1>
<%} %>
<br><br>
 <a href="logout">logout</a>
</div>
</body>
</html>
