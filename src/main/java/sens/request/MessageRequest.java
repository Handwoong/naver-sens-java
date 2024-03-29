package sens.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sens.exception.FailCreateRequestException;
import sens.exception.FailSendRequestException;
import sens.sender.MessageHeader;
import sens.template.MessageTemplate;

public class MessageRequest {

    private final MessageHeader header;

    private final ObjectMapper mapper;

    private final OkHttpClient client = new OkHttpClient();

    public MessageRequest(String accessKey, String secretKey, ObjectMapper mapper) {
        this.header = new MessageHeader(accessKey, secretKey);
        this.mapper = mapper;
    }

    public Request createSendRequest(MessageTemplate messageTemplate,
            String url) {
        try {
            return header.createHeader("POST", url)
                    .url("https://sens.apigw.ntruss.com" + url)
                    .post(RequestBody.create(mapper.writeValueAsString(messageTemplate),
                            MediaType.parse("application/json")))
                    .build();
        } catch (Exception e) {
            throw new FailCreateRequestException("템플릿을 JSON 객체로 변환하는데 실패했습니다.");
        }
    }

    public Request createSendInfoRequest(String requestId, String url) {
        String newUrl = url + "?requestId=" + requestId;
        return header.createHeader("GET", newUrl)
                .url("https://sens.apigw.ntruss.com" + newUrl)
                .build();
    }

    public Request createSendResultInfoRequest(String messageId, String url) {
        String newUrl = url + "/" + messageId;
        return header.createHeader("GET", newUrl)
                .url("https://sens.apigw.ntruss.com" + newUrl)
                .build();
    }

    public <T> T sendRequest(Request request, Class<T> clazz) {
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return mapper.readValue(response.body().string(), clazz);
        } catch (IOException e) {
            throw new FailSendRequestException("HTTP 요청 또는 JSON 객체 매핑에 실패했습니다.");
        }
    }
}
