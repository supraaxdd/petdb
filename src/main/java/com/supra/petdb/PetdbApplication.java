package com.supra.petdb;

import com.supra.petdb.services.HouseholdService;
import com.supra.petdb.services.PetService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PetdbApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PetdbApplication.class, args);
        PetService petService = context.getBean(PetService.class);
        HouseholdService householdService = context.getBean(HouseholdService.class);
    }
}
