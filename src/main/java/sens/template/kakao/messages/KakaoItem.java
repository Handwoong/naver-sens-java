package sens.template.kakao.messages;

import java.util.List;

public class KakaoItem {

    private final List<KakaoItemData> list;

    private KakaoItemData summary;

    public KakaoItem(List<KakaoItemData> list) {
        this.list = list;
    }

    public KakaoItem(List<KakaoItemData> list,
            KakaoItemData summary) {
        this.list = list;
        this.summary = summary;
    }

    public List<KakaoItemData> getList() {
        return list;
    }

    public KakaoItemData getSummary() {
        return summary;
    }
}
