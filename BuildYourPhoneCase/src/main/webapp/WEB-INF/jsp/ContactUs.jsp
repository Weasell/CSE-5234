<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact us</title>
<script src="//code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous" ></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
</head>
<body>
<jsp:include page="headerPartial.jsp" />
<!-- <br>
<br>
<br> -->
<section class="mb-4 mx-5" style = "padding-top: 80px">
    <h2 class="h1-responsive font-weight-bold text-center my-4">Contact us</h2>
    <p class="text-center w-responsive mx-auto mb-5">Do you have any questions? Please do not hesitate to contact us directly. Our team will come back to you within
        a matter of hours to help you.</p>
    <div class="row">
        <div class="col-md-9 mb-md-0 mb-5">
            <form id="contact-form" class = "mb-3" name="contact-form"  method="POST"><!-- action="mail.php" -->
                <div class="row">
                    <div class="col-md-6">
                        <div class="md-form mb-0">
                            <label for="message">Your name</label>
                            <input type="text" id="name" name="name" class="form-control" placeholder = "Enter your name">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="md-form mb-0">
                        	<label for="message">Your email</label>
                            <input type="text" id="email" name="email" class="form-control" placeholder = "Enter your email">
                        </div>
                    </div>
                </div>
                <div class="row ">
                    <div class="col-md-12">
                        <div class="md-form mb-0">
                            <label for="message">Subject</label>
                            <input type="text" id="subject" name="subject" class="form-control" placeholder = "Enter subject">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="md-form">
                            <label for="message">Your message:</label>
                            <textarea type="text" id="message" name="message" rows="2" class="form-control md-textarea"></textarea>
                        </div>
                    </div>
                </div>
            </form>
            <div class="text-center text-md-left">
               <button id = "send" class = "btn btn-primary" aria-pressed="true" onclick="BtnClicked()">Send</button>
                <div id="onSendBtnClicked"></div> 
            </div>
        </div>
        <div class="col-md-3 text-center">
            <ul class="list-unstyled mb-0">
                <li><i class="fas fa-map-marker-alt fa-2x"></i>
                    <p>Columbus, OH 43210, USA</p>
                </li>
                <li><i class="fas fa-phone mt-4 fa-2x"></i>
                    <p>(614)292-6446</p>
                </li>
                <li><i class="fas fa-envelope mt-4 fa-2x"></i>
                    <p>BuildYourPhoneCase@osu.edu</p>
                </li>
            </ul>
        </div>
    </div>
</section>
</body>
<script>
function BtnClicked() {
	var node = document.getElementById("onSendBtnClicked");
	node.innerHTML = "<h5>Thank you for your message, we will contact you shortly! </h5>";
}
</script>
</html>