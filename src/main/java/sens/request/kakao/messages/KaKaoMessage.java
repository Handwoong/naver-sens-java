package sens.request.kakao.messages;

import java.util.List;

import sens.request.kakao.FailOverConfig;

public class KaKaoMessage {
	private final boolean isAd;
	private final KakaoImage image;
	private final String countryCode;
	private final String to;
	private final String title;
	private final String content;
	private final String headerContent;
	private final KakaoItemTitleAndDescription itemHighlight;
	private final KakaoItem item;
	private final FailOverConfig failoverConfig;
	private final List<KakaoButton> buttons;
	private final boolean useSmsFailover;

	public static class Builder {
		private boolean isAd;
		private KakaoImage image;
		private String countryCode;
		private final String to;
		private String title;
		private final String content;
		private String headerContent;
		private KakaoItemTitleAndDescription itemHighlight;
		private KakaoItem item;
		private FailOverConfig failoverConfig;
		private List<KakaoButton> buttons;
		private boolean useSmsFailover;

		public Builder(String to, String content) {
			this.to = to;
			this.content = content;
		}

		public Builder isAd(boolean isAd) {
			this.isAd = isAd;
			return this;
		}

		public Builder image(KakaoImage image) {
			this.image = image;
			return this;
		}

		public Builder countryCode(String countryCode) {
			this.countryCode = countryCode;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder headerContent(String headerContent) {
			this.headerContent = headerContent;
			return this;
		}

		public Builder itemHighlight(KakaoItemTitleAndDescription itemHighlight) {
			this.itemHighlight = itemHighlight;
			return this;
		}

		public Builder item(KakaoItem item) {
			this.item = item;
			return this;
		}

		public Builder failoverConfig(FailOverConfig failoverConfig) {
			this.failoverConfig = failoverConfig;
			return this;
		}

		public Builder buttons(List<KakaoButton> kakaoButtons) {
			this.buttons = kakaoButtons;
			return this;
		}

		public Builder useSmsFailover(boolean useSmsFailover) {
			this.useSmsFailover = useSmsFailover;
			return this;
		}

		public KaKaoMessage build() {
			return new KaKaoMessage(this);
		}
	}

	private KaKaoMessage(Builder builder) {
		this.isAd = builder.isAd;
		this.image = builder.image;
		this.countryCode = builder.countryCode;
		this.to = builder.to;
		this.title = builder.title;
		this.content = builder.content;
		this.headerContent = builder.headerContent;
		this.itemHighlight = builder.itemHighlight;
		this.item = builder.item;
		this.failoverConfig = builder.failoverConfig;
		this.buttons = builder.buttons;
		this.useSmsFailover = builder.useSmsFailover;
	}

	public boolean isAd() {
		return isAd;
	}

	public KakaoImage getImage() {
		return image;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getTo() {
		return to;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getHeaderContent() {
		return headerContent;
	}

	public KakaoItemTitleAndDescription getItemHighlight() {
		return itemHighlight;
	}

	public KakaoItem getItem() {
		return item;
	}

	public FailOverConfig getFailoverConfig() {
		return failoverConfig;
	}

	public List<KakaoButton> getButtons() {
		return buttons;
	}

	public boolean isUseSmsFailover() {
		return useSmsFailover;
	}
}
