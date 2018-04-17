package com.example.unittester;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController {

    @GetMapping("/zoo")
    public String controller(@RequestParam("name") String name) {
        return "Zoo name is " + name;
    }

}
