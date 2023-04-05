package sens.template.kakao;

import java.util.List;
import sens.template.kakao.messages.KaKaoMessage;

public class KakaoTemplate {

    private final String plusFriendId;

    private final String templateCode;

    private final List<KaKaoMessage> messages;

    private final String reserveTime;

    private final String reserveTimeZone;

    private final String scheduleCode;

    public static class Builder {

        private final String plusFriendId;

        private final List<KaKaoMessage> messages;

        private final String templateCode;

        private String reserveTime;

        private String reserveTimeZone;

        private String scheduleCode;

        public Builder(String plusFriendId, String templateCode,
                List<KaKaoMessage> messages) {
            this.plusFriendId = plusFriendId;
            this.templateCode = templateCode;
            this.messages = messages;
        }

        public Builder reserveTime(String reserveTime) {
            this.reserveTime = reserveTime;
            return this;
        }

        public Builder reserveTimeZone(String reserveTimeZone) {
            this.reserveTimeZone = reserveTimeZone;
            return this;
        }

        public Builder scheduleCode(String scheduleCode) {
            this.scheduleCode = scheduleCode;
            return this;
        }

        public KakaoTemplate build() {
            return new KakaoTemplate(this);
        }
    }

    private KakaoTemplate(Builder builder) {
        this.plusFriendId = builder.plusFriendId;
        this.messages = builder.messages;
        this.templateCode = builder.templateCode;
        this.reserveTime = builder.reserveTime;
        this.reserveTimeZone = builder.reserveTimeZone;
        this.scheduleCode = builder.scheduleCode;
    }

    public String getPlusFriendId() {
        return plusFriendId;
    }

    public List<KaKaoMessage> getMessages() {
        return messages;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public String getReserveTimeZone() {
        return reserveTimeZone;
    }

    public String getScheduleCode() {
        return scheduleCode;
    }
}
