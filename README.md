# 🌱 greeNote(팀명: 드림)
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/greeNote_backend/assets/105475267/f7855066-dc64-49da-9457-cd7eac763af7)



## 📋 서비스 소개
* 서비스명: 식물 사진 기반 질병 분류 및 생성 AI를 적용한 식물 다이어리
* 서비스설명:
  - 사용자가 게시한 사진을 분석하여 질병 유무와 종류를 알려주는 서비스 제공
  - 사용자가 게시한 사진을 생성 AI를 통해 스타일을 변경시켜 새로운 사진을 생성하는 서비스 제공
  - 사용자가 가꾸는 식물을 종류별로 나누어 기록하고 일별, 종류별로 나누어 열람하는 서비스 제공
<br>

## 🗓️ 프로젝트 기간
2023.09.20 ~ 2023.11.09 (7주)
<br>
<br>

## ✨ 개발 내용

#### 데이터 수집
<p>- AI-Hub(시설 작물 질병 진단 이미지) 데이터 수집</p>
<p>- Kaggle(식물 질병 이미지) 데이터 수집</p>
<p>- Crawling을 통해 식물이미지, 스타일이미지 데이터 수집</p>

#### 데이터 전처리
<p>- 오버피팅을 방지하기 위해 데이터를 언더샘플링하여 균형 맞춤</p>
<p>- 2개 이상의 질병 증상이 한번에 나나타는 이미지 삭제</p>
<p>- Tensor Flow 라이브러리를 이용하여 최대 이미지 크기를 512개의 픽셀로 제한</p>

#### 딥러닝
<p>- 이미지, 가중치를 활용하여 모델 구현</p>
<p>- 이미지 활용 식물 질병 예측(ResNet34 모델)</p>
<p>- 테스트 데이터를 통해 최종 모델의 정확도 검증</p>
<p>- 이미지 활용 스타일 전이(VGG19 모델)</p>

#### 데이터 수집
<p>- AI-Hub(시설 작물 질병 진단 이미지) 데이터 수집</p>
<p>- Kaggle(식물 질병 이미지) 데이터 수집</p>
<p>- Crawling을 통해 식물이미지, 스타일이미지 데이터 수집</p>

#### 데이터 수집
<p>- AI-Hub(시설 작물 질병 진단 이미지) 데이터 수집</p>
<p>- Kaggle(식물 질병 이미지) 데이터 수집</p>
<p>- Crawling을 통해 식물이미지, 스타일이미지 데이터 수집</p>

#### 데이터 수집
<p>- AI-Hub(시설 작물 질병 진단 이미지) 데이터 수집</p>
<p>- Kaggle(식물 질병 이미지) 데이터 수집</p>
<p>- Crawling을 통해 식물이미지, 스타일이미지 데이터 수집</p>

#### 데이터 수집
<p>- AI-Hub(시설 작물 질병 진단 이미지) 데이터 수집</p>
<p>- Kaggle(식물 질병 이미지) 데이터 수집</p>
<p>- Crawling을 통해 식물이미지, 스타일이미지 데이터 수집</p>

## ⛏️ 기술스택
<table>
    <tr>
        <th>구분</th>
        <th>내용</th>
    </tr>
    <tr>
        <td>사용언어</td>
        <td>
          <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
          <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white" />
          <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white" />
          <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white" />
          <img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white">
        </td>
    </tr>
    <tr>
        <td>라이브러리</td>
        <td>
          <img src="https://img.shields.io/badge/BootStrap-7952B3?style=for-the-badge&logo=BootStrap&logoColor=white" />
          <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
          <img src="https://img.shields.io/badge/lombok-F80000?style=for-the-badge&logo&logoColor=white" />
          <img src="https://img.shields.io/badge/Mybatis-181717?style=for-the-badge&logo&logoColor=white" />
          <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
        </td>
    </tr>
   <tr>
        <td>API</td>
        <td>
          <img src="https://img.shields.io/badge/KakaoLogin-FFCD00?style=for-the-badge&logo=Kakao&logoColor=white" />
          <img src="https://img.shields.io/badge/Octoparse-007ACC?style=for-the-badge&logo=octopusdeploy&logoColor=white" />
          <img src="https://img.shields.io/badge/PortOne-F05032?style=for-the-badge&logo=&logoColor=white" />
        </td>
    </tr>
    <tr>
        <td>개발도구</td>
        <td>
          <img src="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=Eclipse&logoColor=white" />
          <img src="https://img.shields.io/badge/VSCode-007ACC?style=for-the-badge&logo=VisualStudioCode&logoColor=white" />
          <img src="https://img.shields.io/badge/Jupyter-F37626?style=for-the-badge&logo=Jupyter&logoColor=white" />
        </td>
    </tr>
    <tr>
        <td>서버환경</td>
        <td>
            <img src="https://img.shields.io/badge/Apache Tomcat-D22128?style=for-the-badge&logo=Apache Tomcat&logoColor=white" />
        </td>
    </tr>
    <tr>
        <td>데이터베이스</td>
        <td>
            <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white" />
            <img src="https://img.shields.io/badge/sqlDeveloper-E8E8E8?style=for-the-badge&logo=&logoColor=white" />
        </td>
    </tr>
    <tr>
        <td>협업도구</td>
        <td>
            <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white" />
            <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white" />
            <img src="https://img.shields.io/badge/Notion-white?style=for-the-badge&logo=Notion&logoColor=000000&" />
        </td>
    </tr>
