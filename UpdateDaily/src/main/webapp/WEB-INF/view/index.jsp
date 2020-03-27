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




<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Poppins:300,300i,400,500,600,700,800,900,900i%7CRoboto:400">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/fonts.css">
<link rel="stylesheet" href="${css}/style.css">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


</head>

<body>

	<!-- navbar section -->
	<jsp:include page="/sharedPage/header.jsp"></jsp:include>
	<!-- end of navbar section -->


	<!-- body content -->


	<div class="container-fluid fixed"
		style="margin-top: 72px; border: solid red; overflow-y: scroll; height: 1000px">

		<!--crona virus page start  -->
		<c:if test="${userClickedCrona == true}">
			<jsp:include page="/sharedPage/CronaVirus.jsp"></jsp:include>

		</c:if>
		<!--crona virus page start  -->


		<!--login messsage alert start  -->
		<c:if test="${not empty userClickedloginmsg}">

			<div class="alert alert-warning alert-dismissible fade show"
				role="alert" style="position: relative">
				<strong>${userClickedloginmsg}!</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

		</c:if>
		<!--login messsage alert end  -->

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




</body>

</html>