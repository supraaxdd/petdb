package com.supra.petdb.services;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;

import java.util.List;

public interface IPetService {
    public void createPet(Pet pet);
    public List<Pet> getAllPets();
    public Pet getPetById(int id);
    public int updatePet(int id, Pet pet);
    public int deletePetById(int id);
    public int deletePetByName(String name);
    public List<Pet> getPetsByType(String type);
    public List<Pet> getPetsByBreed(String breed);
    public List<PetRecord> getPetRecords();
    public int getTotalPetCount();
}
