package com.example.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/response")
    public ResponseEntity<String> customResponse() {
        String customMessage = "This is a custom response message.";
        return new ResponseEntity<>(customMessage, HttpStatus.OK);
    }

    @PostMapping("/submit")
    public String submitForm(@RequestBody String formData) {
        // Process the form data
        return "Received form data: " + formData;
    }

}
