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


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Poppins:300,300i,400,500,600,700,800,900,900i%7CRoboto:400">

<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/dataTables.bootstrap.css">
 
<link rel="stylesheet" href="${css}/fonts.css">
<link rel="stylesheet" href="${css}/style.css">



</head>

<body>

	<!-- navbar section -->
	<jsp:include page="/sharedPage/header.jsp"></jsp:include>
	<!-- end of navbar section -->


	<!-- body content -->


	<div class="container-fluid fixed"
		style="margin-top: 72px; border: solid red; overflow-y: scroll; height: 1000px">
		
			
		
		<div class="row" >
				<div class="col-md-3" id="leftPannel" style="border:solid green">
				
				<div class="container">
				<H3 class="justify-content-center">RECENT TOPICS</H3>
			</div>
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action">COV-ID</a>
					<a href="${pageContext.request.contextPath}/article" class="list-group-item list-group-item-action">Article</a>
					 <a href="#"
						class="list-group-item list-group-item-action">Third item</a>
				</div>

			</div>
				
				
					
				
					<div class="col-md-9" id="middleSection" style=border:solid green">
					
				
						<!--crona virus page start  -->
						<c:if test="${userClickedCrona == true}">
							<jsp:include page="/sharedPage/CronaVirus.jsp"></jsp:include>
				
						</c:if>
						<!--crona virus page end  -->
					
					
						<!--crona virus page start  -->
						<c:if test="${userClickedArticle == true}">
							<jsp:include page="/sharedPage/Article.jsp"></jsp:include>
				
						</c:if>
						<!--crona virus page end  -->
					
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
				
				
				
		
		</div>
		

	


		

	</div>





	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	 <script src="${js}/jquery.validate.js"></script> 
	

 <!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script> 

	<!-- DataTable Plugin -->
	<script src="${js}/jquery.dataTables.js"></script>
	



<script type="text/javascript">



var $table = $('#productList');

if($table.length)
	{
	$table.DataTable({
		
		lengthMenu:[[3,5,10,-1],['3 record', '5 record', '10 recored','All']],
		pageLength:4,
		
		 


		
		
	});
	}




</script>

<script type="text/javascript">

var products=[
	["1","abc"],
	
	["2","abc"],
	["3","abc"],
	["4","abc"],
	["5","abc"],
	["6","abc"],
	["7","abc"],
	["8","abc"],
	["9","abc"],
	["10","abc"],
	["11","abc"],
	["12","abc"]
	
];

var $table = $('#article');

if($table.length)
	{
	$table.DataTable({
		
		lengthMenu:[[3,5,10,-1],['3 record', '5 record', '10 recored','All']],
		pageLength:2,
		/* data:products */
		
		
		 


		
		
	});
	}




</script>

</body>

</html>