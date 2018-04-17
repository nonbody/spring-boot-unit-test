package com.example.unittester;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockDataJpaAndRestClientTest extends UnittesterApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    WeaponRepo repo;

    @Test
    public void shouldReturnWeaponMockBean() {
        when(repo.getOne(7L)).thenReturn(new WeaponEntity(7L,"Bomb",1));
        Map<String, Object> params = new HashMap<>();
        params.put("id", 7);
        String body = this.restTemplate.getForEntity("/weapon?id={id}", String.class, params).getBody();
        Assert.assertEquals("Weapon is WeaponEntity(id=7, weaponName=Bomb, ammo=1)", body);
    }

    @Test
    public void shouldReturnWeaponMockBeanList() {
        List<WeaponEntity> mockList = new ArrayList<>();
        mockList.add(new WeaponEntity(7L,"Bomb",1));
        mockList.add(new WeaponEntity(8L,"Flash",2));
        mockList.add(new WeaponEntity(9L,"Smoke",3));
        when(repo.findAll()).thenReturn(mockList);
        String body = this.restTemplate.getForEntity("/weapon/list", String.class).getBody();
        Assert.assertEquals("Weapon list <br>WeaponEntity(id=7, weaponName=Bomb, ammo=1)<br>WeaponEntity(id=8, weaponName=Flash, ammo=2)<br>WeaponEntity(id=9, weaponName=Smoke, ammo=3)<br>", body);
    }

}

