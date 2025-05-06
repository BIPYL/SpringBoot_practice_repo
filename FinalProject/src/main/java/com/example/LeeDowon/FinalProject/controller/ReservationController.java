package com.example.LeeDowon.FinalProject.controller;


import com.example.LeeDowon.FinalProject.entity.CarDAO;
import com.example.LeeDowon.FinalProject.entity.ReservationDAO;
import com.example.LeeDowon.FinalProject.entity.UserDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.LeeDowon.FinalProject.controller.CarController.cars;
import static com.example.LeeDowon.FinalProject.controller.UserController.users;
import static java.util.spi.ToolProvider.findFirst;


@RestController
@RequestMapping("/reservations")
public class ReservationController {
    public static List<ReservationDAO> reservations = new ArrayList<>();

    //예약 등록
    @PostMapping()
    public ResponseEntity<ReservationDAO> postRsv(@RequestParam String name, @RequestParam int userId,
                                                  @RequestParam int carId, @RequestParam String date,
                                                  @RequestParam String time) {

        UserDAO user = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
        CarDAO car = cars.stream().filter(c -> c.getId() == carId).findFirst().orElse(null);

        if (reservations.size() >= 10) {
            System.out.println("예약은 최대 10개까지 등록할 수 있습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        if (user == null) {
            System.out.println("유저 ID가 존재하지 않습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        if (car == null) {
            System.out.println("차량 ID가 존재하지 않습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        LocalDate reservationDate = LocalDate.parse(date);
        LocalTime reservationTime = LocalTime.parse(time);

        ReservationDAO rsv = new ReservationDAO(name, user, car, reservationDate, reservationTime);
        reservations.add(rsv); //cars 배열에 car 객체 저장.
        return ResponseEntity.ok(rsv);
    }

    // 예약 전체조회
    @GetMapping
    public ResponseEntity<List<ReservationDAO>> getAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("예약이 없습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(reservations);
    }

    //단일 예약 조회
    @GetMapping("/single")
    public ResponseEntity<?> getSingleRsv(@RequestParam int id) {
        ReservationDAO rsv =
                reservations.stream()
                .filter(r-> r.getId() ==id) //순회하면서 id가 일치하는 reservation 객체 탐색.
                .findFirst()
                .orElse(null);

        if(rsv==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("예약 ID가 존재하지 않습니다.");
        }
        return ResponseEntity.ok(rsv);


    }
}
