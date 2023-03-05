package sens;

import org.jetbrains.annotations.NotNull;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sens.request.MessageBody;
import sens.response.MessageResponse;

public class MessageService {
	private final String accessKey;
	private final String secretKey;
	private final String serviceId;

	public MessageService(String accessKey, String secretKey, String serviceId) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.serviceId = serviceId;
	}

	public MessageResponse send(MessageType messageType, MessageBody messageBody) {
		String sendType = messageType.name().toLowerCase();
		String url = "/" + sendType + "/v2/services/" + serviceId + "/messages";

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		OkHttpClient client = new OkHttpClient();

		try {
			MessageHeader header = new MessageHeader(accessKey, secretKey);
			Request request = createRequest(messageBody, url, mapper, header);
			Response response = client.newCall(request).execute();
			assert response.body() != null;
			return mapper.readValue(response.body().string(), MessageResponse.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	@NotNull
	private Request createRequest(MessageBody messageBody, String url, ObjectMapper mapper, MessageHeader header) throws Exception {
		return header.createHeader(url)
					 .url("https://sens.apigw.ntruss.com" + url)
					 .post(RequestBody.create(mapper.writeValueAsString(messageBody), MediaType.parse("application/json")))
					 .build();
	}
}
