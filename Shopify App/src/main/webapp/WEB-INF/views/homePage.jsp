<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<!--  -->


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide home-image" src="<c:url value="/resources/images/cam2.jpg" />" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Welcome to my online shop</h1>
              <p>Get everything at your doorstep with just a few clicks.</p>
              <p><a class="btn btn-lg btn-primary" href="<c:url value="/register" />" role="button">Register Now to get best prices</a></p>
            </div>
          </div>
        </div>
</div>
</div>

    <div class="container marketing">
      <div class="row">
        <div class="col-lg-4">
        	<a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=laptop" />" role ="button">
          <img class="img-circle" src="<c:url value="resources/images/laptop.jpg"/>" 
          alt="Laptop image" width="140" height="140" > </a>
          <h2>Laptops</h2>
          <p>Premium Laptops with extraordinary features</p>
          </a>
        </div>
		
		<div class="row">
        <div class="col-lg-4">
        	<a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=camera" />" role ="button">
          <img class="img-circle" src="<c:url value="resources/images/camera.jpg"/>" 
          alt="Camera image" width="140" height="140" > </a>
          <h2>Cameras</h2>
          <p>Wide Range of DSLR Cameras available</p>
          </a>
        </div>
        
        <div class="row">
        <div class="col-lg-4">
        	<a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=mobile" />" role ="button">
          <img class="img-circle" src="<c:url value="resources/images/mobile.jpg"/>" 
          alt="Mobile image" width="140" height="140" > </a>
          <h2>Mobile Phones</h2>
          <p>Exclusive Mobile Phones with latest specifications</p>
          </a>
        </div>
	
      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">Prioritizing health and safety</h2>
          <p class="lead">How we are taking care of employees during COVID-19</p>
          <p><i>We are conducting temperature checks across our U.S. and European operations network and Whole Foods Market stores, testing hundreds of thousands of employees daily. If people have a fever, we will ask them to go home and return to work when they are without fever for at least three days.

Millions of masks have been distributed across our network. They are available to all Amazon associates, delivery service partners, Amazon Flex participants, seasonal employees, and Whole Foods Market stores employees. We are encouraging everyone to take and use them.

An important safety step might be regular testing of all employees for COVID-19, including those without symptoms. We have begun assembling equipment we need to build our first lab to process tests and hope to start testing small numbers of our frontline employees soon.</i></p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="<c:url value="resources/images/covid1.jpg" />" alt="Generic placeholder image">
          <a href="https://blog.aboutamazon.com/company-news/how-amazon-prioritizes-health-and-safety-while-fulfilling-customer-orders?token=GW&utm_content=COVID-19_safety_b&utm_medium=card&utm_source=gateway&utm_term=gw0331202" target="_blank">Learn More</a>
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Apple Watch Series 5 Displays Information I Most Appreciate</h2>
          <p class="lead">With each new generation of Apple Watch, Apple adds functionality and variety to the available watch faces users can select and customize to meet their needs and interests. When the Apple Watch Series 5 was released, Apple went so far as to introduce some brand new complications, adding to the long list of information widgets (in software versus horology parlance) available for Apple Watch users to select from.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="<c:url value="resources/images/applq.jpg" />" alt="Generic placeholder image">
          <a href="https://www.ablogtowatch.com/apple-watch-series-5-display-information-i-most-appreciate-on-my-wrist/" target="_blank">Learn More</a>
		 </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">13 Best Laptops for Bloggers in 2019/2020</h2>
          <p class="lead">If you want to start blogging or move your blogging career to the next level,your platform should support all tasks without any hassle. As blogging is one of the laptop lifestyle careers, so your laptop is one of the most important weapons you should have.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="<c:url value="resources/images/lap.jpg" />" alt="Generic placeholder image">
          <a href="https://www.costeffectiveseo.com/best-laptops-for-bloggers/" target="_blank">Learn More</a>
		 </div>
      </div>

      <hr class="featurette-divider">

      <!-- /END THE FEATURETTES -->


       <%@include file="/WEB-INF/views/template/footer.jsp" %>