package sens.template.kakao.messages;

public class KakaoItemData {

    private final String title;

    private final String description;

    public KakaoItemData(String title, String description) {
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
