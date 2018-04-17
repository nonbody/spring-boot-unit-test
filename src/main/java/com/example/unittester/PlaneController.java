package com.example.unittester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaneController {

    @Autowired
    private WingImpl wing;

    @GetMapping("/plane")
    public String controller(@RequestParam("name") String name) {
        return "Plane name is " + name + " and " + wing.wing();
    }

}
