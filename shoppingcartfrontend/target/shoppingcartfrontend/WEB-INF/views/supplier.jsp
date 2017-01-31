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
<form:form action="add_supplier" commandName="supplier" method="post">
<table>

<tr>
<td>Supplier ID:</td>
<c:choose>
<c:when test="${!empty supplier.id}">
<td><form:input type="text" path="id" name="id" disabled="true" readonly="true"/></td>
</c:when>
<c:otherwise>
<td><form:input type="text" path="id" name="id"/></td>
</c:otherwise>
</c:choose> 
</tr>

<tr>
<form:input path="id" hidden="true"/>
<td>Supplier name:</td>
<td><form:input type="text" path="name" name="name"/></td>
</tr>

<tr>
<td>Supplier Address:</td>  
<td> <form:input type="text" path="address" name="address"/></td>
</tr>

<tr>
<td><input type="submit" value="Submit"/></td>
<td><input type="reset" value="Reset"/></td>
</tr>

</table>
</form:form>
<div>
<center><h4>SUPPLIER LIST</h4></center>
<c:if test="${!empty supplier}">
<table class="table table-bordered">

<thead>
<tr>
<th>SUPPLIER ID</th>
<th>SUPPLIER NAME</th>
<th>SUPPLIER ADDRESS</th>
<th>EDIT</th>
<th>DELETE</th>
</tr>
</thead>
<c:forEach items="${supplierList}" var="supplier">

<tr>
<td>${supplier.id}</td>
<td>${supplier.name}</td>
<td>${supplier.address}</td>
<td><a class="btn btn-warning" href="<c:url value='supplier_edit-${supplier.id}'/>">EDIT</a></td>
<td><a class="btn btn-danger" href="<c:url value='supplier_delete-${supplier.id}'/>">DELETE</a></td>
</tr>

</c:forEach>
</table>
</c:if>
</div>

</body>
</html>