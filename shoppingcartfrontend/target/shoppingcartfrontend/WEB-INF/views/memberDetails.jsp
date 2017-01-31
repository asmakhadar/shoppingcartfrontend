<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page isELIgnored ="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<jsp:include page="header.jsp" />

<style>
form:form {
  text-align: center;
}
 </style>
  
</head>

<body>
<h2><center>REGISTER HERE</center></h2>

	<div class="container-fluid" align="center">
	
<div class="col-md-2"  align="left">
  <div class="row-fluid">
		<fieldset>
			
			<form:form modelAttribute="user">
				<br />
				<tr>
				<td><form:label path="first_name">First_Name:</form:label></td>
				<td><form:input path="first_name" /></td>
				</tr>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('first_name')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				<tr>
				<td><form:label path="last_name">Last_Name:</form:label></td>
				<td><form:input path="last_name" /></td>
				</tr>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('last_name')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:input type="password" path="password" /></td>

				</tr>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				<tr>
				<td><form:label path="email_id">Email_ID:</form:label></td>
				<td><form:input path="email_id" /></td>
				
				</tr>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('email_id')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				<tr>
				<td><form:label path="mobile_number">Mobile Number:</form:label></td>
				<td><form:input path="mobile_number" /></td>
				
				</tr>
				<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('mobile_number')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>

				<br />
					<input name="_eventId_submit" type="submit" class="btn btn-success" value="Submit" />
				<br />
			</form:form>
		</fieldset>
	</div>
	</div>
	</div>
	
	
</body>
</html>
