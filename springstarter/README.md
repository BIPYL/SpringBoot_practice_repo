# Spring Starter 실습 프로젝트1 

📚 **주제**: 도서 정보 관리 시스템 (Spring Boot 기반)

## 🔧 프로젝트 개요
- Spring Boot 기반의 웹 애플리케이션 실습 프로젝트입니다.
- 계층 구조(MVC 패턴)를 기반으로 Entity, Repository, Service, Controller의 흐름을 이해하고 구현합니다.
- 도서 정보를 입력, 저장, 조회하는 기능을 포함합니다.
- H2 인메모리 데이터베이스를 활용하여 테스트 환경을 구성했습니다.

## 🧩 프로젝트 구성

### 1. 프로젝트 구조
```
main
├── java
│   └── org.fastcampus.springstarter
│       ├── config                - 초기 데이터 설정 클래스
│       ├── controller            - 웹 요청 처리 (예: /home)
│       ├── entity                - Book 엔티티
│       ├── repository            - JPA 리포지토리 인터페이스
│       ├── service               - 비즈니스 로직 처리
│       └── SpringStarterApplication - 메인 클래스
├── resources
│   ├── static
│   ├── templates
│   │   ├── fragments            - 공통 레이아웃 (header, footer 등)
│   │   └── home.html            - 도서 정보 화면 출력
│   └── application.properties  - 설정 파일 (포트, DB 등)
└── test
```

### 2. 주요 기능
- `/home` 페이지에서 도서 리스트 출력
- `BookService`를 통해 도서 저장, 삭제, 조회 기능 구현
- `InitDataConfig`를 통해 초기 도서 데이터 자동 삽입
- Thymeleaf를 사용한 동적 HTML 렌더링
- H2 데이터베이스 활용 (application.properties에서 설정)
- 기본 포트: 8081

✍️ 이해한 내용 요약
- 의존성 주입(DI): `@Autowired`를 통해 서비스나 리포지토리를 자동 주입받음
- 계층형 아키텍처: Controller → Service → Repository → Entity 흐름으로 유지보수가 쉬운 구조 설계
- HTML 출력 연동: 컨트롤러에서 모델에 데이터를 담아 HTML로 전달
- 초기 데이터 삽입: `CommandLineRunner`를 구현한 클래스에서 빈 상태 시 초기 데이터 세팅
- 테스트용 DB 환경 구성: 빠른 테스트를 위해 H2 사용

💡 학습 포인트
- Spring Boot 전반 구조에 대한 이해
- 의존성 관리 및 Gradle 기반 빌드 설정 경험
- 웹 요청 흐름 (Request → Controller → Service → Repository → DB → 응답 → View 렌더링)
- 실무에서 사용되는 Thymeleaf 템플릿 엔진 사용법
- JPA를 사용한 간단한 CRUD 흐름 구현 경험
- @Autowired, 생성자 주입, @Service, @Repository, @Controller 등 주요 스프링 어노테이션의 역할 이해

📌 InitDataConfig 클래스: 초기 데이터 자동 삽입

이 프로젝트에서는 InitDataConfig 클래스를 통해 애플리케이션 실행 시 도서 데이터를 자동으로 DB에 삽입하는 기능을 구현했습니다.
✅ 핵심 개념
CommandLineRunner 인터페이스를 구현하면 스프링 부트가 애플리케이션 실행 직후 자동으로 run() 메서드를 실행합니다.
@Component 혹은 설정 클래스에서 구현하면 별도 호출 없이도 동작합니다.
이 구조를 활용해 초기 데이터 세팅, 테스트용 데이터 입력 등을 자동화할 수 있습니다.


🚀 실행 방법
1. 프로젝트 클론 후 IntelliJ에서 열기
2. `SpringStarterApplication` 실행
3. [http://localhost:8081/home](http://localhost:8081/home) 접속하여 도서 정보 확인

✅ 사용 기술
- JAVA 17
- Spring Boot
- Spring Web / Data JPA
- Thymeleaf(템플릿 엔진)
- H2 Database(인메모리 DB)
- Gradle(빌드 도구)

---
이 프로젝트는 Spring의 기본적인 구조를 직접 구현하며 전반적인 흐름을 이해하는 데 목적이 있습니다.

