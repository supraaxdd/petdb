package com.supra.petdb;

import com.supra.petdb.services.PetService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetdbApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PetdbApplication.class, args);
        PetService petService = context.getBean(PetService.class);
        System.out.println(petService.getTotalPetCount());
    }

}
