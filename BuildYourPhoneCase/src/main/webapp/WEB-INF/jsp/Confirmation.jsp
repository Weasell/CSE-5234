<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
<style><%@include file="/css/BasicStyle.css"%></style>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<body>
<jsp:include page="headerPartial.jsp" />
<div style = "padding-top: 100px; padding-bottom:100px"> 
	<div class = "row">
		<div class = "col-3"></div>
		<div class = "col-6">
			<div style = "text-align: center">
				<h2>${greeting}</h2>
			
				<h5>Your Order ID is : ${orderId}</h5>
			
			
				<form:form  method="post" action="keepShopping">  
					<input class = "btn btn-primary" type="submit" value="Keep Shopping">
				</form:form>
			</div>
		</div>
		<div class = "col-3"></div>
	</div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>