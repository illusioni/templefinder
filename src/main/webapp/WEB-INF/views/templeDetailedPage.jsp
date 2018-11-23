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
<link type="text/css"
	href="<c:url value='/assets/css/app/templeDetailedPage.css' />"
	rel="stylesheet" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<a class="navbar-brand"
						style="color: #2980B9; font-family: 'Bungee Inline'; font-size: 29px"
						id="companyLogo">Temple Finder</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				</nav>
				<div id="resultsDiv">
					<table class="table">
						<tr>
							<td class="templeImages"><img id="templeImage" src="/assets/images/ganesh_image.jpg" /></td>
							<td class="addressTd"><table>
									<tr>
										<td><b>Name:</b></td>
										<td>${temple.templeName}</td>
									</tr>
									<tr>
										<td><b>Address:</b></td>
										<td>${ temple.address.streetName },${ temple.address.houseNo }
										</td>
									</tr>
									<tr>
										<td colspan="2" align="right">${ temple.address.postalCode },${ temple.address.cityName }
										</td>
									</tr>
								</table></td>
						</tr>
						<tr>
							<td class="ritualsContainer">
								<!-- TODO: Build a temple with Rituals day by day -->
							</td>
							<td class="directionContainer"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>