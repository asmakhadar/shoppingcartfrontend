<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>

<jsp:include page="header.jsp" />

</style>
</head>
<body>
    <ul class="nav navbar-nav">
      <li><a href="onLoad"><span class="glyphicon glyphicon-home"></span></a></li>
      <li><a href="aboutus">About Us</a></li>
      <li><a href="contact">Contact Us</a></li>
     </ul>
      <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="loginUser"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>

<h1>Welcome<div class="container">
<div class="col-md-4">
   To Sign Up Page</h1>

<form:form action="user/register" method="post" commandName="user">
	<table>
		<tr>
		<td><form:label path="first_name"><spring:message text="FIRST_NAME"/></form:label></td>
		<td><form:input type="text" path="first_name" pattern=".{4,10}" required="true" title="please enter 4 to 10 characters"/></td>
		</tr>
		
		<tr>
		<td><form:label path="last_name"><spring:message text="LAST_NAME"/></form:label></td>
		<td><form:input type="text" path="last_name"  required="true" title="name should not be empty"/></td>
		</tr>
		
			
		<tr>
		<td><form:label path="password"><spring:message text="PASSWORD"/></form:label></td>
		<td><form:input type="password" path="password"  required="true" pattern=".{4,10}"  title="please enter 4 to 10 characters"/></td>
		</tr>
		
		<tr>
		<td><form:label path="email_id"><spring:message text="EMAIL_ID"/></form:label></td>
		<td><form:input type="text" path="email_id"/></td>
		</tr>
		
		<tr>
		<td><form:label path="mobile_no"><spring:message text="MOBILE_NUMBER"/></form:label></td>
		<td><form:input type="text" path="mobile_no"   /></td>
		</tr>
		
		<td><input type="submit" value="<spring:message text="SIGNUP"/>"/></td>
		<td><input type="reset"	value="<spring:message text="RESET"/>"/></td>			
		
		
		
	</table>
</form:form>
</div>
</body>
</html>