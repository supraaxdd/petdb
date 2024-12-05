package com.supra.petdb.services;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;

import java.util.List;

public interface IPetService {
    void createPet(Pet pet);
    List<Pet> getAllPets();
    Pet getPetById(int id);
    void updatePet(int id, Pet pet);
    void updatePetName(int id, String petName);
    void deletePetById(int id);
    void deletePetByName(String name);
    List<Pet> getPetsByType(String type);
    List<Pet> getPetsByBreed(String breed);
    List<PetRecord> getPetRecords();
    int getTotalPetCount();
}
