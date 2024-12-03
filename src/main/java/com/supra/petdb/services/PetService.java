package com.supra.petdb.services;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;
import com.supra.petdb.repositories.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Pet> result = petRepository.getPetById(id);
        if (result.isPresent()) return petRepository.getPetById(id).get();
        else throw new EntityNotFoundException("Pet not found");
    }

    @Override
    public int updatePet(int id, Pet pet) {
        int result = petRepository.updatePet(id, pet);
        if (result == 0) throw new EntityNotFoundException("Pet not found; therefore not updated");
        else return result;
    }

    @Override
    public int deletePetById(int id) {
        int result = petRepository.deletePetById(id);
        if (result == 0) throw new EntityNotFoundException("Pet not found; therefore not deleted");
        else return result;
    }

    @Override
    public int deletePetByName(String name) {
        int result = petRepository.deletePetByName(name);
        if (result == 0) throw new EntityNotFoundException("Pet not found; therefore not deleted");
        else return result;
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
