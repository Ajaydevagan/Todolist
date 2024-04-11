<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="task.css">
</head>
<body>
<div>
<form action="task" method="post">
<lable for="task-id">task id: </lable>
<input type="text" name="taskid" id="task-id" required>
<br><br>
<lable for="task-title">task title: </lable>
<input type="text" name="tasktitle" id="task-title" required>
<br><br>
<lable for="task-discription">task Discription: </lable>
<input type="text" name="taskdiscription" id="task-discription" required>
<br><br>
<lable for="task-priority">task Priority: </lable>
<input type="radio" name="taskpriority" value="low" requried>low
<input type="radio" name="taskpriority" value="medium" >medium
<input type="radio" name="taskpriority" value="high" >high
<br><br>
<lable for="task-duedate">task due date:</lable>
<input type="date" name="taskduedate" id="task-duedate" required>
<br><br>
<input type="submit">
</form>
</div>
</body>
</html>