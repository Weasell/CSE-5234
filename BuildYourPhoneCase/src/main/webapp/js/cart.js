/**
 * 
 */
var removeCartItemButtons = document.getElementsByClassName("remove")
var itemRowNum = 0 ;
var maxStorage = 100 ;
for (var i = 0; i < removeCartItemButtons.length; i++) {
     var button = removeCartItemButtons[i]
     button.addEventListener("click", removeCartItem )
	 
 }

var addToCartButtons = document.getElementsByClassName("cart")
    for (var i = 0; i < addToCartButtons.length; i++) {
        var button = addToCartButtons[i]
        button.addEventListener('click', addToCartClicked)
    }

 
 function removeCartItem(event) {
    var buttonClicked = event.target
    buttonClicked.parentElement.parentElement.remove()
     
}

function addToCartClicked(event) {
    var button = event.target
    var shopItem = button.parentElement.parentElement
    var name = shopItem.getElementsByClassName("name")[0].innerText
    var price = shopItem.getElementsByClassName('price')[0].innerText 
    var quantity =1 
    addItemToCart(name, price, quantity)
}


function addItemToCart(name, price, quantity) {
  /**
   var cartRow = document.createElement('tr')
	var cartRowContents = `
	<td><input id="items1.name" name="items[1].name" readonly="readonly" type="text" value="${name}"></td>
	<td><input id="items1.price" name="items[1].price" readonly="readonly" type="text" value="${price}"></td>
	<td><input id="items1.quantity" name="items[1].quantity" min="0" max="${maxStorage}" type="number" value=${quantity}></td>
	
	`
	cartRow.innerHTML =cartRowContents
    var cartItems = document.getElementsByClassName('cartItems')[0]
	cartItems.append(cartRow)
     * 
 */
     
}

