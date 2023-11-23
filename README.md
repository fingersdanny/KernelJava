# Kernel 360 Object Oriented Programming 사전과제

## 1. SIS Project (학점 산출 문제)

### 문제 정의 

 - SilverBell School이 있습니다. 이 학교에는 5명의 학생들이 수업을 듣습니다. 과목은 국어와 수학이 있고, 각 학생은 두 과목을 모두 수강합니다. 

전공은 컴퓨터공학과 국어국문학 두 가지가 있습니다. 컴퓨터공학과 학생은 수학이 필수과목이고, 국어국문학과 학생은 국어가 필수 과목입니다. 

각 학생별로 한 개의 전공을 선택합니다. 

이번 학기 각 학생의 성적은 다음과 같습니다.

| 이름 | 학번 | 전공 | 필수 과목 | 국어 점수 | 수학 점수 |
| ------ | ------ | ------ | ------ | ------ | ------ |
| 강감찬 | 211213 | 국어국문학과 | 국어 | 95 | 56 |
| 김유신 | 212330 | 컴퓨터공학과 | 수학 | 95 | 98 |
| 신사임당 | 201518 | 국어국문학과 | 국어 | 100 | 88 |
| 이순신 | 202360 | 국어국문학과 | 국어 | 89 | 95 |
| 홍길동 | 201290 | 컴퓨터공학과 | 수학 | 83 | 56 |

- 학점을 부여하는 방벅은 여러 가지가 있습니다. 단순히 A,B,C,D,F를 부여하는 방법, A+, B-처럼 +/-를 사용하는 방법, Pass/Fail 만을 부여하는 방법등이 있습니다. 

여기 각 학생에게 학점을 부여하는 데 사용하는 정책은 두 가지입니다. 일반 과목이라면 A ~ F로, 필수 과목이라면 S ~ F 로 분류합니다. 점수에 따른 학점 부여기준은 

다음과 같습니다

- 필수 과목 학점 기준

| S | A | B | C | D | F |
| ------ | ------ | ------ | ------ | ------ | ------ |
| 95~100점 | 90~94점 | 80~89점 | 70~79점 | 60~69점 | 60점 미만 |

- 일반 과목 학점 기준

| A | B | C | D | F |
| ------ | ------ | ------ | ------ | ------ |
| 90~100점 | 80~89점 | 70~79점 | 55~69점 | 55점 미만 |

만약 똑같이 95점을 받은 경우, 필수 과목이라면 S를 받지만, 일반 과목은 A를 받습니다. 또한 56점을 받으면 필수 과목은 F이지만, 일반 과목은 D를 받습니다.

- 프로그램 구현 과제

위와 같이 주어진 성적과 각 과목에 대한 학점 정책에 따라 아래와 같이 학점 결과가 나올 수 있도록 구현합니다.

학점의 정책이 추가되는 경우와 과목이 추가되는 경우를 고려하여 객체를 설계하고 학점 정책에 대해서는 인터페이스를 선언하고 각 정책이 해당 인터페이스를 구현하도록 합니다. 

- 학정 정책의 추가
  
방송댄스 과목이 새로 개설되고 이 과목의 학점 평가 정책은 pass/fail 로 정해졌다고 합니다. 70점 이상인 경우는 pass, 미만인 경우는 fail입니다.

전체 5명 학생중 3명만이 이 과목을 수강신청 했습니다. 추가된 요구사항이 잘 반영되도록 구현하세요   
   
![math](https://github.com/easyspubjava/KernelJava/assets/37524201/c9f2d724-5b72-4532-b581-5fbed5a78766)


![kor](https://github.com/easyspubjava/KernelJava/assets/37524201/2ac62cc3-5d62-464f-b5cd-c4b984c4585c)



![dance](https://github.com/easyspubjava/KernelJava/assets/37524201/24df3e62-8eab-43be-b025-67d0370b3532)


### 미션
  
-  콘솔 프로그램으로 작성 된 내용을 WAS에 올린다.

-  학교, 학생, 과목, 성적에 대한 데이터베이스를 만들어 연동한다.

-  웹페이지에서 학생(필수 과목), 과목을 등록하도록 한다.

-  학생이 과목을 수강신청하도록 한다.

- 성적에 대한 학생별, 과목 별 학점 내용을 볼 수 있도록 한다.

  
## 2. 고객 서비스 센터 문제 (스케줄링 정책)

### 문제 정의   

아갤폰 고객 센터에는 엔지니어가 한 명 있습니다. 고객들은 핸드폰을 액정을 A/S 하러 왔습니다. 고객은 9시 부터 선착순 10분까지 입장하고 서비스는 10시에 시작합니다. 도착한 손님은 선착순 대기열표를 가지고 기다리고 있습니다.
각 손님의 고객 센터에 도착한 시간, 수리에 필요한 시간은 다음과 같습니다. A/S 처리 방식은 아래 두 가지 경우가 있습ㄴ디ㅏ. 
각 처리 방식에 대해 모든 손님의 수리가 끝난 뒤 수리 순서, 총 걸린 시간, 총 기다린 시간을 출력해 보세요

처리방식  
- FIFO : 도착 시간이 빠른 손님부터 처리 (선착순)

- Least Job First : 수리 시간이 적게 걸리는 손님부터 처리

| 이름 | 도착 시간 | 서비스 소요시간 | 
| ------ | ------ | ------ | 
|Jane | 0 | 1 | 
| Tomas | 2 | 12 | 
| Edward | 5 | 5 | 
| Kelly | 6 | 6 | 
| Tom | 7 | 3 | 
| John | 9 | 1 | 
| Kyle | 10 | 3 |

### 결과 
<img width="743" alt="스크린샷 2023-11-23 오후 7 36 33" src="https://github.com/easyspubjava/KernelJava/assets/37524201/1bd7c661-41f0-4dbc-afa9-ad41dc3f74c0">

### 미션
- 정책을 인터페이스에서 상속받아 처리합니다.
- PriorityQueue를 사용합니다.
  


