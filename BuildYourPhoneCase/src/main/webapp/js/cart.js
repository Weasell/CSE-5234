/**
 * 
 */
(function () {
  $("#cart").on("click", function () {
    $(".shopping-cart").fadeToggle("fast");
  });
})();


 

//reference: https://stackoverflow.com/questions/20245544/how-to-pass-json-object-from-ajax-to-spring-mvc-controller
/*
function testing(){
	var data = {}
	data["testingText"] = document.getElementById("testingText").innerHTML;// $("#testingText").val();
	$.ajax({
		url:"/BuildYourPhoneCase/purchase/testing",
		type:"POST",
		contentType : "application/json",
		data:  JSON.stringify(data),
		success:function(data){
		 $("#testingText").text(data);
		}
	});
	
}

 
var totalItems = 6; 
for (let i = 0; i <totalItems ; i++) {
	var id = i+1 ; 
	$("#addToCart"+id).on("click", function (){addToCart(this.id);} ) ;  
}  
  

function addToCart(id){
	var data = {}
	data["id"] = id; 
	$.ajax({
		url:"/BuildYourPhoneCase/purchase/addToCartAjax",
		type:"POST",
		contentType : "application/json",
		data:  JSON.stringify(data),
		success:function(data){
		  $("#testingText").text(data.duplicateItem );
		
		}
	});
	
<<<<<<< HEAD
}*/
 