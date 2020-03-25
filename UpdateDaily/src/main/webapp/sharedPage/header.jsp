<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   <meta name="google-signin-client_id" content="270945131451-o13jnolql6t7th6a107a0ho7lihn5kvb.apps.googleusercontent.com">
  <script src="https://apis.google.com/js/platform.js" async defer></script>

 <nav class="navbar navbar-toggleable-sm  fixed-top navbar-dark bg-primary">
    
    	
    	
    	  <button type = "button" class = "navbar-toggler ml-auto" data-toggle = "collapse" data-target = "#mainNavbar" aria-controls = "navbarNav" aria-expanded = "false" aria-label = "Toggle navigation ">
           <span class="navbar-toggler-icon">
        </span>
     </button>
    	
    	<div class="collapse navbar-collapse text-center" id="mainNavbar" >
    	<a class="navbar-brand" href="${pageContext.request.contextPath}/home" >Belalsoft</a>
    	<ul class="navbar-nav ml-auto">
    	
    			<li class="nav-item dropdown">
    					<a class="nav-link dropdown-toggle" id="navbarDropdwown" role="otherService" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">Health News</a>
    			
    			<div class="dropdown-menu" aria-labelledby="navbarDropdwown">
    					<a class="dropdown-item" href="${pageContext.request.contextPath}/crona">Covid-19</a>
    					<a class="dropdown-item" href="#">Other health issue</a>
    					</div>
    			
    			</li>
    			
    			<li class="nav-item dropdown">
    					<a class="nav-link dropdown-toggle" id="navbarDropdwown" role="otherService" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">Sport News</a>
    			
    					<div class="dropdown-menu" aria-labelledby="navbarDropdwown">
    					<a class="dropdown-item" href="#">Cricket</a>
    					<a class="dropdown-item" href="#">Footbal</a>
    					</div>
    			
    			</li>
    			
    			
    				<li class="nav-item dropdown">
    					<a class="nav-link dropdown-toggle" id="navbarDropdwown" role="otherService" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">Political News</a>
    			
    					<div class="dropdown-menu" aria-labelledby="navbarDropdwown">
    					<a class="dropdown-item" href="#">Daily news</a>
    					<a class="dropdown-item" href="#">Old News</a>
    					</div>
    			
    			</li>
    			
    	 	<c:if test="${userClickedlogin == true}">
    			
    				<li class="nav-item dropdown">
    					<a class="nav-link dropdown-toggle" id="navbarDropdwown" role="otherService" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">My Profile</a>
    			
    					<div class="dropdown-menu" aria-labelledby="navbarDropdwown">
    					<a class="dropdown-item" href="#">Edit</a>
    					<a class="dropdown-item" href="javascript:void(0)" onclick="myFunction()">SignOut</a>
    					</div>
    			
    			</li>
    			
    			</c:if> 
    			
    		
    			<li class="nav-item">
    					<a class="nav-link" href="#">Contact us</a>
    			</li>
    			
    			<c:if test="${userClickedlogin == false}">
    			<li class="nav-item login">
    					<a class="nav-link" href="#"  type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Login</a>
    			</li>
    	</c:if>
    	
    		
    	
    	</ul>
    </div>
    </nav>
 
    
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">lOGIN FORM</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    
           

 				 <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" data-width="290" data-longtitle="true" style="margin-left: 20%"></div> 
        
        		
        		  <div class="centeredText" style="margin-left: 30%">
        		  <h4 style="margin-left:18%">OR</h4>
        		  
					<h5>Login with Your userid ..</h5>
					</div> 

      
        <form action="${pageContext.request.contextPath}/login" method="post">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" placeholder="Enter email" id="email" name="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="password">
  </div>
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
        

      </div>
  
    </div>
  </div>
</div>

<form name="myFormGoogle" action="<c:url value="/loginwithgoogle" />" method="post">
	    <input type="hidden" id="uniqueIdGoogle" name="uniqueId">
		<input type="hidden" id="fullNameGoogle" name="fullName">
		<input type="hidden" id="emailIdGoogle" name="emailId">
		<input type="hidden" id="dpUrlGoogle" name="dpUrl">
		<input type="hidden" name="page" value="index">
	</form>

<script>
function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

  document.getElementById("uniqueIdGoogle").value=profile.getId();      
  document.getElementById("fullNameGoogle").value=profile.getName();      	
	//session.setAttribute("userName",document.getElementById("fullNameGoogle").value);      	
	document.getElementById("emailIdGoogle").value=profile.getEmail();
	document.getElementById("dpUrlGoogle").value=profile.getImageUrl();
/* 	document.myFormGoogle.submit(); */
}
</script>

<script>
function myFunction() {
gapi.auth2.getAuthInstance().disconnect();
alert("logged out")
location.reload();
}
</script>

    