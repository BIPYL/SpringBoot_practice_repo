package com.example.LeeDowon.FinalProject.controller;


import com.example.LeeDowon.FinalProject.entity.CarDAO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    public static List<CarDAO> cars = new ArrayList<>();

    //자동차 등록
    @PostMapping
    public ResponseEntity<CarDAO> addCar(@RequestParam String name, @RequestParam double price,
                                         @RequestParam String owner, @RequestParam int year) {
        if (cars.size() >= 5) {
            System.out.println("차량은 최대 5대까지 등록할 수 있습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        CarDAO car = new CarDAO(name, price, owner, year);
        cars.add(car); //cars 배열에 car 객체 저장.
        return ResponseEntity.ok(car);
    }
    // 자동차 전체 조회
    @GetMapping
    public ResponseEntity<List<CarDAO>> getAllCars() {
        if (cars.isEmpty()){
            System.out.println("차량이 없습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(cars);

    }

    //마지막으로 등록된 자동차 조회
    @GetMapping("/last")
    public ResponseEntity<CarDAO> getLastCar(){
        if(cars.isEmpty()){
            System.out.println("차량이 없습니다.");
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(cars.get(cars.size()-1)); //마지막 데이터
    }
}


