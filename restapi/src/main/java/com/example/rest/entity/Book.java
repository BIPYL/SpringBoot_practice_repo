package com.example.rest.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private int price;
    private String author;
    private int page;
    private LocalDateTime createdAt;

    @PrePersist //JPA 에서 엔티티가 저장되기 "직전"에 자동으로 실행되는 메서드에 붙이는 어노테이션입니다.→ 실무에서 생성일 자동 저장, 초기값 세팅 등에 자주 써요.
    public void onCreate(){
        this.createdAt = LocalDateTime.now();

    }
}
