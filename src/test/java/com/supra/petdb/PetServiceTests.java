package com.supra.petdb;

import com.supra.petdb.repositories.IPetRepository;
import com.supra.petdb.services.PetService;
import javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class PetServiceTests {
    @Autowired
    private PetService petService;

    @Test
    void deletePet_shouldDeletePet() {
        Assertions.assertNotNull(petService.getPetById(1));
        petService.deletePetById(1);
        Assertions.assertNull(petService.getPetById(1));
    }
}
