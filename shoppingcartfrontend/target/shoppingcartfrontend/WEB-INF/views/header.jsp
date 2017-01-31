<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" -->
<!--  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
  
  <link rel="stylesheet"
 href="resources/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>
  
  <style>
  
  body
 {
  background-color:#ffcce6;
  }
  
  .navbar-inverse{
  background-color:#660035;
  }
  .dropdown-menu
  {
  background-color:khaki;
  }
 
  </style>
  
</head>
<body>

<nav class="navbar navbar-inverse"  >
  <div class="container-fluid" style="color:white">
    <div class="navbar-header" style="color:white">
      <a style="color:#ff8080" class="navbar-brand" href="home"><span style="color:Khaki"class="glyphicon glyphicon-flash"></span>WATCHES</a>
    </div>
   
  
    <ul class="nav navbar-nav">
       <li><a style="color:Khaki; margin:0px 0px 0px 0px" href="<c:url value="home"/>"><span class="glyphicon glyphicon-home"></span> HOME</a></li>
      
   
      <c:forEach items="${categoryList}" var="category">
      <li class="dropdown">
      <a style="color:Khaki" class="dropdown-toggle" data-toggle="dropdown" href="${category.name}">${category.name}<span class="caret"></span> </a>
      <ul class="dropdown-menu">
   
      <c:forEach items="${category.products}" var="product">
      <li><a  href="<c:url value='product_get_${product.id}'/>"> ${product.name} </a>
    
     </c:forEach>
     </ul>
      </li>       
      </c:forEach>
         </ul>
    
    <ul class="nav navbar-nav navbar-right">   
      <li class="divider-vertical"></li>
       <c:if test="${pageContext.request.userPrincipal.name != null}">
      <c:if test="${pageContext.request.userPrincipal.name != 'asma786@gmail.com'}"> 
      </c:if>
      
      <c:if test="${pageContext.request.userPrincipal.name  == 'asma786@gmail.com'}">
       <li><a style="color:Khaki" href="<c:url value="/admin"/>">VIEW ALL</a></li>  
       </c:if>
      
       <li><a style="color:Khaki" href="contactus"><span class="glyphicon glyphicon-phone-alt"></span>CONTACTUS</a></li>
        <li><a style="color:Khaki">Hello, ${pageContext.request.userPrincipal.name}</a></li>
             <li><a  style="color:Khaki;margin:0px 0px 0px 0px" href="<c:url value="/myCart"/>"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a>${cartSize}</li>
       <li><a  style="color:Khaki;margin:0px 0px 0px 0px" href="<c:url value="/j_spring_security_logout" />"> <span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
       </c:if>
       
       <c:if test="${pageContext.request.userPrincipal.name  == null}">
       
       <li><a  style="color:Khaki;margin:0px 0px 0px 0px" href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a></li>
       <li><a  style="color:Khaki;margin:0px 0px 0px 0px" href="<c:url value="memberShip.obj"/>"><span class="glyphicon glyphicon-user"></span> SIGN UP</a></li>
       </c:if>
    
    
<!--           <li><a href="register" ><span class="glyphicon glyphicon-log-in"></span>Sign Up</a></li>  -->
<!--              <li><a href="admin" ><span class="glyphicon glyphicon-log-in"></span>Admin Page</a></li>  -->
<!--           <li><a data-toggle="modal" data-target="#loginmodal"><span class="glyphicon glyphicon-user"></span>Login</a></li>  -->
    </ul>
  </div>
</nav>

</body>
</html>