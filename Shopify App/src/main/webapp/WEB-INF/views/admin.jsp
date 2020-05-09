<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

<%@include file="/WEB-INF/views/template/header.jsp" %>
    
    <div class="container-wrapper">
    <div class = "container">
    <div class = "page-header">
    <h1>Admin Page!</h1>
    <p class="lead">This is the admin page</p>
    </div>
    
    <c:if test="${pageContext.request.userPrincipal.name!=null}"> 
    <h2>Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout"/>">Logout</a></h2>
    </c:if>
  
	<h3>
	<a href="<c:url value="/admin/productInventory" />">Product Inventory</a>
	</h3>
	
	<h3>
	<a href="<c:url value="/admin/customer" />">Manage Customers</a>
	</h3>
	<p>You have the rights to add, view, modify and delete the customers here </p>
    <%@include file="/WEB-INF/views/template/footer.jsp" %>
