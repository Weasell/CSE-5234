package utils;

import java.util.*;
import javax.ws.rs.core.MediaType ; 

import javax.json.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;

import model.Item;
import model.Order;

public class ServiceFacade {
	public ServiceFacade() {}
	
	private static String INV_MGMT_GET_INVENTORY_URI = "http://localhost:9080/inventory-management/inventory";
	private static String INV_MGMT_GET_ITEM_BY_ID_URI = "http://localhost:9080/inventory-management/inventory/itembyid";
	private static String INV_MGMT_GET_ITEM_BY_NAME_URI = "http://localhost:9080/inventory-management/inventory/itembyname";
	private static String ORD_PROC_URI = "http://localhost:9080/order-processing/order";


	public List<Item> getAvailableItems(int pageNum) {

		List<Item> availableItems = new ArrayList<Item>();

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(INV_MGMT_GET_INVENTORY_URI).queryParam("pageNum", pageNum ) ;
		Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		JsonObject responseJsonObj = builder.get(JsonObject.class);
		 

		Iterator<JsonValue> it = responseJsonObj.getJsonArray("items").iterator();
		while (it.hasNext()) {
			JsonValue value = it.next();
			int id=value.asJsonObject().getInt("id") ;
			String name = value.asJsonObject().getString("name") ; 
			int availableQuantity = value.asJsonObject().getInt("availableQuantity") ; 
			double price =value.asJsonObject().getJsonNumber("price").doubleValue() ; 
			String picURL = value.asJsonObject().getString("picURL");
			Item newItem = new Item(id, name, availableQuantity,price, picURL, pageNum);
			 
			availableItems.add(newItem);
		}

		client.close();
		return availableItems;
	}
	
	
	
	public Item getItemById(int id ) {
		 
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(INV_MGMT_GET_ITEM_BY_ID_URI).queryParam("id", id );
		Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		JsonObject responseJsonObj = builder.get(JsonObject.class);
		
		String name =responseJsonObj.getString("name") ; 
		int availableQuantity = responseJsonObj.getInt("availableQuantity") ; 
		double price =responseJsonObj.getJsonNumber("price").doubleValue() ; 
		String picURL = responseJsonObj.getString("picURL");
		int pageNum = responseJsonObj.getInt("pageNum") ; 
		Item item = new Item(id, name, availableQuantity,price, picURL, pageNum);
		client.close();
		return item;
	}
	
	
	
	public Item getItemByName(String name ) {
		 

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(INV_MGMT_GET_ITEM_BY_NAME_URI).queryParam("name", name );
		Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		JsonObject responseJsonObj = builder.get(JsonObject.class);

		int id =responseJsonObj.getInt("id") ; 
		int availableQuantity = responseJsonObj.getInt("availableQuantity") ; 
		double price =responseJsonObj.getJsonNumber("price").doubleValue() ; 
		String picURL = responseJsonObj.getString("picURL");
		int pageNum = responseJsonObj.getInt("pageNum") ; 
		Item item = new Item(id, name, availableQuantity,price, picURL, pageNum);
		 

		client.close();
		return item;
	}
	
	
	
	public String orderProcess(Order order) {

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(ORD_PROC_URI) ;
		Response postResponse = webTarget.request().post(Entity.json(order));
		String confirmationNum = postResponse.readEntity(String.class) ;
		client.close();
		return confirmationNum ;
		 
	}
}
