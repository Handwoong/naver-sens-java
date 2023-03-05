package sens.request.kakao.messages;

public class KakaoImage {
	private final String imageId;
	private final String imageLink;

	public KakaoImage(String imageId, String imageLink) {
		this.imageId = imageId;
		this.imageLink = imageLink;
	}

	public String getImageId() {
		return imageId;
	}

	public String getImageLink() {
		return imageLink;
	}
}
