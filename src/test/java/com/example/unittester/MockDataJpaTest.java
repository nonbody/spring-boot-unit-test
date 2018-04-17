package com.example.unittester;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

@DataJpaTest
public class MockDataJpaTest extends UnittesterApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WeaponRepo repo;

    @Test
    public void shouldRetrurnListMockupDataInH2Database() throws Exception {
        this.entityManager.persist(new WeaponEntity("Mini14", 20));
        this.entityManager.persist(new WeaponEntity("AKB", 30));
        repo.findAll().forEach(item -> {
            System.out.println("unit test data : " + item.toString());
        });
    }

}
