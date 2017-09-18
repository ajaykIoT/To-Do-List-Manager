<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task Manager</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Task Manager</h1>
	        <h3><a href="newTask">New Task</a></h3>
	        <table border="1">
	            <th>No</th>
	            <th>Description</th>
	        	<th>Status</th>
	        	<th>Date</th>
	        	<th>Action</th>
	        	
				<c:forEach var="task" items="${listTasks}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${task.taskDescription}</td>
					<td>${task.taskStatus}</td>
					<td>${task.taskDate}</td>
					<td>
					    <a href="editTask?id=${task.taskIndex}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteTask?id=${task.taskIndex}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>