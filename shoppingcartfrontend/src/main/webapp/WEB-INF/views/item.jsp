<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<jsp:include page="header.jsp" />
 <style>
 body
 {
  background-color:#ffcce6;
  }
  .table-striped > tr:nth-of-type(odd)
  }
 </style>

</head>
<body>
 <div style="color:pink;margin:40px 0px 0px 100px">
   </div>
<%--product list declartion  --%>	
			
			<div class="container" style="align:center">
			<div class="row">
				<c:if test="${!empty selectedProduct.name}">
				
				  <div class="col-sm-4">
				  <img src="<c:url value="/resources/images/${selectedProduct.id}.jpg"/>" width="300px" height="300px"/>
				  
				 <a href="cart_add_${id}"><button  type="button" class="btn btn-warning">Add to Cart</button></a>
							<a href="myCart"><button  type="button" class="btn btn-danger">Buy Now</button></a>
						</div>
				   
                <div class="col-sm-6">
                    <div class="panel panel-info" >
                     <div class="panel-body" style="background-color:#ffcce6">
					<table class="table table-striped">
					
					       <tr>
							<th align="center" width="175"><font color="black">Name</font></th>
							<td align="left" ><font color="black">${selectedProduct.name}</font></td>
							</tr>
							
							<tr>
							<th align="center" width="190"><font color="black">Description</font></th>
							<td align="left" ><font color="black">${selectedProduct.description}</font></td>
							</tr>
							
							<tr>
							<th align="center" width="90"><font color="black">Price</font></th>
							<td align="left" ><font color="black">Rs.${selectedProduct.price}/-</font></td>
							</tr>
							
							<tr>
							<th align="center" width="150"><font color="black">Category</font></th>
							<td align="left" ><font color="black">${selectedProduct.category.name}</font></td>
							</tr>
							
							<tr>
							<th align="center" width="150"><font color="black">Supplier</font></th>
							<td align="left" ><font color="black">${selectedProduct.supplier.name}</font></td>
							</tr>
						
					</table>
					
					</div>
					
					<div class="row text-center">
						
						
				
     				</div>  
					</div>
					</div>
				</c:if>
			</div>
</div>

</body>
</html>