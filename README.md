# Naver Game SDK


Naver Game SDK는 모바일 게임 사용자가 게임을 벗어나지 않고 **게임라운지**에서 소통할 수 있도록, 라운지를 게임 안에 네이티브 형태로 제공하는 **모바일 게임 전용 서비스**입니다.

![Naver Game SDK](https://github.com/naver/navergame-sdk-android/raw/master/guide/image.png)

&nbsp;
&nbsp;
&nbsp;
## How To Get Started

### 제휴 신청

**네이버 게임 공식 라운지**를 운영하시게 되면, SDK도 무료로 이용하실 수있습니다.

-   네이버 게임 공식 라운지 제휴 방법은 <a href="mailto:dl_navergame@navercorp.com">dl_navergame@navercorp.com</a>로 문의해주시면 절차를 안내 드리고 있습니다.
-   공식 라운지 관리 권한을 획득하신 후, 아래의 내용을 참고해주세요.

### 적용 가이드

- [SDK 적용 가이드](https://navergame.gitbook.io/naver-game/integration-guide/android)
- [최신 버전 및 샘플 프로젝트 다운로드](https://github.com/naver/cafe-sdk-android/archive/master.zip)

&nbsp;
&nbsp;
&nbsp;
## Communication 

개발과 관련된 문의 사항은 **SDK 공식 라운지**를 사용합니다.

- [SDK 공식 라운지](https://game.naver.com/lounge/naver_game_4developer/home)
- [SDK 공식 라운지의 개발 문의 게시판](https://game.naver.com/lounge/naver_game_4developer/community)

&nbsp;
&nbsp;
&nbsp;
## Usages

### 1. SDK 추가

Naver Game SDK를 사용하기위해서는 module단위의 gradle에 SDK를 포함한 하위 라이브러리들을 추가해야합니다.

- 샘플 프로젝트 gradle 설정위치 : app/build.gradle

```gradle
dependencies {
    /**
     * 네이버 게임 SDK와 SDK에서 사용되는 라이브러리들.
     */
    implementation files("libs/navergame-sdk-1.0.0.aar")            // Navergame SDK
    implementation "org.jetbrains.kotlin:kotlin-stdlib:1.3.72"      // Kotlin
    implementation "androidx.viewpager2:viewpager2:1.0.0"           // Viewpager2
    implementation "com.github.bumptech.glide:glide:3.7.0"          // Glide
    implementation "com.squareup.retrofit2:retrofit:2.7.2"          // Retrofit2
    implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0" //SwipeRefreshLayout
    implementation "com.squareup.retrofit2:converter-gson:2.6.4"
}
```

### 2. SDK 초기화

Naver Game SDK를 사용하기위해서는 SDK를 **초기화**합니다.

다음과 같은 초기화 옵션을 설정하고 **initModule()** 메서드를 호출합니다.

- LOUNGE_ID: <a href="mailto:dl_navergame@navercorp.com">공식 라운지 제휴</a>를 통해 발급받은 라운지 ID
- CLIEND_ID: [네이버 아이디로 로그인 개발자 센터](https://developers.naver.com/products/login/api)에 애플리케이션을 등록하고 받은 클라이언트 아이디
- CLIENT_SECRET: [네이버 아이디로 로그인 개발자 센터](https://developers.naver.com/products/login/api)에 애플리케이션을 등록하고 받은 클라이언트 시크릿

```java
final String LOUNGE_ID = "naver_game_4developer";
final String CLIEND_ID = "UKvNABLDsyEJusJGsXL2";
final String CLIENT_SECRET = "rK4suc_Qd0";
NNGLink.initModule(this, LOUNGE_ID, CLIEND_ID, CLIENT_SECRET);
```

### 3. SDK 시작

초기화가 완료되면 SDK를 실행합니다.

#### 3.1 startHome() 메서드

startHome() 메서드는 admin에서 설정해둔 배너를 불러오는 메서드입니다.

```java
/**
* 배너 불러오기
*/
NNGLink.startHome(activity)
```

#### 3.2 startSorry() 메서드

startSorry() 메서드는 admin에서 설정해둔 점검용 배너를 불러오는 메서드입니다.

```java
/**
* 점검용 배너 불러오기
*/
NNGLink.startSorry(activity)
```

&nbsp;
&nbsp;
&nbsp;
## Files and Folders

|폴더 및 파일 이름|설명|
|---|---|
|sample/|Android Studio용 샘플 프로젝트가 있는 폴더|
|NOTICE|라이선스 파일|
|CHANGELOG|SDK 버전 업데이트 내역|
|README.md|리드미 파일|

&nbsp;
&nbsp;
&nbsp;
## Dependent Libraries

SDK는 다음과 같은 라이브러리를 사용하고있습니다.

- Kotlin(1.3.72 버전 사용 중)
- Androidx Viewpager2(1.0.0 버전 사용 중)
- Androidx SwipeRefreshLayout(1.1.0 버전 사용 중)
- [Glide](http://mvnrepository.com/artifact/com.github.bumptech.glide/glide)(3.7.0 버전 사용 중)
- [Retrofit2](https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit)(2.7.2 버전 사용 중)
- hmac(2.3.1 버전 사용중)

&nbsp;
&nbsp;
&nbsp;
## License 

Naver Game SDK의 저작권은 네이버(주)에 있습니다.

```
NAVER Game SDK Android
Copyright 2021-present NAVER Corp.

Unauthorized use, modification and redistribution of this software are strongly prohibited.
```

