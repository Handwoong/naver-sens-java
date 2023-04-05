package sens.response;

import java.util.List;

public class CheckSendKakaoResponse implements MessageResponse {

    private String requestId;

    private int statusCode;

    private String statusName;

    private List<KakaoResponseMessage> messages;

    public CheckSendKakaoResponse() {
    }

    public String getRequestId() {
        return requestId;
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

        private String requestTime;

        private String messageId;

        private String countryCode;

        private String to;

        private String content;

        private String plusFriendId;

        private String templateCode;

        private String completeTime;

        private String requestStatusCode;

        private String requestStatusName;

        private String requestStatusDesc;

        private String messageStatusCode;

        private String messageStatusName;

        private String messageStatusDesc;

        private boolean useSmsFailover;

        private FailOverResponse failover;

        public KakaoResponseMessage() {
        }

        public String getRequestTime() {
            return requestTime;
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

        public String getPlusFriendId() {
            return plusFriendId;
        }

        public String getTemplateCode() {
            return templateCode;
        }

        public String getCompleteTime() {
            return completeTime;
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

        public String getMessageStatusCode() {
            return messageStatusCode;
        }

        public String getMessageStatusName() {
            return messageStatusName;
        }

        public String getMessageStatusDesc() {
            return messageStatusDesc;
        }

        public boolean isUseSmsFailover() {
            return useSmsFailover;
        }

        public FailOverResponse getFailover() {
            return failover;
        }

        @Override
        public String toString() {
            return "KakaoResponseMessage{" +
                    "requestTime='" + requestTime + '\'' +
                    ", messageId='" + messageId + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    ", to='" + to + '\'' +
                    ", content='" + content + '\'' +
                    ", plusFriendId='" + plusFriendId + '\'' +
                    ", templateCode='" + templateCode + '\'' +
                    ", completeTime='" + completeTime + '\'' +
                    ", requestStatusCode='" + requestStatusCode + '\'' +
                    ", requestStatusName='" + requestStatusName + '\'' +
                    ", requestStatusDesc='" + requestStatusDesc + '\'' +
                    ", messageStatusCode='" + messageStatusCode + '\'' +
                    ", messageStatusName='" + messageStatusName + '\'' +
                    ", messageStatusDesc='" + messageStatusDesc + '\'' +
                    ", useSmsFailover=" + useSmsFailover +
                    ", failover=" + failover +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SendKakaoResponse{" +
                "requestId='" + requestId + '\'' +
                ", statusCode=" + statusCode +
                ", statusName='" + statusName + '\'' +
                ", messages=" + messages +
                '}';
    }
}
