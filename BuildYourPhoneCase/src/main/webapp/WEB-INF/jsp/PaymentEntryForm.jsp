<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/css/BasicStyle.css"%></style>
<title>Payment Info</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<body>
<jsp:include page="headerPartial.jsp" />
	<div style = "padding-top: 100px; padding-bottom:100px"> 
	<div class = "row">
		<div class = "col-3"></div>
		<div class = "col-6">
			<div style = "text-align: center">
				<h2>Payment Info</h2>
			</div>
			<form:form  modelAttribute="paymentInfo" method="post" action="submitPayment">   
			 <%-- <table>
			 		<tr><td>Card Number: <form:input path="cardNum"/></td></tr> 
			 		<tr><td>Expire Date: <form:input path="expireDate"/></td></tr>
			 		<tr><td>CVV Code: <form:input path="cvvCode"/></td></tr>
			 		<tr><td>Holder Name: <form:input path="holderName"/></td></tr>
			 		 		
			 	 
			 </table> --%>
			 <div class="form-group row">
			    <label class = "col-3" for="Card Number">Card Number</label>
			    <form:input type="text" class="form-control col-9" id="Card Number" path = "cardNum"/>
		  	  </div>
			  <div class="form-group row">
			    <label class = "col-3" for="Expire Date">Expire Date</label>
			    <form:input type="text" class="form-control col-9 " id="Expire Date" path = "expireDate"/>
		  	  </div>
			  <div class="form-group row">
			    <label class = "col-3" for="CVV Code">CVV Code</label>
			    <form:input type="text" class="form-control col-9" id="CVV Code" path = "cvvCode"/>
		  	  </div>
			  <div class="form-group row">
			    <label class = "col-3" for="Holder Name">Holder Name</label>
			    <form:input type="text" class="form-control col-9" id="Holder Name" path = "holderName"/>
		  	  </div>
		  	  <div style = "text-align: center">
			  	<button class = "btn btn-primary"type="submit" value="Add Payment Info">Next</button>
			  </div>
			</form:form>
		</div>
		<div class = "col-3"></div>
		
	</div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>
 