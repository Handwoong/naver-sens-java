package sens.sender;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sens.exception.FailSendRequestException;
import sens.request.MessageRequest;
import sens.response.CheckSendKakaoResponse;
import sens.response.CheckSendKakaoResultResponse;
import sens.response.SendKakaoResponse;
import sens.template.kakao.KakaoTemplate;

public class KakaoAlimTalkSender {

    private final String url;

    private final ObjectMapper mapper = new ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final OkHttpClient client = new OkHttpClient();

    private final MessageRequest messageRequest;

    public KakaoAlimTalkSender(String accessKey, String secretKey, String serviceId) {
        this.url = "/alimtalk/v2/services/" + serviceId + "/messages";
        this.messageRequest = new MessageRequest(accessKey, secretKey, mapper);
    }

    public SendKakaoResponse send(KakaoTemplate messageTemplate) {
        Request request = messageRequest.createSendMessageRequest(messageTemplate, url);
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return mapper.readValue(response.body().string(), SendKakaoResponse.class);
        } catch (Exception e) {
            throw new FailSendRequestException("메시지 전송 요청에 실패했습니다.");
        }
    }

    public CheckSendKakaoResponse checkMessageSend(String requestId) {
        Request request = messageRequest.createCheckMessageSendRequest(
                requestId, url);
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return mapper.readValue(response.body().string(),
                    CheckSendKakaoResponse.class);
        } catch (Exception e) {
            throw new FailSendRequestException("메시지 전송 요청에 실패했습니다.");
        }
    }

    public CheckSendKakaoResultResponse checkMessageSendResult(String messageId) {
        Request request = messageRequest.createCheckMessageSendResultRequest(
                messageId, url);
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return mapper.readValue(response.body().string(),
                    CheckSendKakaoResultResponse.class);
        } catch (Exception e) {
            throw new FailSendRequestException("메시지 전송 요청에 실패했습니다.");
        }
    }
}
