# 일정 관리 앱 프로젝트

Spring Boot을 이용하여 일정 관리 앱을 개발해 보았습니다. 다양한 기능을 추가하여 점차적으로 프로젝트를 완성하였습니다.

## 📅 개발 기간

- **2025-03-07 ~ 2025-03-14**

## 💻 개발 환경

- **Java**: 17
- **JDK**: 17.0.11
- **빌드 도구**: Gradle
- **IDE**: IntelliJ IDEA
- **JDBC 연결**: MySQL JDBC 커넥터 사용
- **버전 관리**: Git, GitHub

## 🚀 프로젝트 목표

이 프로젝트는 스프링을 활용하여 스프링 프레임워크의 구조를 이해하고, JDBC를 사용하여 데이터베이스와 클라이언트 간의 상호작용을 학습하며 프로그램을 개발하는 것을 목표로 합니다.

## 🛠️ 개발 과정

### Lv 1. 일정 생성 및 조회
- **일정 생성(일정 작성하기)**
  - 일정 생성 시, 포함되어야할 데이터
    - `할일`, `작성자명`, `비밀번호`, `작성/수정일`을 저장
    - `작성/수정일`은 날짜와 시간을 모두 포함한 형태
  - 각 일정의 고유 식별자(ID)를 자동으로 생성하여 관리
  - 최초 입력 시, 수정일은 작성일과 동일

- **전체 일정 조회(등록된 일정 불러오기)**
  - 다음 **조건**을 바탕으로 등록된 일정 목록을 전부 조회
    - `수정일` (형식 : YYYY-MM-DD)
    - `작성자명`
  - 조건 중 한 가지만을 충족하거나, 둘 다 충족을 하지 않을 수도, 두 가지를 모두 충족할 수도 있습니다.
  - `수정일` 기준 내림차순으로 정렬하여 조회
        
- **선택 일정 조회(선택한 일정 정보 불러오기)**
  - 선택한 일정 단건의 정보를 조회할 수 있습니다.
  - 일정의 고유 식별자(ID)를 사용하여 조회합니다.

### Lv 2. 일정 수정 및 삭제 

- **선택한 일정 수정**
  - 선택한 일정 내용 중 `할일`, `작성자명` 만 수정 가능
    - 서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
    - `작성일` 은 변경할 수 없으며, `수정일` 은 수정 완료 시, 수정한 시점으로 변경합니다.
- **선택한 일정 삭제**
  - 선택한 일정을 삭제할 수 있습니다.
    - 서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.

## 📦 프로젝트 구조

src
    ├─main
    │  ├─generated
    │  ├─java
    │  │  └─com
    │  │      └─example
    │  │          └─schedule
    │  │              │  ScheduleApplication.java
    │  │              │
    │  │              ├─controller
    │  │              │      ScheduleController.java
    │  │              │
    │  │              ├─dto
    │  │              │      ScheduleRequestDto.java
    │  │              │      ScheduleResponseDto.java
    │  │              │
    │  │              ├─entity
    │  │              │      Schedule.java
    │  │              │
    │  │              ├─repository
    │  │              │      JdbcTemplateScheduleRepository.java
    │  │              │      ScheduleRepository.java
    │  │              │
    │  │              └─service
    │  │                      ScheduleService.java
    │  │                      ScheduleServiceImpl.java
    │  │
    │  └─resources
    │      │  application.properties
    │      │
    │      ├─static
    │      └─templates

