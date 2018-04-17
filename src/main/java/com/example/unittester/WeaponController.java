package com.example.unittester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeaponController {

    @Autowired
    WeaponRepo repo;

    @GetMapping("/weapon")
    public String id(@RequestParam("id") Long id) {
        return "Weapon is " + repo.getOne(id);
    }

    @GetMapping("/weapon/list")
    public String list() {
        StringBuilder sb = new StringBuilder("<br>");
        repo.findAll().forEach(item -> {
            sb.append(item.toString()+"<br>");
        });
        return "Weapon list " + sb.toString();
    }

}
