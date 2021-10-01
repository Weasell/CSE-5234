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
      <li><a href="#">Home</a></li>
      <li><a href="#about">About</a></li>
    </ul> <!--end navbar-left -->

    <ul class="navbar-right">
      <li><a href="#" id="cart"><i class="fa fa-shopping-cart"></i> Cart <span class="badge">${cartSize}</span></a></li>
    </ul> <!--end navbar-right -->
  </div> <!--end container -->
</nav>



<div class="container">
  <div class="shopping-cart">
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
     	<form:hidden path="items[${loop.index}].id" value="${item.id}"/>
        <img src="${item.image }" alt="image" class="imageInCart" />
        <span class="item-name"> ${item.name} </span>
        <span class="item-price">Unit Price: $${item.price}</span> <br>
        <span class="item-quantity">Quantity:<form:input  path="items[${loop.index}].quantity"  type="number" value="${item.quantity }" min="1" max="${storage}" /></span>
        <input type="submit"   value="Update"   ><br>
        <input type="submit" name="${loop.index}" value="Delete" >
        
      </li>
    </c:forEach>
    <input type="submit" name="button" value="Checkout" id="checkout"> 
 
    </form:form>
     <c:if test="${ cartSize == 0}">
    <script>document.getElementById("checkout").disabled = true;</script>
    </c:if> 
    
   <!-- 
      <li class="clearfix">
        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/195612/cart-item1.jpg" alt="item1" />
        <span class="item-name">Sony DSC-RX100M III</span>
        <span class="item-price">$849.99</span>
        <span class="item-quantity">Quantity: 01</span>
      </li>

      <li class="clearfix">
        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/195612/cart-item2.jpg" alt="item1" />
        <span class="item-name">KS Automatic Mechanic...</span>
        <span class="item-price">$1,249.99</span>
        <span class="item-quantity">Quantity: 01</span>
      </li>

      <li class="clearfix">
        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/195612/cart-item3.jpg" alt="item1" />
        <span class="item-name">Kindle, 6" Glare-Free To...</span>
        <span class="item-price">$129.99</span>
        <span class="item-quantity">Quantity: 01</span>
      </li>
    --> 
    </ul>
 
   <!--   <a href="#" class="button">Checkout</a>  -->
  </div> <!--end shopping-cart -->
</div> <!--end container -->
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.7.1.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/cart.js"></script>
   
</body>
</html>