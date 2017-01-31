<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - HomeGardens</title>
</head>
<body>


	<form  action="<c:url value='j_spring_security_check'/>"  method="POST" role="form">
	<table cellpadding="5px;">
		<tr >
			<td>E Mail</td>
			<td><input type="text" name="username" placeholder="Enter mail id"></td>
		</tr>	
	
		<tr >
			<td>Password</td>
			<td><input type="password" name="password" placeholder="Password"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
${Validate}
</body>
</html>