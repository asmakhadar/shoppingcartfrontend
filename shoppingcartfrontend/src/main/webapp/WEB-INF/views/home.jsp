<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- if the user logged in,these links should not be displayed
how i know whether user is logged or not---usesuccessmessage -->

       <!-- we hve to write if conditions so that login and
      //register message shld nt display 
      // include is used to link 'n' no. of jsp pages
    -->
      
<c:if test="${empty successMsg}"> 
<a href="login">Login</a>
<br>
<a href="register">Register</a>
<br>
  </c:if>


<!-- we need to JSTL JSP tag library -->
<hr>
${successMsg}

<c:if test="${showLoginPage}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>
   
   <c:if test="${not empty errorMsg}">
   ${errorMsg }
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${showRegistrationPage}">
<jsp:include page="registration.jsp"></jsp:include>
</c:if>

</body>
</html>