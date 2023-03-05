package sens.request.kakao.messages;

public class KakaoButton {
	private final ButtonType type;
	private final String name;
	private final String linkMobile;
	private final String linkPc;
	private final String schemeIos;
	private final String schemeAndroid;

	public static class Builder {
		private final ButtonType type;
		private final String name;
		private String linkMobile;
		private String linkPc;
		private String schemeIos;
		private String schemeAndroid;

		public Builder(ButtonType type, String name) {
			this.type = type;
			this.name = name;
		}

		public Builder linkMobile(String url) {
			this.linkMobile = url;
			return this;
		}

		public Builder linkPc(String url) {
			this.linkPc = url;
			return this;
		}

		public Builder schemeIos(String url) {
			this.schemeIos = url;
			return this;
		}

		public Builder schemeAndroid(String url) {
			this.schemeAndroid = url;
			return this;
		}

		public KakaoButton build() {
			return new KakaoButton(this);
		}
	}

	private KakaoButton(Builder builder) {
		this.type = builder.type;
		this.name = builder.name;
		this.linkMobile = builder.linkMobile;
		this.linkPc = builder.linkPc;
		this.schemeIos = builder.schemeIos;
		this.schemeAndroid = builder.schemeAndroid;
	}

	public ButtonType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getLinkMobile() {
		return linkMobile;
	}

	public String getLinkPc() {
		return linkPc;
	}

	public String getSchemeIos() {
		return schemeIos;
	}

	public String getSchemeAndroid() {
		return schemeAndroid;
	}
}
