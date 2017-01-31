<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
<style>
 th{
    
    background-color: #ffcce6;
}

</style>
</head>
<jsp:include page="header.jsp" />

<body>
<h2><center>CONFIRM DETAILS</center></h2>
		<br>
		<br>
		<div class="container-fluid">
	
<div class="col-md-2">
  <div class="row-fluid">
		<fieldset>
		
			
			<sf:form modelAttribute="user">
				<sf:label path="first_name">First_name :</sf:label>    ${user.first_name}
					<br />
				<br />
				<sf:label path="last_name"> Last_name:</sf:label> ${user.last_name}
					<br />
				<br />
				<sf:label path="password">Password :</sf:label> ${user.password}
				<br>
					<br>
                <sf:label path="email_id">Email_id:</sf:label> ${user.email_id}
					<br />
				<br />
				<sf:label path="mobile_number">Mobile_number:</sf:label> ${user.mobile_number}
					<br />
				<br />
			
				<input name="_eventId_edit" type="submit"  class="btn btn-primary" value="Edit" />
				<input name="_eventId_submit" type="submit" class="btn btn-success" value="Confirm Details" />
				<br />
			</sf:form>
		</fieldset>
	</div>
	</div>
	</div>
</body>
</html>

