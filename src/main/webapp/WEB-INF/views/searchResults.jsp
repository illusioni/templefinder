<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Temple Finder - Results</title>
<%@ include file="/WEB-INF/views/includes/assets.jsp"%>
<script src="<c:url value='/assets/js/app/searchResults.js' />"
	type="text/javascript"></script>
<link type="text/css"
	href="<c:url value='/assets/css/app/searchResults.css' />"
	rel="stylesheet" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<a class="navbar-brand"
						style="color: #2980B9; font-family: 'Bungee Inline'; font-size: 29px" id="companyLogo">Temple
						Finder</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				</nav>
				<div id="resultsDiv">
					<div id="tableResultsDiv" class="backGroundHeroImage">
						<table class="table table-hover">
							<thead>
							</thead>
							<c:forEach var="temple" items="${templeList}">
								<tr onClick="showTempleDetails('${temple.tid}')">
									<td>${temple.templeName}</td>
									<td>${temple.address.streetName}</td>
									<td><img id="templeImage"
										src="/assets/images/krishna_image.jpeg" alt="krihsnaImage" /></td>
									<td><a href="#">Directions</a></td>
									<td><a href="#">Rituals</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>