# 💉 DID 기반의 디지털 헌혈증 발급 서비스 👨‍⚕️ <a name="top"></a>
✔ 종이 헌혈증이 아닌 디지털 헌혈증으로, 발급 및 기부 시 시공간적 이점이 존재한다.

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


👉 Blood issue page
: 헌혈증 발급 페이지

👉 Search page
: 검색 및 병원 조회가 가능한 페이지


👉 Donation page
: 모든 헌혈증 요청글을 볼 수 있고 기부할 수 있는 페이지


👉 My blood donation page
: 내 헌혈증을 관리할 수 있는 페이지


<hr/>
<br/>

## 📄 ERD CHART <a name="erd"></a>


<hr/>
<br/>

## 📄 SYSTEM DIAGRAM <a name="system"></a>



<a href="#top">TOP</a>
