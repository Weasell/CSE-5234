<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/css/BasicStyle.css"%></style>
<title>Shipping Info</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<body>
	<jsp:include page="headerPartial.jsp" />
	<div style = "padding-top: 100px; padding-bottom:100px"> 
		<div class = "row">
			<div class = "col-3"></div>
			<div class = "col-6">
				<div style = "text-align: center">
					<h2>Shipping Info</h2>
				</div>
				<form:form  modelAttribute="shippingInfo" method="post" action="submitShipping">   
				 <%-- <table>
				 		<tr><td>Name: <form:input type="text" path="name" /></td></tr> 
				 		<tr><td>AddressLine1: <form:input path="addressLine1"/></td></tr>
				 		<tr><td>AddressLine2: <form:input path="addressLine2"/></td></tr>
				 		<tr><td>City: <form:input path="city"/></td></tr>
				 		<tr><td>State: <form:input path="state"/></td></tr>
				 		<tr><td>Zip: <form:input path="zip"/></td>	</tr> 	  
				 </table> --%>
					  <div class="form-group row">
					    <label class = "col-3" for="name">Name</label>
					    <form:input type="text" class="form-control col-9" id="Name" path = "Name"/>
				  	  </div>
					  <div class="form-group row">
					    <label class = "col-3" for="AddressLine1">AddressLine1</label>
					    <form:input type="text" class="form-control col-9 " id="AddressLine1" path = "AddressLine1"/>
				  	  </div>
					  <div class="form-group row">
					    <label class = "col-3" for="AddressLine2">AddressLine2</label>
					    <form:input type="text" class="form-control col-9" id="AddressLine2" path = "AddressLine2"/>
				  	  </div>
					  <div class="form-group row">
					    <label class = "col-3" for="City">City</label>
					    <form:input type="text" class="form-control col-9" id="City" path = "City"/>
				  	  </div>
					  <div class="form-group row">
					    <label class = "col-3" for="State">State</label>
					    <form:input type="text" class="form-control col-9" id="State" path = "State"/>
				  	  </div>
					  <div class="form-group row">
					    <label class = "col-3" for="Zip">Zip</label>
					    <form:input type="text" class="form-control col-9" id="Zip" path = "Zip"/>
				  	  </div>
				  	  <div style = "text-align: center">
				 	  	<button type="submit" class="btn btn-primary" value="Add Shipping Info"> Next</button>
				 	  </div>
				</form:form>
			</div>
			<div class = "col-3"></div>	
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
 