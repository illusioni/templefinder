<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temple Finder App</title>
<%@ include file="/WEB-INF/views/includes/assets.jsp"%>
<script src="<c:url value='/assets/js/app/app.js' />"
	type="text/javascript"></script>
<link type="text/css" href="<c:url value='/assets/css/app/app.css' />"
	rel="stylesheet" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<a class="navbar-brand"
						style="color: #2980B9; font-family: 'Bungee Inline'; font-size: 29px">Temple
						Finder</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				</nav>
				<form id="searchForm" class="entireForm backGroundHeroImage">
					<div>
						<c:if test="${not empty errorMessage}">
							<div class="errorMessage">
								<c:out value="${errorMessage}"></c:out>
							</div>
						</c:if>
					</div>
					<div class="form-group text-center">
						<label class="subHeadingCity">Find Temples in your city</label> <input
							type="text" class="form-control" id="searchText"
							placeholder="Temple Name">
					</div>
					<div class="text-center">
						<button type="button" id="searchButton"
							class="btn btn-primary btn-md">
							<span class="glyphicon glyphicon-search"></span>Search
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>