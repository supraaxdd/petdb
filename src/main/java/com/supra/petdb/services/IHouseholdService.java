package com.supra.petdb.services;

import com.supra.petdb.entities.Household;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHouseholdService {
    public Household createHousehold(Household household);
    public List<Household> getAllHouseholds();
    public Household getHouseholdByEircodeWithoutPets(String eircode);
    public Household getHouseholdByEircodeWithPets(String eircode);
    public Household updateHouseholdDetails(String eircode, Household updatedHousehold);
    public void deleteHouseholdById(String eircode);
    public List<Household> getHouseholdsWithoutPets();


}
