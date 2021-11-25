<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase</title>
<style>
<%@include file ="/css/productPageStyle.css"%>
</style>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<body>
	<jsp:include page="header.jsp" />
	<div class="productList">
		<c:forEach items="${product.items}" var="item" varStatus="loop">
			<div class="gallery">
				<form:form modelAttribute="itemAttribute" method="post"
					action="purchase/addToCart">
					<form:hidden path="id" value="${item.id}" id='id' />
					<img src="${item.picURL}">
					<div class="descrip">
						<h5>${item.name}</h5>
						<h6>$${item.price}<h6>
						<input class="btn btn-outline-primary btn-sm" type="submit" value="ADD TO CART" id="addToCart">
					</div>
				</form:form>
			</div>
		</c:forEach>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>