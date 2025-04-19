package com.example.rest.restcontroller;


import com.example.rest.entity.Book;
import com.example.rest.entity.BookPayloadDTO;
import com.example.rest.entity.BookViewDTO;
import com.example.rest.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api") //api가 붙은 요청은 이 컨트롤러로 매핑(연결)
@Tag(name ="Book Controller API", description = "책 관리 컨트롤러") //swagger 명세 설명 추가

public class BookRestController {
    //REST API -> GET: http://localhost:8081/api/test
//    @GetMapping("/test")
//    @Operation(summary = "User 조회", description = "User 정보를 조회합니다.")
//
//    public String test(){
//        return "Hello World"; //응답(json)
//    }
    @Autowired //서비스 클래스 객체 의존성 자동주입. 자료형인 BookService를 bean에서 등록되 있는 것 찾아서 주입.
    private BookService bookService;

    @PostMapping(value = "/books", consumes = "application/json", produces = "application/json")
    //클라이언트가 /books 로 post 방식으로 JSON 요청할 때. 이를 받을 때 사용.
    @ResponseStatus(HttpStatus.CREATED) //실제 HTTP 상태코드 설정 (201) 클라이언트가 요청이 정상적으로 처리되어 리소스가 생성됨을 명확히 알 수 있게 해줌.
    //예: POST 요청 → 새 책이 DB에 등록됨 → 201 Created 반환.

    //swagger 용 응답상태 설명용(기능이 아니라 명세서용)
    @ApiResponse(responseCode = "400", description = "Please add valid name a description")
    @ApiResponse(responseCode = "200", description = "Book added")
    @Operation(summary = "Add an Book")

    public ResponseEntity<BookViewDTO> addBook(@Valid @RequestBody BookPayloadDTO bookPayload) { // @RequestBody: 클라이언트가 보낸 JSON을 bookPayload 객체로 매핑(요청 JSON을 자바객체에 바인딩)
        //HTTP 상태 코드 + 응답 데이터를 함께 반환
        try {
            Book book = new Book(); //저장용 book 객체 생성.
            book.setSubject(bookPayload.getSubject()); //전달받은 DTO의 정보를 book 객체에 저장.
            book.setPrice(bookPayload.getPrice());
            book.setAuthor(bookPayload.getAuthor());
            book.setPage(bookPayload.getPage());
            book = bookService.save(book); //서비스 호출하여 book 정보 저장 수행.

            BookViewDTO bookViewDTO = new BookViewDTO //응답 전달할(보여줄) viewDTO 생성.(전달할 정보만 선별)
                    (book.getId(), book.getSubject(), book.getPrice(), book.getAuthor(), book.getPage(), book.getCreatedAt());
            return ResponseEntity.ok(bookViewDTO); // (200 + JSON 데이터). 클라이언트에게 HTTP "200 OK 상태 코드" + bookViewDTO 데이터를 "JSON" 형태로 응답.

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    //전체데이터 가져오기
    @GetMapping(value = "/books", produces = "application/json")
    @ApiResponse(responseCode = "200", description = "모든 책정보를 출력")
    @Operation(summary = "List of books")
    public List<BookViewDTO> books(){
        List<BookViewDTO> books = new ArrayList<>();
        for(Book book : bookService.findAll()){
            books.add(new BookViewDTO(book.getId(), book.getSubject(), book.getPrice(), book.getAuthor(),
                    book.getPage(), book.getCreatedAt()));
        }
        return books; // JSON Array :[{ },{ }…]
    }



    // 특정 데이터 가저오기 (전체 가져오기와 다른 메서드)
    @GetMapping(value = "/books/{id}", produces = "application/json")
    @ApiResponse(responseCode = "200", description = "id에 해당하는 책정보를 출력")
    @Operation(summary = "book id API")
    public ResponseEntity<?> findById (@PathVariable Long id) //응답 바디의 타입 모름, 상관없음의 ?
    { //@PathVariable은 REST API에서 URL 경로의 값(변수)을 메서드의 파라미터로 가져오는 어노테이션
        Optional<Book> optionalBook = bookService.findById(id);
        Book book;
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        } else { //일종의 예외처리.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        BookViewDTO bookViewDTO = new BookViewDTO(book.getId(), book.getSubject(), book.getPrice(),
                book.getAuthor(), book.getPage(), book.getCreatedAt());
        return ResponseEntity.ok(bookViewDTO);

        }

    //데이터 수정하기
    @PutMapping(value = "/books/{id}", consumes = "application/json",produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED )
    @ApiResponse(responseCode = "400", description = "Please add valid name a description")
    @ApiResponse(responseCode = "204", description = "Book updated")
    @Operation(summary = "Update an Book")
    public ResponseEntity<?> update_Book(@Valid @RequestBody BookPayloadDTO bookPayloadDTO,
                                         @PathVariable Long id){

        Optional<Book> optionalBook=bookService.findById(id);
        Book book;
        if(optionalBook.isPresent()){
            book=optionalBook.get();
        }else{
            return ResponseEntity.status (HttpStatus.BAD_REQUEST ).body(null);
        }
        // 수정할 데이터 교체
        book.setSubject(bookPayloadDTO.getSubject()); // 제목
        book.setPrice(bookPayloadDTO.getPrice()); // 가격
        book.setAuthor(bookPayloadDTO.getAuthor()); // 저자
        book.setPage(bookPayloadDTO.getPage()); //페이지
        book=bookService.save(book);

        //저장된 정보는 클라이언트 전달용 BookViewDTO 에 할당.
        BookViewDTO bookViewDTO=new BookViewDTO(book.getId(), book.getSubject(), book.getPrice(), book.getAuthor(),
                book.getPage(), book.getCreatedAt());
        return ResponseEntity.ok (bookViewDTO); //상태정보+JSON 데이터
    }

    //데이터 삭제하기
    @DeleteMapping(value = "/books/{id}")
    @ResponseStatus(HttpStatus.CREATED )
    @ApiResponse(responseCode = "202", description = "Book deleted")
    @Operation(summary = "Book delete")
    public ResponseEntity<?> delete_Book(@PathVariable Long id){
        Optional<Book> optionalBook = bookService.findById(id);
        Book book;
        if(optionalBook.isPresent()){
            book=optionalBook.get();
        }else{
            return ResponseEntity.status (HttpStatus.BAD_REQUEST ).body(null);
        }
        bookService.deleteBook(book);
        return ResponseEntity.status (HttpStatus.ACCEPTED ).body(null);
    }




    }


