<html>
<head>
<link rel="stylesheet" href="css/profilestyle.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
<body>
<form action="/profilepage">
<header>

	<div class="container">

		<div class="profile">

			<div class="profile-image">

				<img src="${image}" alt="check">

			</div>
</form>
			<div class="profile-user-settings">

				<h1 class="profile-user-name">${username}</h1>
				<br>
			   <form action="/updateDetails" modelAttribute="profileimage" method="post">
				
				<input type="text" placeholder="Image" name="image">
				

				<button class="btn profile-edit-btn" type="submit">Edit Profile</button>
				
				
				

				<button class="btn profile-settings-btn" aria-label="profile settings"><i class="fas fa-cog" aria-hidden="true"></i></button>

			</div>
</form>
		
<form action="/logout">		
<div>
		<input class="button" type="submit" value="logout">
		</div>
	</form>		

		</div>
		<!-- End of profile section -->
		

	</div>
	<!-- End of container -->


</header>



		
		 <ul class="cards">
 		
 <c:forEach var="detail" items="${results}" >
  
  <li>
    <a href="" class="card">
      <img src="${detail.image}" class="card__image" alt=""  />
      <div class="card__overlay">
        <div class="card__header">
         </div>
      
      </div>
    </a> 
       
  </li> 
   <a href="/delteByid/${detail.id}">Delete</a>  
 
 </c:forEach> 
</ul>


		<!-- End of gallery -->


	<!-- End of container -->


</body>
</html>