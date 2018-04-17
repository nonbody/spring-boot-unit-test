package com.example.unittester;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

public class MockBeanTest extends UnittesterApplicationTests {

    @MockBean
    private MonkeyImpl monkey;

    @Test
    public void shouldReturnTextFromMockBean() {
        given(monkey.name("yoyo")).willReturn("Baboo");
        Assert.assertEquals("Baboo", monkey.name("yoyo"));
    }


}
