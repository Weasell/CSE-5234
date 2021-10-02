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
<style><%@include file="/css/home.css"%></style>
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
							<img src="images/homepage_pic.png" class="d-block w-100"
								alt="...">
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
					<a class="text-decoration-none" href="/BuildYourPhoneCase/purchase"> Buy it now! </a>
				</div>
				<div class="col-lg-4 mb-5 mb-lg-0">
					<div>
						<img src="images/iphone_our_case.png" class="d-block w-100"
							alt="...">
					</div>
					<h2 class="h4 fw-bolder">Our Case</h2>
					<p>Exceeds Military Standards</p>
					<p>Surpasses US military drop test standard (MIL-STD 810G),
						absorbs impact of over 11 feet</p>
					<p>Honeycomb Structure</p>
					<p>A hexagonal pattern lines the inner surfaces of our case,
						improving shock absorption by up to 10%</p>

					<a class="text-decoration-none" href="/BuildYourPhoneCase/purchase"> Buy it now! </a>

				</div>
				<div class="col-lg-4">
					<div>
						<img src="images/build_your_own_case.png" class="d-block w-100" alt="...">
					</div>
					<h2 class="h4 fw-bolder">Build Your Own Case</h2>
					<p>Our phones go with us everywhere and are often the first
						things we look at in the morning or before we go to sleep. Let
						your phone case bring a smile to your face every time you look at
						it! Design a custom iPhone case with your favorite photos.</p>
					<a class="text-decoration-none" href="/BuildYourPhoneCase/purchase"> Buy it now! </a>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="footer.jsp" />
</body>
</html>