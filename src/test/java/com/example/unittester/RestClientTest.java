package com.example.unittester;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestClientTest extends UnittesterApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnZooNameByRequestParam() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "KhaoKheaw Chonburi");
        String body = this.restTemplate.getForEntity("/zoo?name={name}",String.class, params).getBody();
        Assert.assertEquals("Zoo name is KhaoKheaw Chonburi",body);
    }

}
