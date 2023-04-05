package sens.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import sens.exception.FailCreateRequestException;
import sens.sender.MessageHeader;
import sens.template.kakao.KakaoTemplate;

public class MessageRequest {

    private final MessageHeader header;

    private final ObjectMapper mapper;

    public MessageRequest(String accessKey, String secretKey, ObjectMapper mapper) {
        this.header = new MessageHeader(accessKey, secretKey);
        this.mapper = mapper;
    }

    public Request createSendMessageRequest(KakaoTemplate messageTemplate,
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

    public Request createCheckMessageSendRequest(String requestId, String url) {
        String newUrl = url + "?requestId=" + requestId;
        return header.createHeader("GET", newUrl)
                .url("https://sens.apigw.ntruss.com" + newUrl)
                .build();
    }

    public Request createCheckMessageSendResultRequest(String messageId, String url) {
        String newUrl = url + "/" + messageId;
        return header.createHeader("GET", newUrl)
                .url("https://sens.apigw.ntruss.com" + newUrl)
                .build();
    }
}
