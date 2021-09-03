# 💉 DID 기반의 디지털 헌혈증 발급 서비스 👨‍⚕️ <a name="top"></a>
✔ 종이 헌혈증이 아닌 디지털 헌혈증으로, 발급 및 기부 시 시공간적 자원을 절약할 수 있다.

<br/>

## MOVE LOCATION

<a href="#history">📂 FOLDER HISTORY </a><br/>
<a href="#preview">📸 PAGE PREVIEW </a><br/>
<a href="#erd">📄 ERD CHART </a><br/>
<a href="#system">📄 SYSTEM DIAGRAM </a><br/>

<hr/>
<br/>

## 📂 FOLDER HISTORY <a name="history"></a>
### 👉 [Web] Blood donation page
- spring boot에서 MVC pattern 사용하여 개발
- <b>model</b> : hanium2020_did/src/main/java/com/example/demo/model/
  - logic and DB
  - getter, setter function
- <b>view</b> : hanium2020_did/src/main/webapp/WEB-INF/views/
  - web page front
- <b>controller</b> : hanium2020_did/src/main/java/com/example/demo/controller/
  - service에서 만든 함수를 사용하여 view와 model 연결
  - 요청을 받고 응답을 보냄
- <b>service</b> : hanium2020_did/src/main/java/com/example/demo/service/
  - mpl : 다양한 함수 구현
- <b>repository</b> : hanium2020_did/src/main/java/com/example/demo/repository/
  - interface
  
### 👉 [Docs] Docs
- 설계
  - DB
  - UI (화면구성도)
  - 기능차트
  - 시스템 구성도
  - 프로그램 목록

<hr/>
<br/>

## 📸 PAGE PREVIEW <a name="preview"></a>
👉 Main page
: 메인 페이지

![screencapture-localhost-8080-2021-09-03-15_46_55](https://user-images.githubusercontent.com/63227474/131963946-e8bf4532-7f5f-4323-bbc8-1a6fb465db78.png)

👉 Blood issue page
: 헌혈증 발급 페이지

![image](https://user-images.githubusercontent.com/63227474/131963675-39d7611d-214e-45c0-a25e-99d2730f5d98.png)

👉 Donation page
: 모든 헌혈증 요청글을 볼 수 있고 기부할 수 있는 페이지

![image](https://user-images.githubusercontent.com/63227474/131963720-31e93719-6e0b-4ff5-9856-034dbafd783c.png)

👉 My blood donation page
: 내 헌혈증을 관리할 수 있는 페이지

![image](https://user-images.githubusercontent.com/63227474/131963646-b337f905-c370-4bba-8dfd-84f631c25fd8.png)


<hr/>
<br/>

## 📄 ERD CHART <a name="erd"></a>

![image](https://user-images.githubusercontent.com/63227474/131963795-3f947129-72b9-4cd2-b0da-0ab0832568b8.png)

<hr/>
<br/>

## 📄 SYSTEM DIAGRAM <a name="system"></a>

![image](https://user-images.githubusercontent.com/63227474/131963903-00e38f0a-9c83-42e8-8ee3-68a9769613da.png)

<a href="#top">TOP</a>
