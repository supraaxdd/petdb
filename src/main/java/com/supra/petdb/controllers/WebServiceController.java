package com.supra.petdb.controllers;

import com.supra.petdb.entities.Household;
import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;
import com.supra.petdb.services.HouseholdService;
import com.supra.petdb.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class WebServiceController {

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private PetService petService;

    @GetMapping("/getallpets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/getallhouseholds")
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("/gethouseholdswithoutpets")
    public List<Household> getHouseholdsWithoutPets() {
        return householdService.getHouseholdsWithoutPets();
    }

    @GetMapping("/getpetbyid/{id}")
    public Pet getPet(@PathVariable("id") int id) {
        return petService.getPetById(id);
    }

    @GetMapping("/getpetsbytype/{type}")
    public List<Pet> getPetByType(@PathVariable("type") String type) {
        return petService.getPetsByType(type);
    }

    @GetMapping("/getpetsbybreed/{breed}")
    public List<Pet> getPetByBreed(@PathVariable("breed") String breed) {
        return petService.getPetsByBreed(breed);
    }

    @GetMapping("/getpetrecords/")
    public List<PetRecord> getPetRecords() {
        return petService.getPetRecords();
    }

    @GetMapping("/gettotalpetcount")
    public int getPetStats() {
        return petService.getTotalPetCount();
    }

    @GetMapping("/getemptyhouseholds")
    public int getEmptyHouseholds() {
        return householdService.countEmptyHouseholds();
    }

    @GetMapping("/getfullhouseholds")
    public int getFullHouseholds() {
        return householdService.countFullHouseholds();
    }

    @DeleteMapping("/deletepetbyid/{id}")
    public void deletePet(@PathVariable("id") int id) {
        petService.deletePetById(id);
    }

    @DeleteMapping("/deletepetbyname/{name}")
    public void deletePetByName(@PathVariable("name") String name) {
        petService.deletePetByName(name);
    }

    @DeleteMapping("/deletehousehold/{id}")
    public void deleteHousehold(@PathVariable("id") String id) {
        householdService.deleteHouseholdById(id);
    }

    @PostMapping("/createhousehold")
    public void createHousehold(@RequestBody @Valid Household household) {
        householdService.createHousehold(household);
    }

    @PostMapping("/createpet")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPet(@RequestBody Pet pet) {
        petService.createPet(pet);
    }

    @PatchMapping("/changepetname/{id}")
    public void changePetName(@PathVariable("id") int id, @RequestBody String name) {
        Pet existingPet = petService.getPetById(id);
        existingPet.setName(name);

        petService.updatePet(id, existingPet);
    }

    @PatchMapping("/changepetdetails/{id}")
    public void changePetDetails(@PathVariable("id") int id, @RequestBody @Valid Pet pet) {
        petService.updatePet(id, pet);
    }
}
