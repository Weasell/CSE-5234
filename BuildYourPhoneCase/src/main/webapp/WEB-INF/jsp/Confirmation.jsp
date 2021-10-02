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
<body>
<jsp:include page="headerPartial.jsp" />
<div class="content">
<h2>${greeting} <br></h2>
Your Order ID is : ${orderId}


<form:form  method="post" action="keepShopping">  
	<input type="submit" value="Keep Shopping">
</form:form>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>