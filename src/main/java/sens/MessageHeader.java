package sens;

import java.nio.charset.StandardCharsets;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import okhttp3.Request;

public class MessageHeader {
	private final String accessKey;
	private final String secretKey;

	public MessageHeader(String accessKey, String secretKey) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
	}

	public Request.Builder createHeader(String url) throws Exception {
		String timestamp = Long.toString(System.currentTimeMillis());
		Request.Builder request = new Request.Builder();
		request.addHeader("Content-type", "application/json");
		request.addHeader("x-ncp-apigw-timestamp", timestamp);
		request.addHeader("x-ncp-iam-access-key", accessKey);
		request.addHeader("x-ncp-apigw-signature-v2", makeSignature(timestamp, url));
		return request;
	}

	public String makeSignature(String timestamp, String url) throws Exception {
		String space = " ";
		String newLine = "\n";
		String method = "POST";
		String message = method
			+ space
			+ url
			+ newLine
			+ timestamp
			+ newLine
			+ accessKey;

		SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(signingKey);

		byte[] rawHmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
		return Base64.encodeBase64String(rawHmac);
	}
}
