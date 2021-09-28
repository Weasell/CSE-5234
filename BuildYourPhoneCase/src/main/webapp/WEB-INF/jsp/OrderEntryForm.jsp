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
<%-- 

<h2>Product List</h2>
<table>
	<tr>
   		 <th>Name</th>
   		 <th>Price $</th>
   		 <th>Maximum Purchase</th>
  	</tr>
 	
 	<c:forEach items="${product.items}" var="item" varStatus="loop">
 	 
		<tr>
 			<td class="name"><c:out value="${item.name}"/> </td>
 			<td class="price"><c:out value="${item.price}"/> </td>
 			<td ><c:out value="${item.quantity}"/></td>
 			<td><button class="cart">ADD TO CART</button></td>
 			
 		</tr>
 	
 	</c:forEach> 
 </table>


<h2>CART</h2>

<form:form  modelAttribute="order" method="post" action="purchase/submitItems">   
	<table >
	
		<tr>
   		 <th>Name</th>
   		 <th>Price $</th>
   		 <th>Quantity</th>
		</tr> 
		<tbody class="cartItems">
	 
 		</tbody>
 		 
  	</table>
   	<input type="submit" value="Purchase"> 
	</form:form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/cart.js"></script>
	
--%> 


  
<form:form  modelAttribute="product" method="post" action="purchase/submitItems">   
 <table>
 	<c:forEach items="${product.items}" var="item" varStatus="loop">
 		<tr>
 			<td><form:input path="items[${loop.index}].name" readonly="true" /></td>
 			<td>$<form:input path="items[${loop.index}].price" readonly="true" /></td>
 			<td><form:input  path="items[${loop.index}].quantity" value="0" type="number" min="0" max="${storage}" /></td>
 		</tr>
 	</c:forEach> 
 </table>
 <input type="submit" value="Purchase"> 
</form:form>
 

</div>


</body>
</html>