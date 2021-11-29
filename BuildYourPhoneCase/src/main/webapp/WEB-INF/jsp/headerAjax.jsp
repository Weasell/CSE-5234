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
	</ul>
	</div>
	</nav>
	</div>
      
      
     

     

 
    
    
   
    
    
    
 
 
<script type="text/javascript" src="https://code.jquery.com/jquery-1.7.1.min.js"></script>

</body>
</html>