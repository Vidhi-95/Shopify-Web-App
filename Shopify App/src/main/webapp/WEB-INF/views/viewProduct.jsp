<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="/WEB-INF/views/template/header.jsp" %>
    
    <div class="container-wrapper">
    <div class = "container">
    
    <div class = "page-header">
    <h1>Product Details!</h1>
    <p class="lead">Please find detailed info for product below</p>
    </div>
   
   <div class="container" ng-app ="cartApp">
   	<div class="row">
   	<div class="col-md-5">
   	<img src="<c:url value="/resources/images/${product.productId}.jpg" />" alt="#image" style="width:100%; height:300px" />
   	</div>
   	
   <div class="col-md-5">
    
   <h3>${product.productName}</h3>
   
   <p><strong>Description: </strong>${product.productDescription}</p>
   <p><strong>Category: </strong>${product.productCategory}</p>
   <p><strong>Manufacturer: </strong>${product.productManufacturer}</p>
   <p><strong>Price: </strong>${product.productPrice} USD</p>
   <br>
   <!-- Changing the url logic for admin and guest user -->
   <c:set var="role" scope="page" value="${param.role}"></c:set>
   <c:set var="url" scope="page" value="/product/productList"></c:set>
   <c:if test="${role='admin'}">
    <c:set var="url" scope="page" value="/admin/productInventory"/>
   </c:if>
   <p ng-controller="CartControl">
   <a href="<c:url value="${url}" />" class="btn btn-default"><span class= "glyphicon glyphicon-backward"></span>Back</a>
   <a href="#" class="btn btn-warning btn-large"
   		ng-click="addToCart('${product.productId}')"><span 
   		class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
   <a href="<spring:url value="/customer/cart/${cartId}" />"
   class="btn btn-default"><span class="glyphicon glyphicon-hand-right">View Cart</span></a>
   </p>
      </div>
	</div>
	</div>
	<script src="<c:url value="/resources/js/controller.js" />"></script>
   <%@include file="/WEB-INF/views/template/footer.jsp" %>