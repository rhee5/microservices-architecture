package com.fenics.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class HolidayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidayDemoApplication.class, args);
	}

}
