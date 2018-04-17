package com.example.unittester;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

public class WiringBeanTest extends UnittesterApplicationTests {

    @Autowired
    private MonkeyImpl monkey;

    @MockBean
    private WingImpl wing;

    @Test
    public void wingShouldReturnNullBecauseMockBeanInitToNull() {
        Assert.assertEquals("Monkey Arnold null", monkey.name("Arnold"));
    }

    @Test
    public void wingShouldReturnTextFromMockBean() {
        given(wing.wing()).willReturn("have Bigest Wings");
        Assert.assertEquals("Monkey Arnold have Bigest Wings", monkey.name("Arnold"));
    }

}
