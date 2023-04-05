package sens.sender;

import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Request;
import org.apache.commons.codec.binary.Base64;
import sens.exception.FailCreateRequestException;

public class MessageHeader {

    private final String accessKey;

    private final String secretKey;

    public MessageHeader(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public Request.Builder createHeader(String method, String url) {
        String timestamp = Long.toString(System.currentTimeMillis());
        Request.Builder request = new Request.Builder();
        request.addHeader("Content-type", "application/json");
        request.addHeader("x-ncp-apigw-timestamp", timestamp);
        request.addHeader("x-ncp-iam-access-key", accessKey);
        request.addHeader("x-ncp-apigw-signature-v2",
                makeSignature(timestamp, method, url));
        return request;
    }

    public String makeSignature(String timestamp, String method, String url) {
        String space = " ";
        String newLine = "\n";
        String message = method
                + space
                + url
                + newLine
                + timestamp
                + newLine
                + accessKey;

        try {
            SecretKeySpec signingKey = new SecretKeySpec(
                    secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return Base64.encodeBase64String(rawHmac);
        } catch (Exception e) {
            throw new FailCreateRequestException("Header 시그니처 생성에 실패했습니다.");
        }
    }
}
