<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
 <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

<title>Insert title here</title>
 <jsp:include page="header.jsp" />
 
  <style>
 body
 {
  background-color:#ffcce6;
  }
 </style>
</head>
<style>
th{
    color:white;
    background-color:black;
    
}

table, th, td {
    border: 1px solid black;
    align:center;
}

h2{
color:black;
font-family: "Times New Roman", Times, serif;
}


</style>
<body>
	<h1 style="color:black"><center>REVIEW ORDER</center></h1>
	<div class="container" style="align:center">
	
	<c:if test="${!empty cartList}">
	
					<div class="row">
							<div class="col-xs-12">
								<h5 style="color:black"><span style="color:black" class="glyphicon glyphicon-shopping-cart"></span>REVIEW ORDER</h5>
								
							</div>
						<div class="col-xs-12">
			<div class="panel panel-info" >
				<div class="panel-heading">
					<div class="panel-title">
					<div class="row">	
								<div class="col-xs-3">ITEM</div>
								<div class="col-xs-4">DESCRIPTION</div>
								<div class="col-xs-3">QUANTITY</div>
								<div class="col-xs-2">PRICE</div>
								
							</div>
						</div>
					</div>
				</div>
			<div class="panel-body" style="background-color:#ffcce6">
				<c:forEach items="${cartList}" var="cart">
					<div class="row">
						<div class="col-xs-3"><img style="width:50px;height:50px" src="<c:url value="/resources/images/${cart.p_id}.jpg"/>"/>
						</div>
						
						<div class="col-xs-4">
							<h4 class="product-name"><strong>${cart.p_name}</strong></h4>
						</div>
						
						<div class="col-xs-3">
						<h6 ><strong>Quantity:${cart.quantity}</strong></h6>
						</div>
						
							<div class="col-xs-2">
								<h4><strong>Rs.${cart.price}</strong></h4>
							</div>
					</div>
						<hr>
				</c:forEach>
					
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right"> Total:Rs.${sum}</h4>
						   </div>
						<div class="col-xs-3">
		<a href="payment" type="button" class="btn btn-success">PROCEED TO PAY</a>
						</div>
					</div>
     				</div>  
			</div>
		</div>
		</c:if>
	</div>

</body>
</html>