package com.example.unittester;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class WeaponEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String weaponName;
    private int ammo;

    public WeaponEntity() {
    }

    public WeaponEntity(Long id, String weaponName, int ammo) {
        this.id = id;
        this.weaponName = weaponName;
        this.ammo = ammo;
    }

    public WeaponEntity(String weaponName, int ammo) {
        this.weaponName = weaponName;
        this.ammo = ammo;
    }
}
