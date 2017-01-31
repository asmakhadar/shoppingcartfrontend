		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page isELIgnored="false" %>
    <%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<jsp:include page="header.jsp" />

<style>
 body
 {
  background-color:#ffcce6;
  }
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
	<h1 style="color:black"><center >CART LIST</center></h1>
	<div class="container" style="align:center">
	
	<c:if test="${!empty cartList}">
	
					<div class="row">
							<div class="col-xs-12">
								<h5 style="color:black"><span style="color:black" class="glyphicon glyphicon-shopping-cart"></span> SHOPPING CART </h5>
								
							</div>
						<div class="col-xs-12">
			<div class="panel panel-info" >
				<div class="panel-heading">
					<div class="panel-title">
					<div class="row">	
						<div class="col-xs-3">ITEM</div>
						<div class="col-xs-3">DESCRIPTION</div>
						<div class="col-xs-2">QUANTITY</div>
						<div class="col-xs-2">PRICE	</div>
						<div class="col-xs-2">REMOVE</div>
						</div>
					</div>
				</div>
				<div class="panel-body" style="background-color:#ffcce6">
				<c:forEach items="${cartList}" var="cart">
					<div class="row">
						<div class="col-xs-3"><img style="width:150px;height:100px" src="<c:url value="/resources/images/${cart.p_id}.jpg"/>"/>
						</div>
						
						<div class="col-xs-3">
							<h4  class="product-name"><strong>${cart.p_name}</strong></h4><h4><small></small></h4>
						</div>
						<div class="col-xs-2">
								<input  type="text" class="form-control input-sm" value="${cart.quantity}">
							</div>
							
							<div class="col-xs-2">
								<h4 ><strong>Rs.${cart.price} <span class="text-muted"></span></strong></h4>
							</div>
							
							<div class="col-xs-2">
								<a href="<c:url value='cart_delete_${cart.id}'/>"><button type="button" class="btn btn-success">
									<span class="glyphicon glyphicon-trash"> </span>
								</button></a>
							</div>
						</div>
						<hr>
				</c:forEach>
					
					
					
					<div class="row">
						<div class="text-center">
							<div class="col-xs-9">
								<h6 class="text-right">Added items?</h6>
							</div>
							<div class="col-xs-3">
								
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right"> Amount Payable: Rs. ${sum}</h4>
						   </div>
						<div class="col-xs-3">
							<a href="checkout" type="button" class="btn btn-warning btn-block">
								PLACE ORDER
							</a>
						</div>
					</div>
     				</div>  
			</div>
		</div>
	</div>
	</c:if>
</div>

</body>
</html>
			