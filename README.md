# naver-sens-java

Naver Cloud Platform SENS(Simple & Easy Notification Service) for Java

## How to

To get a Git project into your build:

*Step 1*. Add the JitPack repository to your build file

gradle maven sbt leiningen Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

*Step 2*. Add the dependency

```groovy
dependencies {
    implementation 'com.github.Handwoong:naver-sens-java:0.3.0'
}
```

## Example

* [카카오 알림톡 예제](https://github.com/Handwoong/naver-sens-java/blob/master/example/KakaoAlimTalkExample.md)
