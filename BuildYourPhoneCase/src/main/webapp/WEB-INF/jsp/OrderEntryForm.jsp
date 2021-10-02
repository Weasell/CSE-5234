<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase</title>
<style><%@include file="/css/productPageStyle.css"%></style> 
</head>
<body>
<jsp:include page="header.jsp" />




 
 <div class="productList">

 <c:forEach items="${product.items}" var="item" varStatus="loop">
  
 <div class="gallery">
 	<form:form  modelAttribute="itemAttribute" method="post" action="purchase/addToCart">  
 		<form:hidden path="id" value="${item.id}"/>
		 <img   src="${ item.image}"> 
 		  <div class="descrip" >
 		  ${item.name}  <br>
 		  Unit Price: $${item.price} <br>
 		 
 		  <input type="submit" value="ADD TO CART">   
 		</div>
	</form:form> 
</div> 
 </c:forEach> 
 
  
 
 
</div>

 

<jsp:include page="footer.jsp" />

</body>
</html>