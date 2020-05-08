package com.rentalhousing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.rentalhousing.mapper")
@SpringBootApplication
public class RentalhousingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RentalhousingApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RentalhousingApplication.class);
    }
}
