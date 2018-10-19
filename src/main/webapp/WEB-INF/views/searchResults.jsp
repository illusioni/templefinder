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
						<td>Krishna Temple</td>
						<td><img id="templeImage"
							src="/assets/images/krishna_image.jpeg" alt="krihsnaImage" /></td>
						
						<td>Address:GoetheStraße 11001 Munich</td>
						<td><a href="#">Directions</a></td>
						<td><a href="#">Rituals</a></td>
					</tr>
					<tr>
						<td>Ganesh Temple</td>
						<td><img id="templeImage"
							src="/assets/images/ganesh_image.jpg" alt="ganeshImage" /></td>
						
						<td>Address:Barthstr 80339 DonneBergerbruke</td>
						<td><a href="#">Directions</a></td>
						<td><a href="#">Rituals</a></td>
					</tr>
					<tr>
						<td>Shiva Temple</td>
						<td><img id="templeImage"
							src="/assets/images/ganesh_image.jpg" alt="ganeshImage" /></td>
						
						<td>Address:Barthstr Laim</td>
						<td><a href="#">Directions</a></td>
						<td><a href="#">Rituals</a></td>
					</tr>
					<tr>
						<td>Gurunanak Temple</td>
						<td><img id="templeImage"
							src="/assets/images/ganesh_image.jpg" alt="ganeshImage" /></td>
						
						<td>Address:Barthstr Karsfeld</td>
						<td><a href="#">Directions</a></td>
						<td><a href="#">Rituals</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>