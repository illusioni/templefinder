<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Temple Finder App</title>
        <link type="text/css" href="<c:url value='/assets/css/lib/bootstrap.min.css' />" rel="stylesheet" />
        <link type="text/css" href="<c:url value='/assets/css/app/app.css' />" rel="stylesheet" />
        <script src="<c:url value='/assets/js/lib/jquery-3.3.1.min.js' />" type="text/javascript"></script>
        <script src="<c:url value='/assets/js/lib/bootstrap.min.js' />" type="text/javascript"></script>
        <script src="<c:url value='/assets/js/app/app.js' />" type="text/javascript"></script>
        
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="homepageTitle">Temple Finder - Find Temples in your city</h4>
                    <hr>
                    <div class="form-group">
                     <input type="text" class="form-control" id="searchText" placeholder="Area Name, Zip Code, Temple Name, God">
                    </div>
                    <div class="text-center">
		               <button type="submit" class="btn btn-primary btn-md">	<span class="glyphicon glyphicon-search"></span>Submit</button>
		            </div>      
                </div>
            </div>
        </div> 
    </body>
</html>