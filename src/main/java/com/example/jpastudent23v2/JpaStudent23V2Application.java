package com.example.jpastudent23v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.LogLevel;

@SpringBootApplication
public class JpaStudent23V2Application {

    public static final Logger logger = LoggerFactory.getLogger(
            JpaStudent23V2Application.class
    );



    public static void main(String[] args) {
        SpringApplication.run(JpaStudent23V2Application.class, args);
        logger.info("vi er started");

    }

}
