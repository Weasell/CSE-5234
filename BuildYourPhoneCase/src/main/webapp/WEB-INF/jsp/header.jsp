<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
 
<style><%@include file="/css/header.css"%></style> 
  
</head>
<body>

<div class="onlyHeader">
  <nav>
  <div class="container">
    <ul class="navbar-left">
      <li><a href="/BuildYourPhoneCase/">Home</a></li>
      <li><a href="/BuildYourPhoneCase/about">About</a></li>
      
      <li>
      <div class="dropdown">
  		<button class="dropbtn">Products</button>
 		 <div class="dropdown-content">
  		<a href="/BuildYourPhoneCase/purchase?pageNum=1">Phone Case</a>
 		 <a href="/BuildYourPhoneCase/purchase?pageNum=2">Braid Phone Lanyard</a>
  		<a href="/BuildYourPhoneCase/purchase?pageNum=3">Phone Holder</a>
 		 </div>
</div>
      
      
      
      </li>
      
    </ul> <!--end navbar-left -->

    <ul class="navbar-right">
     <li><a href="/BuildYourPhoneCase/contactus">ContactUs</a></li>
      <li><a href="#" id="cart"><i class="fa fa-shopping-cart"></i> Cart <span class="badge">${cartSize}</span></a></li>
      
    </ul> <!--end navbar-right -->
  </div> <!--end container -->
</nav>



<div class="container">
  <div class="shopping-cart" style="display:block"> <!-- display:none -->
    <div class="shopping-cart-header">
      <i class="fa fa-shopping-cart cart-icon"></i><span class="badge">${cartSize}</span>
      <div class="shopping-cart-total">
        <span class="lighter-text">Total:</span>
        <span class="main-color-text">${sum}</span>
      </div>
    </div> <!--end shopping-cart-header -->
	
    <ul class="shopping-cart-items">
    
    <form:form  modelAttribute="order" method="post" action="purchase/submitItems"> 
    <c:if test="${duplicateItem != ''}">
		<p id="warning">${duplicateItem} has already been added into the cart</p>
	 
	</c:if> 
	<c:if test="${maxOrderNum != ''}">
	 	<p id="warning">${maxOrderNum}  </p>
	 	 
	</c:if> 
	 
    <c:if test="${ cartSize == 0}">
		<p>Your Cart is Empty.</p>	 
	</c:if> 
    <c:forEach items="${order.items}" var="item" varStatus="loop">
      <li class="clearfix row">
      	 <div class = "col-sm-5">
         	<img src="${item.picURL}" alt="image"  class="img-responsive" width="100%" />
         </div>
         <div class = "col-sm-7">
	         <h5 class="item-name"> ${item.name} </h5> 
	         <h6 class="item-price">$${item.price}</h6>
	         <div class="input-group mb-2 mr-sm-2">
			    <div class="input-group-prepend">
			      <div class="input-group-text">Qty:</div>
			    </div>
       			<form:input path="items[${loop.index}].availableQuantity"  class="form-control form-control-sm " type="number" value="${item.availableQuantity }" min="1"   /> <!--max="${storage}" -->  
			  </div>			 
			 <div class="input-group">
			    <button class="btn btn-outline-info btn-sm" type="submit" value="Update">Update</button>
			    <button class="btn btn-outline-danger btn-sm" type="submit" name="${loop.index}" value="Delete" >Delete</button>
			 </div>
		 </div>
         <form:hidden path="items[${loop.index}].id" value="${item.id}"/>
      </li>
    </c:forEach>
    <input type="submit" name="button" value="Checkout" id="checkout" class="btn btn-primary btn-block"> 
    </form:form>
    
    
     <c:if test="${ cartSize == 0}">
    <script>document.getElementById("checkout").disabled = true;</script>
    </c:if> 
    
	 <c:if test="${maxOrderNum != ''}">
	 	<script>document.getElementById("checkout").disabled = true;</script>
	</c:if> 
    
    
    </ul>
 
   <!--   <a href="#" class="button">Checkout</a>  -->
  </div> <!--end shopping-cart -->
</div> <!--end container -->
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.7.1.min.js"></script>

</body>
</html>