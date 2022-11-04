<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<title>Add a new Post</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous" />
<style>
body {
	margin-top: 100px;
	background-color: #CCBFD6;
	font-family: "Brush Script MT", cursive;
	font-size: 20px;
}
</style>
</head>
<body>
    <div align="center">
        <h1>Add a new Post</h1>
        <br />
        <form action="/saveDetail" modelAttribute="detailsList" method="post">
<div class="box-form">


	
	
		<div class="right">
		<h3>Register</h3>
		
		<div class="inputs">
			<input type="text" placeholder="Category" name="category" >
			<br>
			<input type="text" placeholder="Name" name="name" >
			<br>
			<input type="text" placeholder="City" name="city_name" >
			<br>
			<input type="text" placeholder="Image" name="image">
			<br>
			
		</div>
			
			<br><br>
		
		    <input class="button" type="submit" value="post">
	</div>
	
</div>
</form>
    </div>
</body>
</html>