<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/carousel/">

    <title>Shopify</title>
  
	<!-- Angular JS CSS -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
	
	<!-- Jquery library -->
	<script type= "text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<!-- Data table library -->
	<script type= "text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    
    <!-- Main CSS file -->
     <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
     <!-- CSS link for JQuery table -->
      <link href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel="stylesheet">
     
     <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
 	
 	</head>
<!-- NAVBAR
================================================== -->
  <body>
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">ShopEasy</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a href="<c:url value="/"/>">Home</a></li>
                <li><a href="<c:url value="/product/productList/all"/>">Products</a></li>
                <li><a href="<c:url value="/aboutUs" />">About Us</a></li>
              </ul>
                <ul class = "nav navbar-nav pull-right">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                <li><a href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-off"></span> </a></li>
                <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
               		<li><a href="<c:url value="/customer/cart" />"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
               		<li><a href="<c:url value="/admin" />">Admin</a></li>
                </c:if>
                </c:if>
                 <c:if test="${pageContext.request.userPrincipal.name == null}">
               		<li><a href="<c:url value="/login" />">Login</a></li>
              		<li><a href="<c:url value="/register" />">Register</a></li>
                </c:if>
              
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>
