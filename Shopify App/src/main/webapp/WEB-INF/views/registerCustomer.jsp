<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
    
    <div class="container-wrapper">
    <div class = "container">
    
    <div class = "page-header">
    <h1>Register customer page!</h1>
    <p class="lead">Fill all the information below to register</p>
    </div>
   <form:form action="${pageContext.request.contextPath}/register" method="post" 
   commandName="customer">
   
 <h2><i>Basic Information Section</i></h1>
   
   <div class="form-group">
	   <label for="name">Name</label>
	   <form:errors path="customerName" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="customerName" id="name"/>
   </div>
   
   <div class="form-group">
	   <label for="email">Email ID</label><span style="color:#800000">${emailValidationMsg}</span>
	   <form:errors path="customerEmail" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="customerEmail" id="email"/>
   </div>
   
   <div class="form-group">
	   <label for="phone">Phone Number</label><span style="color:#800000">${phoneValidationMsg}</span>
	   <form:errors path="customerPhone" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="customerPhone" id="phone"/>
   </div>
   
   <div class="form-group">
	   <label for="username">User Name</label><span style="color:#800000">${usernameValidationMsg}</span>
	    <form:errors path="username" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="username" id="username"/>
   </div>
   
   <div class="form-group">
	   <label for="password">Password</label>
	   <form:errors path="password" cssStyle="color:#800000" />
	   <form:password class="form-control"	path="password" id="password"/>
   </div> 
   
   <h2><i>Billing Address Section</i></h1>
   
    <div class="form-group">
	   <label for="billingStreet">Street Name</label>
	   <form:input class="form-control"	path="billingAddress.streetName" id="billingStreet"/>
   </div>
   
   <div class="form-group">
	   <label for="billingApartmentNumber">Apartment Number</label>
	   <form:input class="form-control"	path="billingAddress.apartmentNumber" id="billingApartmentNumber"/>
   </div>
   
   <div class="form-group">
	   <label for="billingCity">City Name</label>
	   <form:input class="form-control"	path="billingAddress.city" id="billingCity"/>
   </div>
   
   <div class="form-group">
	   <label for="billingState">State</label>
	   <form:input class="form-control"	path="billingAddress.state" id="billingState"/>
   </div>
   
   <div class="form-group">
	   <label for="billingCountry">Country</label>
	   <form:input class="form-control"	path="billingAddress.country" id="billingCountry"/>
   </div>
   
   <div class="form-group">
	   <label for="billingZipCode">Zip Code</label>
	   <form:input class="form-control"	path="billingAddress.zipcode" id="billingZipCode"/>
   </div>
   
   <h2><i>Shipping Address Section</i></h2>
   
   <div class="form-group">
	   <label for="shippingStreet">Street Name</label>
	   <form:errors path="shippingAddress.streetName" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="shippingAddress.streetName" id="shippingStreet"/>
   </div>
   
   <div class="form-group">
	   <label for="shippingApartmentNumber">Apartment Number</label>
	      <form:errors path="shippingAddress.apartmentNumber" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="shippingAddress.apartmentNumber" id="shippingApartmentNumber"/>
   </div>
   
   <div class="form-group">
	   <label for="shippingCity">City Name</label>
	      <form:errors path="shippingAddress.city" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="shippingAddress.city" id="shippingCity"/>
   </div>
   
   <div class="form-group">
	   <label for="shippingState">State</label>
	      <form:errors path="shippingAddress.state" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="shippingAddress.state" id="shippingState"/>
   </div>
   
   <div class="form-group">
	   <label for="shippingCountry">Country</label>
	    <form:errors path="shippingAddress.country" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="shippingAddress.country" id="shippingCountry"/>
   </div>
   
   <div class="form-group">
	   <label for="shippingZipCode">Zip Code</label>
	     <form:errors path="shippingAddress.zipcode" cssStyle="color:#800000" />
	   <form:input class="form-control"	path="shippingAddress.zipcode" id="shippingZipCode"/>
   </div>
   
	<br><br>
	
	<input type="submit" value="submit" class="btn btn-default">
	<a href="<c:url value="/" />"class= "btn btn-default">Cancel</a> 			
   </form:form>

    <%@include file="/WEB-INF/views/template/footer.jsp" %>
