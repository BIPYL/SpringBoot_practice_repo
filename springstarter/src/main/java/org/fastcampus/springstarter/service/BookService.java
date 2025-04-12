package org.fastcampus.springstarter.service;


import org.fastcampus.springstarter.entity.Book;
import org.fastcampus.springstarter.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor  //생성자 주입 방법(이 때는 final 붙여야 함)// 또는 // @Autowired 사용 가능.
public class BookService {
    @Autowired
    private BookRepository bookRepository;

//    //생성자 주입 방법(@AllArgsConstructor 어노테이션 쓰면 아래 내용 자동 생성해줌. 작성필요 X.
//    private final BookRepository bookRepository;
//    public BookService(BookRepository bookRepository){
//        this.bookRepository = bookRepository;
//
//    }
    //Optional 로 값 리턴 형식 지정.
    public Optional<Book> getById(Long id){
        return bookRepository.findById(id);
    }
        public List<Book> getAll(){
            return bookRepository.findAll();
        }
        public void delete(Book book){
            bookRepository.delete(book);
        }
        public void save(Book book){
            if(book.getId()==null){
                book.setCreatedAt(LocalDateTime.now ());
            }
            bookRepository.save(book);
        }
    }


