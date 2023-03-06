# KakaoAlimTalkExample

카카오 친구톡 예제 입니다.

## Step 1. RequestBody 생성

[네이버 친구톡 API](https://api.ncloud-docs.com/docs/ai-application-service-sens-friendtalkv2)를 참고하여 요구 스펙에 맞춰 Request Body를 생성합니다.

친구톡 메시지에 버튼이 있다면 아래와 같이 버튼을 생성 후 리스트에 추가합니다.

```java
// 버튼 생성
List<KakaoButton> buttonList = new ArrayList<>();
KakaoButton cancelButton = new KakaoButton.Builder(ButtonType.WL, "버튼 이름")
		.linkMobile("http://localhost:8080/")
		.linkPc("http://localhost:8080/")
		.build();
buttonList.add(cancelButton);
```

친구톡 메시지는 아래와 같이 생성하며, 개행문자를 빠트리지 않도록 조심해야합니다.

```java
List<KaKaoMessage> messages = new ArrayList<>();
KaKaoMessage enterBodyMessage = new KaKaoMessage.Builder("수신자 휴대폰 번호",
		"안녕하세요.\n"
		+"naver-sens-java\n"
		+"잘 부탁드립니다.")
		.buttons(buttonList) // 위에 생성했던 버튼 리스트 추가 
		.build();
messages.add(message);
```

친구톡 메시지에는 추가적으로 아래와 같이 설정이 가능합니다.<br>
네이버 친구톡 API를 참고하여 필요한 부분을 설정 해주시면 됩니다.

```java
new KaKaoMessage.Builder("수신자 휴대폰 번호", "템플릿 내용")
		.isAd() // boolean
		.countryCode() // String
		.image() // KakaoImage
		.useSmsFailover() // boolean
		.failoverConfig() // FailOverConfig
		.buttons() // List<KakaoButton>
		.build()
```

마지막으로 요청 양식에 맞춰 RequestBody 를 생성합니다.

```java
// paramter : 카카오톡 채널 ID, 위에서 생성한 message
KakaoRequestBody requestBody = new KakaoRequestBody.Builder("@narurestaurant", enterBodyMessage)
		.build();
```

KakaoRequestBody에는 추가적으로 아래와 같이 설정이 가능합니다.<br>
이 또한 친구톡 메시지와 같이 친구톡 API를 참고하여 필요하면 설정 해주시면 됩니다.

```java
// paramter : 카카오톡 채널 ID, 위에서 생성한 message
KakaoRequestBody requestBody = new KakaoRequestBody.Builder("카카오 채널 아이디", "본문")
		.reserveTime() // String : yyyy-MM-dd HH:mm
		.reserveTimeZone() // String
		.scheduleCode() // String
		.build();
```

## Step 2. 친구톡 전송

발급받은 키와 서비스Id를 가지고 메시지 서비스 인스턴스를 생성 후 알림톡을 전송합니다.

```java
MessageService messageService = new MessageService("accessKey", "secretKey", "serviceId");
MessageResponse response = messageService.send(MessageType.FRIENDTALK, requestBody);

response.getStatusCode(); // 상태코드
response.getStatusName(); // 상태메시지
```
