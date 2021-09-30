/**
 * 
 */
 (function () {
  $("#cart").on("click", function () {
    $(".shopping-cart").fadeToggle("fast");
  });
})();

/**
 * 
function addToCartClicked(event) {
    var button = event.target
    var shopItem = button.parentElement.parentElement
    var name = shopItem.getElementsByClassName("name")[0].innerText
    var price = shopItem.getElementsByClassName('price')[0].innerText 
    var quantity =1 
    addItemToCart(name, price, quantity)
}


function addItemToCart(name, price, quantity) {
  
   var cartRow = document.createElement('tr')
	var cartRowContents = `
	<td><input id="items1.name" name="items[1].name" readonly="readonly" type="text" value="${name}"></td>
	<td><input id="items1.price" name="items[1].price" readonly="readonly" type="text" value="${price}"></td>
	<td><input id="items1.quantity" name="items[1].quantity" min="0" max="${maxStorage}" type="number" value=${quantity}></td>
	
	`
	cartRow.innerHTML =cartRowContents
    var cartItems = document.getElementsByClassName('cartItems')[0]
	cartItems.append(cartRow)
      
  
     
}

 */
