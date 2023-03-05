package sens.response;

import java.util.List;

public class MessageResponse {
	private int statusCode;
	private String statusName;
	private List<KakaoResponseMessage> messages;

	public MessageResponse() {
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
		private String requestStatusCode;
		private String requestStatusName;
		private String requestStatusDesc;

		public KakaoResponseMessage() {
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
	}
}
