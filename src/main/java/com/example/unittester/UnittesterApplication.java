package com.example.unittester;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UnittesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnittesterApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(WeaponRepo repo) {
		return (args) -> {

			repo.save(new WeaponEntity("SCAR-L", 30));
			repo.save(new WeaponEntity("M16", 30));
			repo.save(new WeaponEntity("KAR98K", 5));

			repo.findAll().forEach( item -> {
				System.out.println("reccord : " + item.toString());
			});

		};
	}

}
