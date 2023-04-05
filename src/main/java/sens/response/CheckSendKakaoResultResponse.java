package sens.response;

public class CheckSendKakaoResultResponse {

    private String messageId;

    private String requestId;

    private String requestTime;

    private String completeTime;

    private String plusFriendId;

    private String templateCode;

    private String countryCode;

    private String to;

    private String content;

    private String requestStatusCode;

    private String requestStatusName;

    private String requestStatusDesc;

    private String messageStatusCode;

    private String messageStatusName;

    private String messageStatusDesc;

    private boolean useSmsFailover;

    private KakaoResponseFailOver failOver;

    public CheckSendKakaoResultResponse() {
    }

    public String getMessageId() {
        return messageId;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public String getPlusFriendId() {
        return plusFriendId;
    }

    public String getTemplateCode() {
        return templateCode;
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

    public KakaoResponseFailOver getFailOver() {
        return failOver;
    }

    public static class KakaoResponseFailOver {

        private String smsServiceId;

        private String requestId;

        private String requestStatusCode;

        private String requestStatusName;

        private String requestStatusDesc;

        private String messageId;

        private String messageStatus;

        private String messageStatusCode;

        private String messageStatusName;

        private String messageStatusDesc;

        public KakaoResponseFailOver() {
        }

        public String getSmsServiceId() {
            return smsServiceId;
        }

        public String getRequestId() {
            return requestId;
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

        public String getMessageId() {
            return messageId;
        }

        public String getMessageStatus() {
            return messageStatus;
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

        @Override
        public String toString() {
            return "KakaoResponseFailOver{" +
                    "smsServiceId='" + smsServiceId + '\'' +
                    ", requestId='" + requestId + '\'' +
                    ", requestStatusCode='" + requestStatusCode + '\'' +
                    ", requestStatusName='" + requestStatusName + '\'' +
                    ", requestStatusDesc='" + requestStatusDesc + '\'' +
                    ", messageId='" + messageId + '\'' +
                    ", messageStatus='" + messageStatus + '\'' +
                    ", messageStatusCode='" + messageStatusCode + '\'' +
                    ", messageStatusName='" + messageStatusName + '\'' +
                    ", messageStatusDesc='" + messageStatusDesc + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CheckSendKakaoResultResponse{" +
                "messageId='" + messageId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", completeTime='" + completeTime + '\'' +
                ", plusFriendId='" + plusFriendId + '\'' +
                ", templateCode='" + templateCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                ", requestStatusCode='" + requestStatusCode + '\'' +
                ", requestStatusName='" + requestStatusName + '\'' +
                ", requestStatusDesc='" + requestStatusDesc + '\'' +
                ", messageStatusCode='" + messageStatusCode + '\'' +
                ", messageStatusName='" + messageStatusName + '\'' +
                ", messageStatusDesc='" + messageStatusDesc + '\'' +
                ", useSmsFailover=" + useSmsFailover +
                ", failOver=" + failOver +
                '}';
    }
}
