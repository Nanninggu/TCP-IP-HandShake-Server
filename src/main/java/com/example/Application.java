package com.example;

import com.example.TCP.IP_HandShake_Check_Server.Implement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Implement.main(args);
        System.exit(0);
    }

}
