<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase</title>
<style><%@include file="/css/BasicStyle.css"%></style> 
</head>
<body>
<jsp:include page="header.jsp" />
<div class="content">

<h2>Product List</h2>
 
 
 <c:forEach items="${product.items}" var="item" varStatus="loop">
 	<form:form  modelAttribute="itemAttribute" method="post" action="purchase/addToCart">  
 		<form:hidden path="id" value="${item.id}"/>
		<img class="responsive" src="${ item.image}">
 		 <p>${item.name}</p>
 		 <p>Unit Price: $${item.price}</p>
 		 
 		<input type="submit" value="ADD TO CART">  
 
	</form:form>  
 	
 </c:forEach> 
 
  
 
 


</div>

<jsp:include page="footer.jsp" />

</body>
</html>