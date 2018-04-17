package com.example.unittester;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ZooTest extends UnittesterApplicationTests {

    @Autowired
    MonkeyImpl monkey;

    @Test
    public void shouldMatch() {
        Assert.assertEquals("Monkey Yoyo have Wings",monkey.name("Yoyo"));
    }

}
