<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>


<spring:url var="css" value="/resources/css"></spring:url>

<spring:url var="js" value="/resources/js"></spring:url>


<html>

<head>
<title>${userClickedHome}</title>


   <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Poppins:300,300i,400,500,600,700,800,900,900i%7CRoboto:400">
    <link rel="stylesheet" href="${css}/bootstrap.css">
    <link rel="stylesheet" href="${css}/fonts.css">
    <link rel="stylesheet" href="${css}/style.css">
    
    <style>
    
    body {
  min-height: 75rem;
  padding-top: 4.5rem;
}
    </style>
    </head>
    
    <body>
    
    <!-- navbar section -->
    
    <div class="container-fluid" style="border:solid green">
    
    
    
<h1>welcome  to my project</h1>

<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<%-- <script src="${js}/jquery.validate.js"></script> --%>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		
		
		
		    </body>

</html>