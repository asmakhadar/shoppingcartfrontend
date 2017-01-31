<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
</head>

<style>
.w3-btn {width:100px;}
</style>


</head>
<body>
<jsp:include page="header.jsp" />
<style>
body {
    background-color:#ffcce6;
}
</style>
<h2>Register here</h2>
<form:form action="add_user" commandName="user" method="post">

<div class="w3-container">
<table  class="w3-centered">
<tr>
<td>Email ID:</td>
<td><form:input type="text" path="email_id" name="email_id"/></td>
</tr>

<tr>
<td>First name:</td>
<td><form:input type="text" path="first_name" name="first_name"/></td>
</tr>

<tr>
<td>Last name:</td>
<td><form:input type="text" path="last_name" name="last_name"/></td>
</tr>

<tr>
<td>Mobile number:</td>
<td><form:input type="text" path="mobile_number" name="mobile_number"/></td>
</tr>

<tr>
<td>Password:</td>
<td><form:input type="password" path="password" name="password"/></td>
</tr>
<tr>
<div class="w3-container">
  <td><button class="w3-btn w3-teal">Register</button></td>
  <td><button class="w3-btn w3-lime">Reset</button></td>
  </div>
  
</table>	
</div>

</form:form>

</body>
</html>