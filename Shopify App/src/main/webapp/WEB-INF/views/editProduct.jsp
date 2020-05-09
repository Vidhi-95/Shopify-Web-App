<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
    
    <div class="container-wrapper">
    <div class = "container">
    
    <div class = "page-header">
    <h1>Edit Product!</h1>
    <p class="lead">Edit any product information here</p>
    </div>
   <form:form action="${pageContext.request.contextPath}/admin/product/editProduct" method="post" 
   commandName="product" enctype="multipart/form-data">
   
   
   <div class="form-group">
   <label for="name">Name</label> <form:errors path="productName" cssStyle="color: #ff0000;" />
   <form:input type="text" class="form-control" value="${product.productName}"	path="productName" id="name"/>
   <form:hidden path="productId" value="${product.productId}"/>
   </div>
   <div class="form-group">
							<label for="category">Category</label>
								 <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="laptop"/>Laptops</label>
								  <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="camera"/>Cameras</label>
								  <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="mobile"/>Mobile Phones</label>
	</div>	
	<div class="form-group">
   <label for="description">Description</label>
   <form:textarea type="text" placeholder="Enter Product Description.." class="form-control" path="productDescription" value="${product.productDescription}" id="description"/>
   </div>
   	
   <div class="form-group"> 
   <label for="price">Price</label> <form:errors path="productPrice" cssStyle="color: #ff0000;" />
   <form:input type="text" placeholder="Enter Price" class="form-control" path="productPrice" value="${product.productPrice}" id="price"/>
   </div>
   
   <div class="form-group">
						<label for="condition">Condition</label>
								 <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="new"/>New</label>
								  <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="used"/>Used</label>
	</div>
   	
   	 <div class="form-group">
						<label for="status">Status</label>
								 <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active"/>Active</label>
								  <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="inactive"/>Inactive</label>
	</div>	
	<div class="form-group">
						<label for="unitInStock">Units in Stock</label> <form:errors path="unitInStock" cssStyle="color: #ff0000;" />
						<form:input type="text" placeholder="Enter units" class="form-control" path="unitInStock" value="${product.unitInStock}" id="unitInStock"/>		 
	</div>
	<div class="form-group">
						<label for="manufacturer">Manufacturer</label>
						<form:input type="text" placeholder="Enter Manufacturer" class="form-control" path="productManufacturer" value="${product.productManufacturer}" id="manufacturer"/>		 
	</div>
	
	<div class="form-group">
						<label class="control-label" for="productImage">Upload Picture</label>
						<form:input type="file" class="form-input-large" path="productImage" id="productImage"/>		 
	</div>
	
	<br><br>
	<input type="submit" value="submit" class="btn btn-default">
	<a href="<c:url value="/admin/productInventory" />"class= "btn btn-default">Cancel</a> 			
   </form:form>

    <%@include file="/WEB-INF/views/template/footer.jsp" %>
