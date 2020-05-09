<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
    
    <div class="container-wrapper">
    <div class = "container">
    <div class = "page-header">
    <h1>Manage Customers!</h1>
    <p class="lead">View all details about customers</p>
    </div>
   
    <table class="table table-striped table-hover">
  <thead>
  <tr class="bg-success">
  					
					<th>Customer Name</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Username</th>
					<th>Is Enabled?</th>
					<th>Shipping State</th>
					<th>Shipping Country</th>
					
  </tr>
  </thead>
  <c:forEach items="${customerList}" var="customer">
  <tr>
						
						<td>${customer.customerName}</td>
						<td>${customer.customerEmail}</td>
						<td>${customer.customerPhone}</td>
						<td>${customer.username}</td>
						<td>${customer.enabled}</td>
						<td>${customer.shippingAddress.state}</td>
						<td>${customer.shippingAddress.country}</td>
						
				</tr>
  </c:forEach>
  
</table>


    <%@include file="/WEB-INF/views/template/footer.jsp" %>
