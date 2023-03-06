# KakaoAlimTalkExample

카카오 알림톡 예제 입니다.

## Step 1. 템플릿 생성

[네이버 알림톡 API](https://api.ncloud-docs.com/docs/ko/ai-application-service-sens-alimtalkv2)를 참고하여 네이버 클라우드 플랫폼 SENS에 등록 한 알림톡 템플릿에 맞춰 Request
Body를 생성합니다.

예제로 등록된 템플릿은 아래와 같습니다.

![example_template](https://user-images.githubusercontent.com/95131477/222959458-c45110e4-7cf9-4f23-a7ed-1cc1bd7230f8.png)

템플릿에 버튼이 있다면 아래와 같이 버튼을 생성 후 리스트에 추가합니다.

```java
// 버튼 생성
List<KakaoButton> buttonList = new ArrayList<>();
KakaoButton cancelButton = new KakaoButton.Builder(ButtonType.WL, "대기 취소하기")
		.linkMobile("http://localhost:8080/")
		.linkPc("http://localhost:8080/")
		.build();
buttonList.add(cancelButton);
```

템플릿 메시지는 아래와 같이 생성하며, 개행문자를 빠트리지 않도록 조심해야합니다.

```java
List<KaKaoMessage> messages = new ArrayList<>();
KaKaoMessage enterBodyMessage = new KaKaoMessage.Builder("수신자 휴대폰 번호",
		"안녕하세요.\n"
		+"나루 coffee & restaurant입니다.\n"
		+"\n"
		+"대기번호 " + 템플릿 변수에 들어갈 값 + "번 고객님 지금 입장 해 주세요.\n"
		+"\n"
		+"■ 5분 이내 미 입장 시 대기 접수가 자동 취소되며, 다시 대기 등록을 해주셔야 합니다.")
		.buttons(buttonList) // 위에 생성했던 버튼 리스트 추가 
		.build();
messages.add(message);
```

템플릿 메시지에는 추가적으로 아래와 같이 설정이 가능합니다.<br>
네이버 알림톡 API를 참고하여 필요한 부분을 설정 해주시면 됩니다.

```java
new KaKaoMessage.Builder("수신자 휴대폰 번호", "템플릿 내용")
		.countryCode() // String
		.title() // String
		.headerContent() // String
		.item() // KakaoItem
		.useSmsFailover() // boolean
		.failoverConfig() // FailOverConfig
		.buttons() // List<KakaoButton>
		.build()
```

마지막으로 요청 양식에 맞춰 RequestBody 를 생성합니다.

```java
// paramter : 카카오톡 채널 ID, 위에서 생성한 message
KakaoRequestBody requestBody = new KakaoRequestBody.Builder("@narurestaurant", enterBodyMessage)
		.templateCode("CustomerEnter") // 템플릿 코드
		.build();
```

KakaoRequestBody에는 추가적으로 아래와 같이 설정이 가능합니다.<br>
이 또한 템플릿 메시지와 같이 알림톡 API를 참고하여 필요하면 설정 해주시면 됩니다.

```java
// paramter : 카카오톡 채널 ID, 위에서 생성한 message
KakaoRequestBody requestBody = new KakaoRequestBody.Builder("카카오 채널 아이디", "본문")
		.templateCode("템플릿 코드") // 여기까지 필수
		.reserveTime() // String : yyyy-MM-dd HH:mm
		.reserveTimeZone() // String
		.scheduleCode() // String
		.build();
```

## Step 2. 알림톡 전송

발급받은 키와 서비스Id를 가지고 메시지 서비스 인스턴스를 생성 후 알림톡을 전송합니다.

```java
MessageService messageService = new MessageService("accessKey", "secretKey", "serviceId");
MessageResponse response=messageService.send(MessageType.ALIMTALK, requestBody);

response.getStatusCode(); // 상태코드
response.getStatusName(); // 상태메시지
```
