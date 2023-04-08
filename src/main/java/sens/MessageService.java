package sens;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import sens.request.MessageRequest;
import sens.sender.KakaoAlimTalkSender;

public class MessageService {

    private final KakaoAlimTalkSender kakaoAlimTalkSender;

    public MessageService(String accessKey, String secretKey, String serviceId) {
        ObjectMapper mapper = new ObjectMapper().configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MessageRequest messageRequest = new MessageRequest(accessKey, secretKey, mapper);
        this.kakaoAlimTalkSender = new KakaoAlimTalkSender(messageRequest, serviceId);
    }

    public KakaoAlimTalkSender getKakaoAlimTalkSender() {
        return kakaoAlimTalkSender;
    }
}
