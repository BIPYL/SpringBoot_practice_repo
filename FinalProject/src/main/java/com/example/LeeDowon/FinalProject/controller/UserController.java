package com.example.LeeDowon.FinalProject.controller;

import com.example.LeeDowon.FinalProject.entity.CarDAO;
import com.example.LeeDowon.FinalProject.entity.UserDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    public static List<UserDAO> users = new ArrayList<>();

    //유저 등록
    @PostMapping()
    public ResponseEntity<UserDAO> postUser(@RequestParam String name, @RequestParam String email){
        if (users.size() >= 10) {
            System.out.println("유저는 최대 10명까지 등록할 수 있습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        UserDAO user = new UserDAO(name, email);
        users.add(user); //cars 배열에 car 객체 저장.
        return ResponseEntity.ok(user);
    }
    // 유저 전체조회
    @GetMapping
    public ResponseEntity<List<UserDAO>> getAllUsers() {
        if (users.isEmpty()){
            System.out.println("유저가 없습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(users);
    }

    //유저 업데이트
    @PostMapping("/update")
    public ResponseEntity<UserDAO> updateUser(@RequestParam int id, @RequestParam String name,@RequestParam String email) {
        UserDAO user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if (user == null) {
            System.out.println("업데이트 대상 유저가 존재하지 않습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        user.update(name, email); //정보 업데이트
        return ResponseEntity.ok(user);
    }
}


