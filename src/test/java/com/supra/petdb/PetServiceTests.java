package com.supra.petdb;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.repositories.IPetRepository;
import com.supra.petdb.services.PetService;
import javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class PetServiceTests {
    @Autowired
    private PetService petService;

    @Test
    void createPet_shouldCreatePet() {
        // Arrange: Create a pet object
        Pet pet = new Pet(0, "test", "test", "test", 2, null); // ID will be auto-generated

        // Act: Create the pet in the database
        petService.createPet(pet);

        // Assert: Check if the pet was created
        Pet retrievedPet = petService.getPetById(pet.getId());
        Assertions.assertNotNull(retrievedPet);
    }

    @Test
    void getAllPets_shouldReturnAllPets() {
        int count = petService.getTotalPetCount();
        Assertions.assertEquals(count, petService.getAllPets().size());
    }

    @Test
    void getPetById_shouldReturnNullIfPetDoesNotExist() {
        Assertions.assertNull(petService.getPetById(999999));
    }

    @Test
    void updatePet_shouldUpdatePet() {
        Pet pet = new Pet(999999, "test", "test", "test", 2, null);
        petService.createPet(pet);

        Pet updatedPet = new Pet(999999, "test2", "test2", "test2", 2, null);
        petService.updatePet(pet.getId(), updatedPet);

        Assertions.assertNotEquals(updatedPet, petService.getPetById(999999));
    }

    @Test
    void deletePet_shouldDeletePet() {
        Assertions.assertNotNull(petService.getPetById(1));
        petService.deletePetById(1);
        Assertions.assertNull(petService.getPetById(1));
    }

}
