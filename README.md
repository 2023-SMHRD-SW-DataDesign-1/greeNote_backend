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

#### ResNet34 모델을 통한 이미지 활용 식물 질병 예측
<p>- CNN 기반으로 만들어진 ResNet34 모델 로드</p>
<p>- 이미지 데이터, fast ai 라이브러리를 이용하여 모델 학습</p>

#### VGG19 모델을 통한 스타일 전이
<p>- CNN 기반으로 만들어진 VGG19 모델 로드</p>
<p>- 이미지 데이터, Tensor Flow 라이브러리를 이용하여 모델 학습</p>

#### 웹 구축 및 기능 구현
<p>- HTML/Sass를 통한 웹페이지 구현</p>
<p>- React, Spring Boot를 활용하여 웹페이지 기능 구현</p>
<p>- Python, JavaScript, Flask를 활용하여 딥러닝 모델과 실시간 연동</p>

#### 서버 구축
<p>- Node 서버로 React 웹 서버 구축</p>
<p>- Spring Boot 내장 Apache Tomcat을 이용한 백엔드 서버 구축</p>
<p>- Flask 서버로 딥러닝 모델 서버 구축</p>

## ⛏️ 기술스택
<table>
    <tr>
        <th>구분</th>
        <th>내용</th>
    </tr>
    <tr>
        <td>Front</td>
        <td>
          <img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white">
          <img src="https://img.shields.io/badge/Sass-CC6699?style=for-the-badge&logo=Sass&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>Back</td>
        <td>
          <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white" />
          <img src="https://img.shields.io/badge/SpringSecurity-6DB33F?style=for-the-badge&logo=SpringSecurity&logoColor=white">
          <img src="https://img.shields.io/badge/JPA-F80000?style=for-the-badge&logo=JPA&logoColor=white" />
          <img src="https://img.shields.io/badge/Mybatis-181717?style=for-the-badge&logo&logoColor=white" />
          <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
        </td>
    </tr>
   <tr>
        <td>DB</td>
        <td>
          <img src="https://img.shields.io/badge/KakaoLogin-FFCD00?style=for-the-badge&logo=Kakao&logoColor=white" />
          <img src="https://img.shields.io/badge/Octoparse-007ACC?style=for-the-badge&logo=octopusdeploy&logoColor=white" />
          <img src="https://img.shields.io/badge/PortOne-F05032?style=for-the-badge&logo=&logoColor=white" />
        </td>
    </tr>
    <tr>
        <td>AI</td>
        <td>
          <img src="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=Eclipse&logoColor=white" />
          <img src="https://img.shields.io/badge/VSCode-007ACC?style=for-the-badge&logo=VisualStudioCode&logoColor=white" />
          <img src="https://img.shields.io/badge/Jupyter-F37626?style=for-the-badge&logo=Jupyter&logoColor=white" />
        </td>
    </tr>
    <tr>
        <td>배포</td>
        <td>
            <img src="https://img.shields.io/badge/Apache Tomcat-D22128?style=for-the-badge&logo=Apache Tomcat&logoColor=white" />
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
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/greeNote_backend/assets/105475267/dc4c3c30-354f-4406-94f8-29749c4c5ca3)



## ✏️ 유스케이스
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/greeNote_backend/assets/105475267/6d7d99f1-955f-416e-8a6a-585b1dc9ad47)



## ✏️ 서비스 흐름도
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/greeNote_backend/assets/105475267/04dfd7fd-1928-4e7c-86c8-6f2abdade419)



## ✏️ ER 다이어그램
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/greeNote_backend/assets/105475267/8e444f1e-4a61-42d1-9baf-b3ee87a52f78)

<br>
 
## 🖥️ 화면구성
### 메인
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/greeNote_backend/assets/105475267/3c209798-f662-40b9-b976-d056e081a87a)

<br>

### 메인상세페이지
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/greeNote_backend/assets/105475267/d3f4dde5-2504-451b-8c7e-d628eb6afc46)


<br>

