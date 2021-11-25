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
<%-- <style><%@include file="/css/BasicStyle.css"%></style>
 --%></head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<body>
<jsp:include page="headerPartial.jsp" />
<div style = "padding-top: 100px; padding-bottom:100px"> 
	<div class = "row">
		<div class = "col-2"></div>
		<div class = "col-8">
			<div style = "text-align: center">
				<h2>Order Summary</h2>
			</div>
			<h5 style = "text-align:right">Your total cost is <span class="text-primary" >$${sum}</span></h5>
			<h3>Order Info </h3>
			<table class="table table-sm">
				<thead class = "thead-light"> 
				<tr>
			      <th scope="col">product image</th>
			      <th scope="col">Item</th>
			      <th scope="col">Price</th>
			      <th scope="col">Quantity</th>
			    </tr>
				</thead>
				<tbody>
					<c:forEach items="${order.items}" var="item" varStatus="loop">
						<tr>
							<th style="width:30%"><img class="responsive" style = "max-width:50%; max-height:50%"src="${pageContext.request.contextPath}/${item.picURL}"></th>
							<th style="width:20%"><c:out value="${item.name}"/></th>
							<th style="width:20%"><c:out value="$${item.price}"/></th>
							<th style="width:20%"><c:out value="${item.availableQuantity}"/></th>
						</tr>
					</c:forEach>
				</tbody>	
			</table>
			<div class = "row">
				<div class = "col-6">
					<h3>Shipping Info</h3>	
					<div class = "row">
						<div class="col-4"><p>Name</p></div>
						<div class="col-8"><c:out value="${shippingInfo.name}"/></div>
					</div>
					<div class = "row">
						<div class="col-4"><p>AddressLine1</p></div>
						<div class="col-8"><c:out value="${shippingInfo.addressLine1}"/></div>
					</div>
					<div class = "row">
						<div class="col-4"><p>AddressLine2</p></div>
						<div class="col-8"><c:out value="${shippingInfo.addressLine2}"/></div>
					</div>
					<div class = "row">
						<div class="col-4"><p>City</p></div>
						<div class="col-8"><c:out value="${shippingInfo.city}"/></div>
					</div>
					<div class = "row">
						<div class="col-4"><p>State</p></div>
						<div class="col-8"><c:out value="${shippingInfo.state}"/></div>
					</div>
					<div class = "row">
						<div class="col-4"><p>Zip</p></div>
						<div class="col-8"><c:out value="${shippingInfo.zip}"/></div>
					</div>
				</div>
				<div class = "col-6">
					<h3>Payment Info</h3>
					<div class = "row">
						<div class="col-4"><p>Card Number</p></div>
						<div class="col-8"><c:out value="${paymentInfo.cardNum}"/></div>
					</div>
					<div class = "row">
						<div class="col-4"><p>Expire Date</p></div>
						<div class="col-8"><c:out value="${paymentInfo.expireDate}"/> </div>
					</div>
					<div class = "row">
						<div class="col-4"><p>CVV Code</p></div>
						<div class="col-8"><c:out value="${paymentInfo.cvvCode}"/></div>
					</div>
					<div class = "row">
						<div class="col-4"><p>Holder Name</p></div>
						<div class="col-8"><c:out value="${paymentInfo.holderName}"/></div>
					</div>	
				</div>
			</div>
			<%-- <h3>Shipping Info:</h3>			
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
			</table> --%>
			
			<form:form  style = "text-align: center" method="post" action="confirmOrder">  
				<button type="submit" class="btn btn-primary" value="Confirm Your Order">Confirm</button>
			</form:form>
		</div>
		<div class = "col-2"></div>
	</div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>