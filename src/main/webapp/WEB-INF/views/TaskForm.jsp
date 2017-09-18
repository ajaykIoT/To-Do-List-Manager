<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Task</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Task</h1>
		<form:form action="saveTask" method="post" modelAttribute="task">
		<table>
			<form:form/>
			<tr>
				<td>Description:</td>
				<td><form:input path="taskDescription" /></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><form:input path="taskStatus" /></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><form:input path="taskDate" /></td>
			</tr>
			
			<tr>
				<td><form:input type="hidden" path="taskIndex" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>