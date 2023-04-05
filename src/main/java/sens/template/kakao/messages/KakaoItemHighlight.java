package sens.template.kakao.messages;

public class KakaoItemHighlight {

    private final String title;

    private final String description;

    public KakaoItemHighlight(String title, String description) {
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
