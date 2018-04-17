package com.example.unittester;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestClientAndWiringAndMockBeanTest extends UnittesterApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private WingImpl wing;

    @Test
    public void shouldReturnPlaneNameByRequestParamAndWingIsNullBecauseMockBeanInitToNull() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "F22 Raptor");
        String body = this.restTemplate.getForEntity("/plane?name={name}",String.class, params).getBody();
        Assert.assertEquals("Plane name is F22 Raptor and null",body);
    }

    @Test
    public void shouldReturnPlaneNameByRequestParamAndIntegrateBigestWingFromMockBean() {
        given(wing.wing()).willReturn("have Bigest Wings");
        Map<String, String> params = new HashMap<>();
        params.put("name", "F22 Raptor");
        String body = this.restTemplate.getForEntity("/plane?name={name}",String.class, params).getBody();
        Assert.assertEquals("Plane name is F22 Raptor and have Bigest Wings",body);
    }

}
