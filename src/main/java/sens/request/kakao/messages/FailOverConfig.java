package sens.request.kakao.messages;

public class FailOverConfig {
	private final String type;
	private final String from;
	private final String subject;
	private final String content;

	public static class Builder {
		private String type;
		private String from;
		private String subject;
		private String content;

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder from(String from) {
			this.from = from;
			return this;
		}

		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}

		public Builder content(String content) {
			this.content = content;
			return this;
		}

		public FailOverConfig build() {
			return new FailOverConfig(this);
		}
	}

	private FailOverConfig(Builder builder) {
		this.type = builder.type;
		this.from = builder.from;
		this.subject = builder.subject;
		this.content = builder.content;
	}

	public String getType() {
		return type;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}
}
