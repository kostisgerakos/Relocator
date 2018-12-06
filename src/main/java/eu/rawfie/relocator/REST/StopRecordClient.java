package eu.rawfie.relocator.REST;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class StopRecordClient {

	private String url;
	private String message;

	public StopRecordClient(String url, String message) {
		this.url = url;
		this.message = message;
	}

	public void sendMessage() {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, message);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			client.destroy();
		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}