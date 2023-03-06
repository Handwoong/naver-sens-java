package sens.request.kakao;

import java.util.List;

import sens.request.MessageBody;
import sens.request.kakao.messages.KaKaoMessage;

public class KakaoRequestBody implements MessageBody {
	private final String plusFriendId;
	private final List<KaKaoMessage> messages;
	private final String templateCode;
	private final FailOverConfig failoverConfig;
	private final String reserveTime;
	private final String reserveTimeZone;
	private final String scheduleCode;

	public static class Builder {
		private final String plusFriendId;
		private final List<KaKaoMessage> messages;
		private String templateCode;
		private FailOverConfig failoverConfig;
		private String reserveTime;
		private String reserveTimeZone;
		private String scheduleCode;

		public Builder(String plusFriendId, List<KaKaoMessage> messages) {
			this.plusFriendId = plusFriendId;
			this.messages = messages;
		}

		public Builder templateCode(String templateCode) {
			this.templateCode = templateCode;
			return this;
		}

		public Builder failoverConfig(FailOverConfig failoverConfig) {
			this.failoverConfig = failoverConfig;
			return this;
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

		public KakaoRequestBody build() {
			return new KakaoRequestBody(this);
		}
	}

	private KakaoRequestBody(Builder builder) {
		this.plusFriendId = builder.plusFriendId;
		this.messages = builder.messages;
		this.templateCode = builder.templateCode;
		this.failoverConfig = builder.failoverConfig;
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

	public FailOverConfig getFailoverConfig() {
		return failoverConfig;
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
