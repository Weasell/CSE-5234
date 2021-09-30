<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored = "false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order</title>
<style><%@include file="/WEB-INF/css/BasicStyle.css"%></style>
</head>
<body>
<div class="content"> 
<h2>Here is your order summary</h2> <br>
<h4>Your total cost is $${sum} </h4><br>

Order Info: 
<hr>
<table>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><img class="responsive" src="${item.image}"></td>
			<td>Item Name: <c:out value="${item.name}"/></td>
			<td>Item Price: <c:out value="$${item.price}"/></td>
			<td>Quantity: <c:out value="${item.quantity}" /></td>
		</tr>
	</c:forEach>
</table>

Shipping Info:
<hr>

<table>
	
	<tr><td>Name: <c:out value="${shippingInfo.name}"/> </td></tr> 
 	<tr><td>AddressLine1: <c:out value="${shippingInfo.addressLine1}"/> </td></tr>
 	<tr><td>AddressLine2: <c:out value="${shippingInfo.addressLine2}"/> </td></tr>
 	<tr><td>City:  <c:out value="${shippingInfo.city}"/></td></tr>
 	<tr><td>State: <c:out value="${shippingInfo.state}"/> </td></tr>
 	<tr><td>Zip: <c:out value="${shippingInfo.zip}"/> </td>	</tr>
	 
</table>

Payment Info: 
<hr>

<table>
	<tr><td>Card Number: <c:out value="${paymentInfo.cardNum}"/> </td></tr> 
 	<tr><td>Expire Date: <c:out value="${paymentInfo.expireDate}"/> </td></tr>
 	<tr><td>CVV Code: <c:out value="${paymentInfo.cvvCode}"/> </td></tr>
 	<tr><td>Holder Name:  <c:out value="${paymentInfo.holderName}"/></td></tr>
</table>

<form:form  method="post" action="confirmOrder">  
	<input type="submit" value="Confirm Your Order">
</form:form>
</div>
</body>
</html>