<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>


<spring:url var="css" value="/resources/css"></spring:url>

<spring:url var="js" value="/resources/js"></spring:url>


<html>

<head>
<title>${title}</title>




   <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Poppins:300,300i,400,500,600,700,800,900,900i%7CRoboto:400">
    <link rel="stylesheet" href="${css}/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/fonts.css">
    <link rel="stylesheet" href="${css}/style.css">
    
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    
    <style>
    
    a{
    
    font-size: 15px;
    font-style:sans-serif;
    color:black;
    
    
    }
     

 .myimages {
     display: flex;
     overflow: hidden;
     height: 50vw;
     background: #333
 }

 .myimages img {
     max-width: 100%;
     vertical-align: middle;
     border: 2px solid white;
     box-sizing: border-box;
     transition: opacity .2s
 }

 .myimages:hover img {
     opacity: 0.5
 }
    
    
     .myimages img:hover {
     opacity: 1
 }

 .first-column {
     animation: var(--animation, none) 16s infinite linear
 }

 .first-column:hover {
     animation-play-state: paused
 }

 .first-column:nth-of-type(odd) {
     align-self: flex-end;
     --direction: 50%
 }

 @keyframes slide {
     to {
         -webkit-transform: translateY(var(--direction, -50%));
         transform: translateY(var(--direction, -50%))
     }
 }
   
    
    </style>
    
    
    
   
    </head>
    
    <body>
    
    <!-- navbar section -->
    <jsp:include page="/sharedPage/header.jsp"></jsp:include>
    <!-- end of navbar section -->
    
    
    <!-- body content -->
    
    <div class="container-fluid fixed" style="margin-top:72px;border:solid red;overflow-y:scroll;height: 1000px">
    <c:if test="${userClickedCrona == true}">
    <jsp:include page="/sharedPage/CronaVirus.jsp"></jsp:include>
    
    </c:if>
    
    
    
       <c:if  test="${not empty userClickedloginmsg}">
  			<h1>${userClickedloginmsg}</h1>
    
    </c:if>
    		
   </div>
    
    
    


<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<%-- <script src="${js}/jquery.validate.js"></script> --%>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		<script>

	
		$(document).ready(function(){

			alert("its workig")

			[...document.querySelectorAll('.first-column')].map(column => {
			column.style.setProperty('--animation', 'slide');
			column.style.setProperty('height', '200%');
			column.innerHTML = column.innerHTML + column.innerHTML;
			});

			});

		</script>
		
		
		
		    </body>

</html>