package ee.karl.homework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping("hello")
    protected String helloWorld() {
        return "Hello World!";
    }
}
