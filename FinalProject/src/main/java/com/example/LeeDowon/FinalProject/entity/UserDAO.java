package com.example.LeeDowon.FinalProject.entity;

public class UserDAO {
    private static int userCounter = 1;
    private int id;
    private String name;
    private String email;


    public UserDAO(String name, String email) {
        this.id = userCounter++;
        if(name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("유저이름은 필수이며, 공백일 수 없습니다.");
        }
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("유저 이메일은 필수이며, 공백일 수 없습니다.");
        }

        this.name =name;
        this.email = email;
    }


    //Setter 없음.
//    public void setName(String name) {
//        if (!name.isEmpty() & !name.trim().isEmpty()) {
//            this.name = name;
//        }
//    }
//    public void setEmail(String email) {
//        if (!name.isEmpty() & !name.trim().isEmpty()) {
//            this.name = name;
//        }
    //Getter
    public long getId(){
        return id;
    }
    public String getName (){
        return name;
    }
    public String getEmail (){
        return email;
    }

    public void update(String name, String email) {
        if(name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("유저이름은 필수이며, 공백일 수 없습니다.");
        }
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("유저 이메일은 필수이며, 공백일 수 없습니다.");
        }

        this.name =name;
        this.email = email;
    }
}

