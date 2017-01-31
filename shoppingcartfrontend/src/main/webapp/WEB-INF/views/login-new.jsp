<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>">
      
       <link rel="stylesheet"
 href="resources/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
      
</head>

  
  
  <style>
 body
 {
  background-color:#ffcce6;
  }
 </style>
 
   
<body>

<a href="home"><span class="glyphicon glyphicon-home"></span></a>

<br>
<br>		




<div class="form">
	<div id="login">   
	
      <h1>LOGIN</h1>
          
          <form  action="<c:url value='j_spring_security_check'/>"  method="POST" role="form">
          
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" required autocomplete="off" name="username" />
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" required autocomplete="off" name="password" />
          </div>
          &nbsp;<br>
          <div>	
         <a href="home" class="button btn-success">LOGIN</a>
          </div>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          </form>

			
        </div>
	  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="<c:url value="resources/js/index.js"/>"></script>
	

	</div>	
</body>
</html>