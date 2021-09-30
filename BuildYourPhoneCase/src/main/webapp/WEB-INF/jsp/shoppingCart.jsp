<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<style><%@include file="/WEB-INF/css/BasicStyle.css"%></style>
</head>
<body>
<div class="content"> 
<h2>Shopping Cart</h2>
<c:if test="${ itemNum == 0}">
	<h2>Your Cart is Empty</h2>
</c:if>
<form:form  modelAttribute="order" method="post" action="submitItems">   
 <table>
 	<c:forEach items="${order.items}" var="item" varStatus="loop">
 		<tr>
 			<td><img class="responsive" src="${item.image}"></td>
 			<td><form:input path="items[${loop.index}].name" readonly="true" /></td>
 			<td><form:input path="items[${loop.index}].price" readonly="true" /></td>
 			<td><form:input  path="items[${loop.index}].quantity"  type="number" value="${item.quantity }" min="1" max="${storage}" /></td>
 			<td><input type="submit" name="${loop.index}" value="Delete" id="${loop.index}"> </td>
 		</tr>
 	</c:forEach> 
 </table>
 <input type="submit" name="button" value="Continue Shopping"><br>
 <input type="submit" name="button" id="purchase" value="Purchase"> 

 
</form:form>

<c:if test="${ itemNum == 0}">
<script>document.getElementById("purchase").disabled = true;</script>
</c:if>
 </div>
</body>
</html>