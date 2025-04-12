package com.example.HelloBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import javax.annotation.processing.Generated;

@Entity // -> table // **"자바 클래스가 어떻게 DB 테이블이 되는지"** 이
//@Entity 는 이 클래스가 JPA 에서 관리되는 **"엔티티(=DB 테이블 매핑 객체)"**임을 나타내는 어노테이션입니다.
//        즉, 이 어노테이션을 붙이면 자바 클래스가 DB 테이블과 1:1로 연결됩니다. SQL 없이도 알아서 데이터를 저장하고 조회할 수 있게 해줍니다.
//@Entity 는 "이 자바 클래스는 테이블처럼 DB에 저장할 객체야!" 라고 JPA에 알려주는 표시입니다.

@Data //@Data = @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
public class Member{
    @Id //PK: primary key 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id, auto increment 설정.
    private Long id;
    private String username;
    private String password;
    private String name;
    private String role;
}

//
//🧰 Lombok이란?
//
//Lombok은 자바에서 **보일러플레이트 코드(반복되는 코드)**를 자동으로 줄여주는 라이브러리입니다.
//        💡 쉽게 말하면?
//getter, setter, toString(), equals(), hashCode() 같은 반복 코드 자동 생성
//개발자가 직접 코딩 안 해도 어노테이션 하나로 자동 처리됨
//        코드 간결해지고, 생산성/가독성 향상
//
//@Data = @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
//
//✅ 적용 예시:
//        import lombok.Data;
//
//@Data
//public class User {
//    private String username;
//    private String email;
//}
//위처럼 작성하면 자동으로 아래와 같은 코드가 생긴 것처럼 동작해요
//
//📦 정리 한 줄 요약
//
//@Data는 자바 객체의 필수 메서드들을 자동으로 만들어주는 Lombok의 종합 어노테이션!
//실무에선 편리하지만 남용은 금물, 특히 JPA에서는 부분 어노테이션 조합 사용 권장.