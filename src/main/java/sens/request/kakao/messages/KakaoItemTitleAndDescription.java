package sens.request.kakao.messages;

public class KakaoItemTitleAndDescription {
	private final String title;
	private final String description;

	public KakaoItemTitleAndDescription(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
}
