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
  		<a href="/BuildYourPhoneCase/purchase">Phone Case</a>
 		 <a href="#">Product 2</a>
  		<a href="/#">Product 3</a>
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
  <div class="shopping-cart" style="display:none"> <!-- display:block -->
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
    <c:if test="${ cartSize == 0}">
		<p>Your Cart is Empty</p>
	 
	</c:if> 
    <c:forEach items="${order.items}" var="item" varStatus="loop">
     <li class="clearfix">
        <img src="${item.image}" alt="image" />
        <span class="item-name"> ${item.name} </span> 
        <span class="item-price">Unit Price: $${item.price}</span> <br>
        <span class="item-quantity">Quantity:<form:input  path="items[${loop.index}].quantity"  type="number" value="${item.quantity }" min="1" max="${storage}" /></span>
        <input type="submit"   value="Update"  ><br>
        <input type="submit" name="${loop.index}" value="Delete"   >
        <form:hidden path="items[${loop.index}].id" value="${item.id}"/>
        
      </li>
    </c:forEach>
    <input type="submit" name="button" value="Checkout" id="checkout"> 
 
    </form:form>
     <c:if test="${ cartSize == 0}">
    <script>document.getElementById("checkout").disabled = true;</script>
    </c:if> 
    
    
    </ul>
 
   <!--   <a href="#" class="button">Checkout</a>  -->
  </div> <!--end shopping-cart -->
</div> <!--end container -->
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.7.1.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/cart.js"></script>
   
</body>
</html>