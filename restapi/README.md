# 📘 Spring Boot Book REST API 

📌 소개
이 프로젝트는 Spring Boot 기반으로 도서(Book) 정보를 REST API 형식으로 CRUD 처리하는 실습용 애플리케이션입니다.
Swagger를 통한 API 명세 문서 자동화, DTO를 활용한 계층 분리, 예외처리 및 상태 코드 반환까지 포함되어 있습니다.

---

✅ 주요 기능

- 도서 등록 (POST)
- 도서 목록 조회 (GET)
- 도서 단건 조회 (GET)
- 도서 수정 (PUT)
- 도서 삭제 (DELETE)

---

🏗️ 기술 스택

- Java 17
- Spring Boot 3.4.4
- Lombok
- Spring Validation (`@Valid`)
- Swagger (springdoc-openapi)
- Gradle

---

📁 프로젝트 구조
src/main/java/com/example/rest
├── entity          # Book, DTO 클래스들
├── repository      # BookRepository
├── service         # BookService
├── restcontroller  # REST API Controller
└── RestApplication # 메인 실행 클래스


🧠 학습 포인트
ResponseEntity 를 통해 응답 코드 + JSON 데이터 처리
DTO 계층 설계 (Payload, View 구분)
Optional과 조건 분기 로직
RESTful URL 설계
Swagger 문서 자동화 적용

📌 향후 보완할 점
전역 예외 처리 핸들러 추가
H2 or MySQL DB 연결 테스트
테스트 코드 (JUnit, MockMvc) 작성
ResponseEntity에 통일된 응답 포맷 적용 (ApiResponse<T> 등)

요약: Spring REST API의 핵심 개념 구현, 실무에 필요한 계층 구조 설계, JSON 요청/응답 처리 방식, 예외 처리 흐름 등을 학습한 결과물입니다.
Swagger 적용으로 외부 사용자를 위한 문서화까지 완료.
