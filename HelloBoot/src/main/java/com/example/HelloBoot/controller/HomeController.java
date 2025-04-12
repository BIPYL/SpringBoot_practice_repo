package com.example.HelloBoot.controller;


import com.example.HelloBoot.entity.Member;
import com.example.HelloBoot.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "index";
    }
    @Autowired
    private HomeService homeService;

    @GetMapping("/memberList")
    public String memberList(Model model){  //뷰 이름을 반환하기 때문에 String 자료형 사용. memberlist의 반환객체를 받아 view에 전달하기 위한 model 객체(전달용) 파라미터.
        List<Member> memList = homeService.memberList();
        model.addAttribute("memList",memList);
        return "memberList"; // view page(InemberList.html)
}
}
