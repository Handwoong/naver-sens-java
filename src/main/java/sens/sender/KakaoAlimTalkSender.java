package sens.sender;

import okhttp3.Request;
import sens.request.MessageRequest;
import sens.response.kakao.KakaoSend;
import sens.response.kakao.KakaoSendInfo;
import sens.response.kakao.KakaoSendResult;
import sens.template.MessageTemplate;

public class KakaoAlimTalkSender {

    private final String url;

    private final MessageRequest messageRequest;

    public KakaoAlimTalkSender(MessageRequest messageRequest, String serviceId) {
        this.messageRequest = messageRequest;
        this.url = "/alimtalk/v2/services/" + serviceId + "/messages";
    }

    public KakaoSend send(MessageTemplate messageTemplate) {
        Request request = messageRequest.createSendRequest(messageTemplate, url);
        return messageRequest.sendRequest(request, KakaoSend.class);
    }

    public KakaoSendInfo sendInfo(String requestId) {
        Request request = messageRequest.createSendInfoRequest(requestId, url);
        return messageRequest.sendRequest(request, KakaoSendInfo.class);
    }

    public KakaoSendResult sendResultInfo(String messageId) {
        Request request = messageRequest.createSendResultInfoRequest(messageId, url);
        return messageRequest.sendRequest(request, KakaoSendResult.class);
    }
}
