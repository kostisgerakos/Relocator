package eu.rawfie.relocator.REST;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class StartRecordClient {

	private String url;
	private String message;

	

	public StartRecordClient(String url, String message)
	{
		this.url = url;
		this.message = message;
	}

	public String sendMessage()
	{
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, message);
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			String answer = response.getEntity(String.class);
			client.destroy();

			return answer;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}