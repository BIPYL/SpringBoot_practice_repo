package org.fastcampus.springstarter.config;

import org.fastcampus.springstarter.entity.Book;
import org.fastcampus.springstarter.entity.Review;
import org.fastcampus.springstarter.service.BookService;
import org.fastcampus.springstarter.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;


@Component
public class InitDataConfig implements CommandLineRunner{

    @Autowired
    private BookService bookService;
    @Autowired
    private ReviewService reviewService;

    @Override
    public void run(String... args) throws Exception {

        List<Book> books=bookService.getAll();
        if(books.isEmpty()){
            Book book1=new Book();
            book1.setSubject("자바");
            book1.setPrice(30000);
            book1.setAuthor("김길동");
            book1.setPage(600);
            bookService.save(book1); //insert sql

            // 여기 수정 필요!
            Book book2 = new Book(); // ← 객체 생성 빠졌었음
            book2.setSubject("파이썬");
            book2.setPrice(37000);
            book2.setAuthor("나길동");
            book2.setPage(800);
            bookService.save(book2); //insert sql

            //임의 리뷰 3개 생성
            Review review01 = new Review();
            review01.setContent("그림으로 이해하기 쉽게 해주세요");
            review01.setRating(4);
            review01.setCreatedAt(LocalDateTime.now());
            review01.setBook(book1); //책정보 입력
            reviewService.save(review01);

            Review review02 = new Review();
            review02.setContent("쉽게 설명해줘요.");
            review02.setRating(5);
            review02.setCreatedAt(LocalDateTime.now());
            review02.setBook(book2);
            reviewService.save(review02);

            Review review03 = new Review();
            review03.setContent("어려워요");
            review03.setRating(5);
            review03.setCreatedAt(LocalDateTime.now());
            review03.setBook(book2);
            reviewService.save(review03);




            }
        }
    }


