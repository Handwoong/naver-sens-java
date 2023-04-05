package sens.response;

import java.util.List;

public class SendKakaoResponse {

    private String requestId;

    private String requestTime;

    private int statusCode;

    private String statusName;

    private List<KakaoResponseMessage> messages;

    public SendKakaoResponse() {
    }

    public String getRequestId() {
        return requestId;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public List<KakaoResponseMessage> getMessages() {
        return messages;
    }

    public static class KakaoResponseMessage {

        private String messageId;

        private String countryCode;

        private String to;

        private String content;

        private String requestStatusCode;

        private String requestStatusName;

        private String requestStatusDesc;

        private boolean useSmsFailover;

        public KakaoResponseMessage() {
        }

        public String getMessageId() {
            return messageId;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public String getTo() {
            return to;
        }

        public String getContent() {
            return content;
        }

        public String getRequestStatusCode() {
            return requestStatusCode;
        }

        public String getRequestStatusName() {
            return requestStatusName;
        }

        public String getRequestStatusDesc() {
            return requestStatusDesc;
        }

        public boolean isUseSmsFailover() {
            return useSmsFailover;
        }

        @Override
        public String toString() {
            return "KakaoResponseMessage{" +
                    "messageId='" + messageId + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    ", to='" + to + '\'' +
                    ", content='" + content + '\'' +
                    ", requestStatusCode='" + requestStatusCode + '\'' +
                    ", requestStatusName='" + requestStatusName + '\'' +
                    ", requestStatusDesc='" + requestStatusDesc + '\'' +
                    ", useSmsFailover=" + useSmsFailover +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SendKakaoResponse{" +
                "requestId='" + requestId + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", statusCode=" + statusCode +
                ", statusName='" + statusName + '\'' +
                ", messages=" + messages +
                '}';
    }
}
