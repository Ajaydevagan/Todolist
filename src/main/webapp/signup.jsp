<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="signup.css">
</head>
<body>
<div>
<form action="saveuser" method="post" enctype="multipart/form-data">
<lable for="id">Id :</lable>
<input type="text" name="userid" id="id"><br><br>
<lable for="name">Name :</lable>
<input type="text" name="username" id="name"><br><br>
<lable for="email">Email :</lable>
<input type="email" name="useremail" id="email"><br><br>
<lable for="contact">Contact :</lable>
<input type="text" name="usercontact" id="email"><br><br>
<lable for="password">Password :</lable>
<input type="email" name="userpassword" id="password"><br><br>
<lable for="image">Contact :</lable>
<input type="file" name="userimage" id="image"><br><br>
<input id="submit" type="submit">
</form>
</div>
</body>
</html>