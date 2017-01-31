<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<jsp:include page="header.jsp" />
 <style>
 body
 {
  background-color:#ffcce6;
  }
 </style>
<body>

<form:form action="add_product" commandName="product" method="post" enctype="multipart/form-data">
<table>

<tr>
<td>Product ID:</td>
<c:choose>
<c:when test="${!empty product.id}">
<td><form:input type="text" path="id" name="id" disabled="true" readonly="true"/></td>
</c:when>
<c:otherwise>
<td><form:input type="text" path="id" name="id"/></td>
</c:otherwise>
</c:choose> 
</tr>

<tr>
<form:input path="id" hidden="true"/>
<td>Product Name:  </td>       
 <td><form:input type="text" path="name" name="name"/></td>
</tr>

<tr>
<td>Product Description:  </td>
<td> <form:input type="text" path="description" name="description"/></td>
</tr>

<tr>
<td>Product Price:  </td>     
 <td> <form:input type="text" path="price" name="price"/></td>
  </tr>
  
  <tr>
<td>Product Stock: </td>  
     <td> <form:input type="text" path="stock" name="stock"/></td>
</tr>

<tr>
<td>Choose image:</td>
<td> <form:input type="file" path="image" name="image" width="300px" height="300px"/>
</tr>

<tr>
<td>Category List:</td>
<td><form:select path="category.name" items="${categoryList}" itemValue="name" itemLabel="name"></form:select></td>
</tr>

<tr>
<td>Supplier List:</td>
 <td> <form:select path="supplier.name" items="${supplierList}" itemValue="name" itemLabel="name"></form:select></td>
 </tr>
 <tr>
<tr>
<td><input type="submit" value="Submit"></td>
<td><input type="reset" value="Reset"></td>
</tr>

</table>
</form:form>
<div>

<center><h4>PRODUCT LIST</h4></center>
<c:if test="${!empty productList}">
<table class="table table-bordered">
 <thead>
<tr>
<th>PRODUCT ID</th>
<th>PRODUCT NAME</th>
<th>PRODUCT DESCRIPTION</th>
<th>PRODUCT PRICE</th>
<th>PRODUCT STOCK</th>
<th>CATEGORY_ID</th>
<th>SUPPLIER_ID</th>
<th>PRODUCT IMAGE</th>
<th>EDIT</th>
<th>DELETE</th>
</tr>
 </thead>
<c:forEach items="${productList}" var="product">
<tr>
<td>${product.id}</td>
<td>${product.name}</td>
<td>${product.description}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
<td>${product.category_id}</td>
<td>${product.supplier_id}</td>
<td><img src="<c:url value="/resources/images/${product.id}.jpg"/>"width="200" height="200"/></td>
<td><a class="btn btn-warning" href="<c:url value='product_edit-${product.id}'/>">EDIT</a></td>
<td><a class="btn btn-danger" href="<c:url value='product_delete-${product.id}'/>">DELETE</a></td>
</tr>
</c:forEach>
</table>

</c:if>

</div>

</body>
</html>