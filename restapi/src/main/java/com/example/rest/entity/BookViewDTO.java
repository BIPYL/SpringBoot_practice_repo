package com.example.rest.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NotBlank
public class BookViewDTO {
    private Long id;
    private String subject;
    private int price;
    private String author;
    private int page;
    private LocalDateTime createdAt;

}