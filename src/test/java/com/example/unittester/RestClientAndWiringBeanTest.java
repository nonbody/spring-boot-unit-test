package com.example.unittester;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestClientAndWiringBeanTest extends UnittesterApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnPlaneNameByRequestParamAndIntegrateWing() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "F22 Raptor");
        String body = this.restTemplate.getForEntity("/plane?name={name}",String.class, params).getBody();
        Assert.assertEquals("Plane name is F22 Raptor and have Wings",body);
    }

}
