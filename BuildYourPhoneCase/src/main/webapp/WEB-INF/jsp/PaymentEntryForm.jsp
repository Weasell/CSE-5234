<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/WEB-INF/css/BasicStyle.css"%></style>
<title>Payment Info</title>
</head>
<body>
<div class="content"> 
<h2>Payment Info</h2>
<form:form  modelAttribute="paymentInfo" method="post" action="submitPayment">   
 <table>
 		<tr><td>Card Number: <form:input path="cardNum"/></td></tr> 
 		<tr><td>Expire Date: <form:input path="expireDate"/></td></tr>
 		<tr><td>CVV Code: <form:input path="cvvCode"/></td></tr>
 		<tr><td>Holder Name: <form:input path="holderName"/></td></tr>
 		 		
 	 
 </table>
  <input type="submit" value="Add Payment Info"> 
</form:form>
</div>
</body>
</html>
 