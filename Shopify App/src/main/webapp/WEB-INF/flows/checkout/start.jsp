<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<body>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h2 class="alert alert-success"><b> <i>Thank you for shopping with ShopEasy. We are happy to serve you.</i></b></i></h1>

                    <p>Your order will be delivered to you within 3-4 business days at your shipping Address !</p>
					
                </div>
            </div>
        </section>

 <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                        <div class="text-center">
                            <h1>Receipt</h1>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Shipping Address</strong> <br>
                                        ${order.cart.customer.shippingAddress.streetName}
                                        <p>Park Drive</p>
                                    <br>
                                        ${order.cart.customer.shippingAddress.apartmentNumber}
                                        <p>#4</p>
                                    <br>
                                        ${order.cart.customer.shippingAddress.city} <p>${order.cart.customer.shippingAddress.state}</p>
                                        <p>Boston, MA</p>
                                    <br>
                                        ${order.cart.customer.shippingAddress.country} <p>${order.cart.customer.shippingAddress.zipCode}</p>
                                        <p>USA, 02120</p>
                                    <br>
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p>
                                    <em>Shipping Date: <fmt:formatDate type="date" value="${now}"/></em>
                                </p>
                            </div>
                        </div>
                        

                        <div class="row">

                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <td>Product</td> <td>Oppo Mobile Phone</td> <td>DSLR Nikon Camera</td>
                                    <th>#</th>
                                    <td class="text-center">Price</td> 
                                    <td class="text-center">Total</td> <p>$ 1598.0 USD</td>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                                        <td class="col-md-6"><em>${cartItem.product.productName}<p>Oppo Mobile Phone</p></em></td>
                                        <td class="col-md-1" style="text-align: center">
                                                ${cartItem.quantity}<p>2</p></td>
                                        <td class="col-md-1 text-center">$${cartItem.product.productPrice}</td><p>$ 599.0 USD</p>
                                        <td class="col-md-1 text-center">$${cartItem.totalPrice}<p>$ 1598.0 USD</td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right"><h4>
                                        <strong>Grand Total: </strong>
                                    </h4></td>
                                    <td class="text-center text-danger"><h4>
                                        <strong>$${order.cart.totalBillingAmount}</strong><p> 1598.0 USD</p>
                                    </h4></td>
                                </tr>
                                </tbody>
                            </table>
</div>

        <section>
            

        </section>
        <div class="container">
                <p>
                    <a href="<spring:url value="/" />" class="btn btn-primary">
                        <span class="glyphicon-hand-left glyphicon"></span> Explore Products
                    </a>
                </p>
            </div>
    </div>
</div>
</body>
<%@include file="/WEB-INF/views/template/footer.jsp" %>