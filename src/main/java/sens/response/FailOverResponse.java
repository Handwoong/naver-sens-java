package sens.response;

public class FailOverResponse {

    private String smsServiceId;

    private String requestId;

    private String requestStatusCode;

    private String requestStatusName;

    private String requestStatusDesc;

    public FailOverResponse() {
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

    @Override
    public String toString() {
        return "FailOverResponse{" +
                "smsServiceId='" + smsServiceId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", requestStatusCode='" + requestStatusCode + '\'' +
                ", requestStatusName='" + requestStatusName + '\'' +
                ", requestStatusDesc='" + requestStatusDesc + '\'' +
                '}';
    }
}