</table>


<br>


## ⚙️ 시스템 아키텍처
![시스템 아키텍처](https://github.com/2023-SMHRD-SW-DataDesign-1/404-change-/assets/134493664/358e60d1-9ccd-4809-92e8-5df085026483)





## ✏️ 유스케이스
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/404-change-/assets/134522874/95226750-63e2-44ac-9193-0dd155e1ad58)


## ✏️ 서비스 흐름도
![서비스흐름도](https://github.com/2023-SMHRD-SW-DataDesign-1/404-change-/assets/134493664/79f5be60-a13e-4f37-aac9-c0877c9fa03b)




## ✏️ ER 다이어그램
![er다이어그램](https://github.com/2023-SMHRD-SW-DataDesign-1/404-change-/assets/105475267/5d6c8d7f-e6d7-490c-8c81-499411820801)

<br>
 
## 🖥️ 화면구성
### 메인
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/404-change-/assets/134493664/0e5fe8fe-c692-4b5a-b1ff-8455546acae2)

<br>

### sns 채널 메인
![image (1)](https://github.com/2023-SMHRD-SW-DataDesign-1/404-change-/assets/134493664/daec1534-2021-47e4-973a-1dedd3ae7972)

<br>

### sns 피드
![image (2)](https://github.com/2023-SMHRD-SW-DataDesign-1/404-change-/assets/134493664/1c8e8cb1-32e5-47e5-91e9-5ea7b7c6ad1b)

<br>

### 상품상세페이지
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/404-change-/assets/134493664/f8179a00-787a-41c9-83ca-27c847d77f3d)

<br>

### 주문페이지
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/404-change-/assets/134493664/788c1f6e-c650-41c0-997b-fc6ebda16abf)

<br>

## 👑 팀원역할

<table>
  <tr>
    <td>이름</td>
    <td>김지홍</td>
    <td>김드보라</td> 
    <td>이윤호</td>
    <td>진찬호</td>
  </tr>
    <tr>
    <td>계정링크</td>
    <td><a href="https://github.com/philosokey-M" target='_blank'>github</a></td>
    <td><a href="https://github.com/DeboraKim1016" target='_blank'>github</a></td>
    <td><a href="https://github.com/dldbsgh00005" target='_blank'>github</a></td>
    <td><a href="https://github.com/jinchanho" target='_blank'>github</a></td>
  </tr>
  <tr>
    <td>담당</td>
    <td> PM / Back-End </td>
    <td> Front-End </td>
    <td> Back-End </td>
    <td> DB / Front-End </td>
  </tr>
  <tr>
    <td>역할</td>
    <td> 팔로우 기능 구현 </td>
    <td> 전체화면설계 및 구현</td>
    <td> 회원관리기능 </td>
    <td> 크롤링 </td>
  </tr>
  <tr>
    <td>  </td>
    <td> 좋아요, 댓글 기능 구현</td>
    <td>   </td>
    <td> SNS로그인 기능 구현 </td>
    <td> DB설계 및 구축 </td>
  </tr>
  <tr>
    <td>  </td>
    <td> 피드생성 및 출력</td>
    <td>   </td>
    <td> 결제 API </td>
    <td>  프론트 JS담당  </td>
  </tr>
  <tr>
    <td>  </td>
    <td> 상품등록 및 출력</td>
    <td>   </td>
    <td> 장바구니 </td>
    <td>  DTO 구축  </td>
  </tr>
  <tr>
    <td>  </td>
    <td> 실시간 채팅 기능 구현</td>
    <td>   </td>
    <td>   </td>
    <td>   </td>
  </tr> 
</table>




## 🔑 트러블슈팅
<br>
<h3>실시간 채팅 </h3>
<p>실시간 채팅의 데이터 전송 방식을 서버를 항상 열어두는 long polling방식으로 개발을 했으나 서버를 열어둔 채로 유지하는 과정이 불안정해서 잦은 에러가 발생했습니다.</p>
<p>long polling 방식이 아닌 web socket방식으로 변경하자 전보다 서버가 안정적으로 운영되었고 단체 채팅도 가능하게 되었습니다. </p>
<br>
<br>
<h3>mybatis error </h3>
<p>'sqlSession is null' 이라는 에러가 반복적으로 발생했습니다. mybatis 환경이나 mapper의 namespace 등 틀린 부분이 없었는데도 에러가 반복되었습니다.</p>
<p>DAO의 메소드 안에 mapper로 보낼 때 쓰는 ID값 앞에 'com.smhrd.FeedMapper.showFeed'라고 주소값을 직접 적어주니 정상적으로 실행됐습니다. </p>
<br>
<br>
<h3>카카오 SNS로그인 API error </h3>
<p>카카오 로그인API를 실행시키자 404에러가 발생했습니다.</p>
<p>원인을 몰라 카카오 관리자에게 문의하자 사용중인 API가 구버전인 것을 알게 되었고</p>
<p>신버전으로 바꾸자 정상적으로 실행되었습니다.</p>
<br>
<br>
<h3>크롤링 </h3>
<p>실시간으로 데이터가 바뀌는 사이트에서 크롤링을 하다보니 동시에 여러 페이지의 데이터를 수집해야 했었는데 이 과정에서 원하는 데이터만 가져오는 것에 어려움이 많았습니다.</p>
<p>그래서 octopus라는 크롤링 tool을 활용해서 원하는 데이터만을 제대로 크롤링하는데 성공했습니다.</p>
