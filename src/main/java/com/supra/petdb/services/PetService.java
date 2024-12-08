package com.supra.petdb.services;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;
import com.supra.petdb.repositories.IPetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetService implements IPetService {
    private IPetRepository petRepository;

    @Override
    public void createPet(Pet pet) {
        // TODO: ENFORCE DATA INTEGRITY
        petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(int id) {
        Optional<Pet> result = petRepository.findById(id);
        if (result.isPresent()) return petRepository.findById(id).get();
        else throw new EntityNotFoundException("Pet not found");
    }

    @Override
    public void updatePet(int id, Pet pet) {
        Pet existingPet = petRepository.findById(id).get();

        existingPet.setName(pet.getName());
        existingPet.setAnimalType(pet.getAnimalType());
        existingPet.setBreed(pet.getBreed());
        existingPet.setAge(pet.getAge());
        existingPet.setHousehold(pet.getHousehold());

        petRepository.save(existingPet);
    }

    @Override
    public void updatePetName(int id, String name) {
        Pet existingPet = petRepository.findById(id).get();

        existingPet.setName(name);
        petRepository.save(existingPet);
    }

    @Override
    public void deletePetById(int id) {
        petRepository.deleteById(id);
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
