package org.fastcampus.springstarter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.fastcampus.springstarter.service.BookService;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor //JPA 리플렉션: 리플렉션이란?
//클래스 정보를 런타임에 읽고, 생성자나 필드에 직접 접근해서 객체를 조작할 수 있게 해주는 자바의 기능.
// 📌 이때 기본 생성자가 없으면, 리플렉션으로 객체를 만들 수 없어요.
//왜냐면 JPA 는 생성자에 어떤 값을 넣어줄지 모르니까, 파라미터가 없는 생성자를 요구하는 거예요.@NoArgsConstructor를 써서 기본 생성자를 만들어줌.

public class Review { //create table review~ SQL

    @Id//pk 지정.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 자동증가 컬럼으로 설정.
    private Long id; //리뷰 일련번호, 1,2,3,4,(자동증가 pk)
    private String content;//리뷰내용
    private int rating; //평점(1~5)
    private LocalDateTime createdAt; //작성일자

    //객체 지향의 정보 은닉(Encapsulation) 원칙을 따르기 위해 private 로 선언합니다.
    //외부에서 직접 접근하지 못하게 막고, 대신 Lombok 의 @Getter, @Setter 로 필요한 접근만 허용


    //테이블 연결 설정
    @ManyToOne //테이블 관계 설정: 앞의 many(N)은 현재 엔터티 기준(Review엔터티), toOne은 대상 엔터티(Book)
    @JoinColumn(name="book_id",referencedColumnName = "id", nullable = false) //FK 생성. //아래 book의 id 컬럼을 참조하여 book_id로 컬럼 생성.
    private Book book;



}
