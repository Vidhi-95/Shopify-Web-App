<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class = "container">
    <section>
    <div class="jumbotron">
    <div>
    
    <h1><i>Customer registered successfully</i></h1>
    </div>
    </div>
    </section>
    
  	<div>
  	<a href="<spring:url value="/product/productList"/>"class="btn btn-primary">View Products</a>
  	<a href="<c:url value="/login" />" class="btn btn-primary">Login</a>
  	</div>
   
    </div>
    </section>

<!--  <script src="<c:url value="/resources/js/controller.js" />"></script> -->
<%@include file="/WEB-INF/views/template/footer.jsp" %>