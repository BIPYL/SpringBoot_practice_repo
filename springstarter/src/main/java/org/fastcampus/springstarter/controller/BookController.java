package org.fastcampus.springstarter.controller;

import org.fastcampus.springstarter.entity.Book;
import org.fastcampus.springstarter.entity.Review;
import org.fastcampus.springstarter.service.BookService;
import org.fastcampus.springstarter.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "home"; //home.html
    }

    @GetMapping("/detail/{id}")
    public String getDetails(@PathVariable Long id, Model model) { //요청 매핑 파라미터의 id를 읽어 가져옴.
        Optional<Book> bookOptional = bookService.getById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get(); //review 데이터도 포함되어 있다! 데이터 있으면 get()으로 데이터를 가져와서 Book 자료형에 객체 저장.
            model.addAttribute("book", book); // 데이터 저장된 book 객체를 model 에 바인딩하여 전달.

            // 평균 평점을 계산하여 모델에 추가
            double averageRating = book.getReviews().stream()
                    .mapToInt(Review::getRating)
                    .average()
                    .orElse(0.0);
            String formattedAverageRating = String.format ("%.1f", averageRating);
            model.addAttribute("averageRating", formattedAverageRating);



            return "detail"; //detail.html 상세보기 페이지. ${book}으로 html 에서 읽으면 됨.
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/register")
    public String reviewRegister(@RequestParam("book_id") Long book_id, Review review) {
        Book book = bookService.getById(book_id).orElseThrow(() -> new IllegalArgumentException("invalid book id" + book_id));
        review.setBook(book);
        review.setCreatedAt(LocalDateTime.now());
        reviewService.save(review); //리뷰 등록(저장)


        return "redirect:/detail/"+book.getId();
    }


    @PostMapping("/deleteReview")
    public String deleteReview(Long review_id, Long book_id){
        reviewService.deleteReviewById(review_id); // 삭제성공
        return "redirect:/detail/"+book_id;
    }
}