### 다이어리 & 질병분류기
![image](https://github.com/2023-SMHRD-SW-DataDesign-1/greeNote_backend/assets/105475267/0845f4a7-e627-4349-b4f5-22398447ef13)


<br>


## 👑 팀원역할

<table>
  <tr>
    <td>이름</td>
    <td>허광영</td>
    <td>이윤호</td> 
    <td>유한솔</td>
    <td>김지혜</td>
    <td>진찬호</td>
  </tr>
    <tr>
    <td>계정링크</td>
    <td><a href="https://github.com/KwangYoungHeo" target='_blank'>github</a></td>
    <td><a href="https://github.com/dldbsgh00005" target='_blank'>github</a></td>
    <td><a href="https://github.com/pbnc1123" target='_blank'>github</a></td>
    <td><a href="https://github.com/rlawlgp0197" target='_blank'>github</a></td>
    <td><a href="https://github.com/jinchanho" target='_blank'>github</a></td>
  </tr>
  <tr>
    <td>담당</td>
    <td> PM / Back-End </td>
    <td> DB / AI </td>
    <td> Front-End </td>
    <td> Front-End </td>
    <td> DB / AI </td>
  </tr>
  <tr>
    <td>역할</td>
    <td> 서버 구축 및 데이터 전송 환경 구축 </td>
    <td> ERD 설계 </td>
    <td> 화면설계서 </td>
    <td> 반응형 구조 환경설정(SASS) </td>
    <td> DB 설계, ERD 설계 </td>
  </tr>
  <tr>
    <td>  </td>
    <td> AWS를 사용한 서비스 배포, https 설정 </td>
    <td> ResNet34 모델을 통한 이미지 활용 식물 질병 진단 기능 </td>
    <td> 메인 페이지 </td>
    <td> 인트로 소개페이지 </td>
    <td> ResNet34 모델을 통한 이미지 활용 식물 질병 진단 기능 </td>
  </tr>
  <tr>
    <td>  </td>
    <td> DB설계 및 구축 </td>
    <td> VGG19 모델을 통한 스타일 전이 기능 </td>
    <td> 로그인/회원가입 페이지 </td>
    <td> 작성된 다이어리 사진을 불러와 스타일을 선택해 생성AI의 결과로 보여주기 기능  </td>
    <td> VGG19 모델을 통한 스타일 전이 기능 </td>
  </tr>
  <tr>
    <td>  </td>
    <td> VGG19 모델을 통한 스타일 전이 기능 </td>
    <td>  </td>
    <td> 다이어리 작성 페이지 </td>
    <td> 작성된 다이어리 사진을 불러와 슬라이드로 보여주기 기능 </td>
    <td>  </td>
  </tr>
  <tr>
    <td>  </td>
    <td> JWT방식 회원관리 기능 </td>
    <td>   </td>
    <td> 작성된 다이어리 불러와 모아보기 /개별 다이어리 페이지 </td>
    <td>  </td>
    <td>  </td>
  </tr>
  <tr>
    <td>  </td>
    <td> 식물 목록 작성, 삭제 기능 </td>
    <td>   </td>
    <td> 전체 식물리스트 페이지 </td>
    <td>  </td>
    <td>  </td>
  </tr> 
  <tr>
    <td>  </td>
    <td> 다이어리 작성, 수정, 삭제 기능 </td>
    <td>   </td>
    <td> 식물 추가 페이지 </td>
    <td>  </td>
    <td>  </td>
  </tr> 
  <tr>
    <td>  </td>
    <td> 목록별, 일별 작성된 다이어리 조회 기능 </td>
    <td>   </td>
    <td> 마이페이지 </td>
    <td>  </td>
    <td>  </td>
  </tr> 
</table>
<br>

## 🔑 트러블슈팅
<h3>Back</h3>
<p>JWT 토큰을 쿠키로 전달하려 했지만 전달되지 않는 문제 발생</p>
<p>'sameSite' 속성을 'None'으로 설정해야 하지만 https에서만 가능한 설정, https 설정을 위해 AWS의 ACM 인증서와 로드 밸런서를 사용해서 https 적용 완료! 쿠키 전달 완료!</p>
<br>
<h3>AI</h3>
<p>질병이 2개 이상 나타나는 이미지들로 인해 분류가 잘 되지 않는 상황이 발생</p>
<p>질병이 1개만 나타나는 이미지들을 선별하여 데이터셋에 채택 후 학습하여 해결!</p>
<br>
