package com.example.unittester;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepo extends JpaRepository<WeaponEntity,Long> {
}
