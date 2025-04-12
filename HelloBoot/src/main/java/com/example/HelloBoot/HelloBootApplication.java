package com.example.HelloBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @(애노테이션) - 메타데이터, 전처리 동작(관련 만들어진 라이브러리들을 메모리에 로딩함)
@SpringBootApplication // MVC관련 API - FrontController, HandlerMapping, ViewResolver, POJO, Repository, Service
public class HelloBootApplication {
	// 여기서부터 프로그램이 동작~~
	public static void main(String[] args) {
		SpringApplication.run(HelloBootApplication.class, args);
	}
}
