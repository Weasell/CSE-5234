<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Build Your Phone Case</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body>
	<jsp:include page="header.jsp" />

	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-5">
			<div class="row gx-5 justify-content-center">
				<div class="col-lg-6">
					<div class="text-center my-5">
						<h1 class="display-5 fw-bolder text-white mb-2">Build your
							phone case in your own way</h1>
						<p class="display-5 text-white mb-4">Quickly design and
							customize your phone case!</p>
						<div>
							<img src="images/picture1.jpg" class="d-block w-100" alt="...">
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Features section-->
	<section class="py-5 border-bottom" id="features">
		<div class="container px-5 my-5">
			<div class="row gx-5">
				<div class="col-lg-4 mb-5 mb-lg-0">
					<div>
						<img src="images/Lightning_to_typec_cable.jpg"
							class="d-block w-100" alt="...">
					</div>
					<h2 class="h4 fw-bolder">Cable</h2>
					<p>Connect your iPhone, iPad, or iPod with Lightning connector
						to your USB–C or Thunderbolt 3 (USB–C) enabled Mac for syncing and
						charging. You can also use this cable with your Apple 29W, 61W, or
						87W USB–C Power Adapter to charge your iOS device, and even take
						advantage of the fast–charging feature on iPad Pro, iPhone 8,
						iPhone 8 Plus, and iPhone X.</p>
					<a class="text-decoration-none" href="#!"> Buy it now! </a>
				</div>
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h2 class="h4 fw-bolder">Featured title</h2>
					<p>Paragraph of text beneath the heading to explain the
						heading. We'll add onto it with another sentence and probably just
						keep going until we run out of words.</p>
					<a class="text-decoration-none" href="#!"> Call to action <i
						class="bi bi-arrow-right"></i>
					</a>
				</div>
				<div class="col-lg-4">
					<div>
						<img src="images/anonymous.png" class="d-block w-100" alt="...">
					</div>
					<h2 class="h4 fw-bolder">About us</h2>
					<p>Since our beginnings, our design concepts have always been
						based on creative ingenuity. We continue to develop innovative
						products, while maintaining sustainability as the basis of our
						mission. We've reached a level of aesthetic design that becomes an
						extension of the user through their own style of personal
						creativity - revolutionizing the mobile accessories industry.</p>
				</div>
			</div>
		</div>
	</section>
	
<jsp:include page="footer.jsp" />
</body>
</html>