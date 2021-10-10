package model;

import java.util.*;

import javax.json.*;
import javax.ws.rs.client.*;

public class ServiceFacade {
	public ServiceFacade() {}
	
	private static String INV_MGMT_SERVICE_URI = "http://localhost:9080/inventory-management/inventory";

	public List<Item> getAvailableItems() {

		List<Item> availableItems = new ArrayList<Item>();

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(INV_MGMT_SERVICE_URI);
		Invocation.Builder builder = webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON);
		JsonObject responseJsonObj = builder.get(JsonObject.class);


		Iterator<JsonValue> it = responseJsonObj.getJsonArray("items").iterator();
		while (it.hasNext()) {
			JsonValue value = it.next();
			Item newItem = new Item(value.asJsonObject().getInt("id"));
			newItem.setName(value.asJsonObject().getString("name"));
			newItem.setQuantity(value.asJsonObject().getInt("availableQuantity"));
			newItem.setPrice(value.asJsonObject().getJsonNumber("price").doubleValue());
			newItem.setImage(value.asJsonObject().getString("picURL"));
			availableItems.add(newItem);
		}

		client.close();
		return availableItems;
	}
}
