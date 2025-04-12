package org.fastcampus.springstarter.controller;

import org.fastcampus.springstarter.entity.Book;
import org.fastcampus.springstarter.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StarterController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(Model model){
        List<Book> books = bookService.getAll();
        //books 값은 주소.
        model.addAttribute("books",books); //books 객체를 모델을 통해 바인딩(전달). 같은 주소값을 전달.
        return "home"; //home.html
    }




}
