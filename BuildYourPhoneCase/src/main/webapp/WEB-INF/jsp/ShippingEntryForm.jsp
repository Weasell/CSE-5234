<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/WEB-INF/css/BasicStyle.css"%></style>
<title>Shipping Info</title>
</head>
<body>
<div class="content"> 
<h2>Shipping Info</h2>
<form:form  modelAttribute="shippingInfo" method="post" action="submitShipping">   
 <table>
 		<tr><td>Name: <form:input type="text" path="name" /></td></tr> 
 		<tr><td>AddressLine1: <form:input path="addressLine1"/></td></tr>
 		<tr><td>AddressLine2: <form:input path="addressLine2"/></td></tr>
 		<tr><td>City: <form:input path="city"/></td></tr>
 		<tr><td>State: <form:input path="state"/></td></tr>
 		<tr><td>Zip: <form:input path="zip"/></td>	</tr>
 			 
 		
 
 	  
 </table>
 <input type="submit" value="Add Shipping Info"> 
</form:form>
</div>
</body>
</html>
 