package sens.request.kakao.messages;

import java.util.List;

public class KakaoItem {
	private final List<KakaoItemTitleAndDescription> list;
	private KakaoItemTitleAndDescription summary;

	public KakaoItem(List<KakaoItemTitleAndDescription> list) {
		this.list = list;
	}

	public KakaoItem(List<KakaoItemTitleAndDescription> list, KakaoItemTitleAndDescription summary) {
		this.list = list;
		this.summary = summary;
	}

	public List<KakaoItemTitleAndDescription> getList() {
		return list;
	}

	public KakaoItemTitleAndDescription getSummary() {
		return summary;
	}
}
