package com.supra.petdb.services;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;
import com.supra.petdb.repositories.PetRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class PetService implements IPetService {
    private PetRepository petRepository;

    @Override
    public void createPet(Pet pet) {
        petRepository.createPet(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.getAllPets();
    }

    @Override
    public Pet getPetById(int id) {
        return petRepository.getPetById(id).isPresent() ? petRepository.getPetById(id).get() : null;
    }

    @Override
    public int updatePet(int id, Pet pet) {
        return petRepository.updatePet(id, pet);
    }

    @Override
    public void deletePetById(int id) {
        petRepository.deletePetById(id);
    }

    @Override
    public void deletePetByName(String name) {
        petRepository.deletePetByName(name);
    }

    @Override
    public List<Pet> getPetsByType(String type) {
        return petRepository.getPetsByType(type);
    }

    @Override
    public List<Pet> getPetsByBreed(String breed) {
        return petRepository.getPetsByBreed(breed);
    }

    @Override
    public List<PetRecord> getPetRecords() {
        return petRepository.getPetRecords();
    }

    @Override
    public int getTotalPetCount() {
        return petRepository.getTotalCount();
    }
}
