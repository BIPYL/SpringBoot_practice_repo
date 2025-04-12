package org.fastcampus.springstarter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    private @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String subject;
    private int price;
    private String author;
    private int page;
    private LocalDateTime createdAt;

}