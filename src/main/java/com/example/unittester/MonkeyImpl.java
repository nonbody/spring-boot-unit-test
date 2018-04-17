package com.example.unittester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonkeyImpl {

    @Autowired
    WingImpl wing;

    public String name(String name) {
        return "Monkey " + name + " " + wing.wing();
    }
}
