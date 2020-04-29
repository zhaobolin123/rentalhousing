package com.rentalhousing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.rentalhousing.mapper")
@SpringBootApplication
public class RentalhousingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalhousingApplication.class, args);
    }

}
