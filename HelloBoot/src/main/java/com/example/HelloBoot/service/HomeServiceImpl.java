package com.example.HelloBoot.service;


import com.example.HelloBoot.entity.Member;
import com.example.HelloBoot.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository; //DI; @Repository로 Bean에 등록된 Homerepository객체를 repository 객체변수에 의존성 주입.
    @Override
    public List<Member> memberList() {
        return homeRepository.findAll();
    }
}
