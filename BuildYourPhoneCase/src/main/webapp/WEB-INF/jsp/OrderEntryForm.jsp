<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/WEB-INF/css/BasicStyle.css"%></style>


<title>Purchase</title>
</head>
<body>
<div class="content">
<h2>Product List</h2>

 
 <c:forEach items="${product.items}" var="item" varStatus="loop">
 	<form:form  modelAttribute="itemAttribute" method="post" action="purchase/addToCart">  
 
 		<form:input path="name" readonly="true" value="${item.name}" />  
 		<form:input path="price" readonly="true" value="${item.price}"/>  
 		<form:input path="quantity" readonly="true" value="${item.quantity}"/>  
 		<input type="submit" value="ADD TO CART">  
 
	</form:form>  
 	
 </c:forEach> 
 
  
  
<form:form   method="post" action="purchase/addToCart">  
 	<input type="submit" value="CART">  
</form:form>  

 
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/cart.js"></script>
	
 
 


  

</div>


</body>
</html>