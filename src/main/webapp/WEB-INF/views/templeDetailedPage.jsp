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
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h4 class="homepageTitle">Temple Finder - Results page</h4>
				<table class="table table-hover">
					<tr>
						<td>${temple.templeName}</td>
						<td><img id="templeImage"
							src="/assets/images/ganesh_image.jpg" alt="ganeshImage" /></td>

						<td>Address: ${temple.addressModel.streetName}<br/>${temple.templeTimings}</td>
						<td><a href="#">Directions</a></td>
						<td><a href="#">Rituals</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>