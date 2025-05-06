package com.example.LeeDowon.FinalProject.entity;

import javax.smartcardio.Card;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.example.LeeDowon.FinalProject.controller.ReservationController.reservations;

public class ReservationDAO {
        private static int reservationCountr = 1;
        private int id;
        private String name;
        private UserDAO user;
        private CarDAO car;
        private LocalDate date;
        private LocalTime time;



        public ReservationDAO(String name, UserDAO user , CarDAO car, LocalDate date, LocalTime time) {
            this.id = reservationCountr++;
            this.name = name;
            this.user = user;
            this.car = car;
            this.date = date;
            this.time = time;
        }

        public ReservationDAO findById(int Id) {
            return reservations.stream()
                    .filter(r -> r.getId() == id)
                    .findFirst()
                    .orElse(null);}



        //Getter
        public long getId (){
            return id;
        }
        public String getName (){
            return name;
        }
        public UserDAO getUser(){
            return user;
        }
        public CarDAO getCar() {
            return car;
        }
        public LocalDate getDate(){
            return date;
        }
        public LocalTime getTime(){
            return time;
        }
    }
