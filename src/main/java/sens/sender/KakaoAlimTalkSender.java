package sens.sender;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sens.exception.FailSendRequestException;
import sens.request.MessageRequest;
import sens.response.kakao.KakaoSend;
import sens.response.kakao.KakaoSendInfo;
import sens.response.kakao.KakaoSendResult;
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

    public KakaoSend send(KakaoTemplate messageTemplate) {
        Request request = messageRequest.createSendRequest(messageTemplate, url);
        return sendRequest(request, KakaoSend.class);
    }

    public KakaoSendInfo sendInfo(String requestId) {
        Request request = messageRequest.createSendInfoRequest(
                requestId, url);
        return sendRequest(request, KakaoSendInfo.class);
    }

    public KakaoSendResult sendResultInfo(String messageId) {
        Request request = messageRequest.createSendResultInfoRequest(
                messageId, url);
        return sendRequest(request, KakaoSendResult.class);
    }

    private <T> T sendRequest(Request request, Class<T> clazz) {
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return mapper.readValue(response.body().string(), clazz);
        } catch (IOException e) {
            throw new FailSendRequestException("HTTP 요청 또는 JSON 객체 매핑에 실패했습니다.");
        }
    }
}
