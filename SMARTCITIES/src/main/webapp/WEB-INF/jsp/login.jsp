
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>SmartCity</title>
   <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">


<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"><link rel="stylesheet" href="css/style.css">
 <style type="text/css">
	.error {
		color: red;
		font-style: italic;
	}
</style>
</head>
<body>
 <form action="loginsubmit" method="post" modelAttribute="user">

<div class="box-form">

	<div class="left">
		
		<img alt="not found" src="/images/welcome.png" width="105%" height="100%">		
		
	</div>
	
	
		<div class="right">
		<h3>Login</h3>
		<p>Don't have an account?
		 <a href="registration">Create Your Account</a> it takes less than a minute</p>
		<div class="inputs">
			<input type="text" placeholder="email" name="email" required>
			<br>
			<input type="password" placeholder="password" name="password" required>
		</div>
			
			<br><br>
		
		    <input class="button" type="submit" value="login">
	</div>
	
</div>
</form>

 <%-- <form:form action="loginsubmit" method="post" modelAttribute="user" >
		<h1 align="center">Login</h1>
		
		<div>
		Enter UserName:<form:input type="text" path="email"/><br><br>
		      <form:errors path="email" cssClass="error">
		      </form:errors>
		</div>
		   `
		   <div>
		   Enter password:<form:input type="password" path="password"/><br><br>
	     <form:errors path="password" cssClass="error">
		      </form:errors>
		</div>
		
		<input type="submit" value="login">
</form:form> --%>
</body>
</html>