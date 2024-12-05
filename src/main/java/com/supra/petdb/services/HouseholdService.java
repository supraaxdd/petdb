package com.supra.petdb.services;

import com.supra.petdb.entities.Household;
import com.supra.petdb.repositories.IHouseholdRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService implements IHouseholdService {
    @Autowired
    private IHouseholdRepository householdRepository;

    @Override
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Household getHouseholdByEircodeWithoutPets(String eircode) {
        return householdRepository.getHouseholdByEircode(eircode);
    }

    @Override
    public Household getHouseholdByEircodeWithPets(String eircode) {
        return householdRepository.getHouseholdByEircodeWithPets(eircode);
    }

    @Override
    public Household updateHouseholdDetails(String eircode, Household updatedHousehold) {
        Household existingHousehold = householdRepository.findById(eircode)
                .orElseThrow(() -> new EntityNotFoundException("Household not found with eircode: " + eircode));

        if (updatedHousehold.getMaxNumberOfOccupants() < existingHousehold.getNumberOfOccupants()) {
            throw new IllegalArgumentException("Max occupants cannot be less than current number of occupants");
        }

        existingHousehold.setMaxNumberOfOccupants(updatedHousehold.getMaxNumberOfOccupants());
        existingHousehold.setNumberOfOccupants(updatedHousehold.getNumberOfOccupants());
        existingHousehold.setOwnerOccupied(updatedHousehold.isOwnerOccupied());

        return householdRepository.save(existingHousehold);
    }

    @Override
    public void deleteHouseholdById(String eircode) {
        Household household = householdRepository.findById(eircode)
                .orElseThrow(() -> new EntityNotFoundException("Household not found with eircode: " + eircode));

        householdRepository.delete(household);
    }

    @Override
    public List<Household> getHouseholdsWithoutPets() {
        return householdRepository.getAllHouseholdsWithoutPets();
    }

    public List<Household> findOwnerOccupiedHouseholds() {
        return householdRepository.getOwnerOccupiedHouseholds();
    }

    public int countEmptyHouseholds() {
        return householdRepository.countEmptyHouseholds();
    }

    public int countFullHouseholds() {
        return householdRepository.countFullHouseholds();
    }
}
