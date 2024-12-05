package com.supra.petdb.controllers;

import com.supra.petdb.entities.Household;
import com.supra.petdb.entities.Pet;
import com.supra.petdb.services.HouseholdService;
import com.supra.petdb.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLAPI {
    @Autowired
    private PetService petService;

    @Autowired
    private HouseholdService householdService;

    @QueryMapping
    List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @QueryMapping
    List<Pet> getAllPetsByType(@Argument String type) {
        return petService.getPetsByType(type);
    }

    @QueryMapping
    Household getHouseholdByEircode(@Argument String eircode) {
        return householdService.getHouseholdByEircodeWithPets(eircode);
    }

    @QueryMapping
    Pet getPetById(@Argument int id) {
        return petService.getPetById(id);
    }

    @QueryMapping
    int getTotalPetCount() {
        return petService.getTotalPetCount();
    }

    @MutationMapping
    Household createHousehold(@Argument Household household) {
        return householdService.createHousehold(household);
    }

    @MutationMapping
    int deleteHouseholdByEircode(@Argument String eircode) {
        householdService.deleteHouseholdById(eircode);
        return 0;
    }

    @MutationMapping
    int deletePetById(@Argument int id) {
        petService.deletePetById(id);
        return 0;
    }
}
