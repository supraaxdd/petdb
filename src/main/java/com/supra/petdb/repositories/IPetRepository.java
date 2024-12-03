package com.supra.petdb.repositories;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;

import java.util.List;
import java.util.Optional;

public interface IPetRepository {
    public Pet createPet(Pet pet);
    public List<Pet> getAllPets();
    public Optional<Pet> getPetById(int id);
    public int updatePet(int id, Pet pet);
    public void deletePetById(int id);
    public void deletePetByName(String name);
    public List<Pet> getPetsByType(String type);
    public List<Pet> getPetsByBreed(String breed);
    public List<PetRecord> getPetRecords();
    public int getAveragePetAge();
    public int getTotalCount();
}
