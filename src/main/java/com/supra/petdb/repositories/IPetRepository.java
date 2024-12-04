package com.supra.petdb.repositories;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPetRepository extends JpaRepository<Pet, Integer> {
    @Modifying
    @Query("DELETE FROM Pet p WHERE LOWER(p.name) = LOWER(:name)")
    public int deletePetByName(@Param("name") String name);

    public List<Pet> getPetsByType(String type);
    public List<Pet> getPetsByBreed(String breed);
    public List<PetRecord> getPetRecords();
    public int getAveragePetAge();
    public int getTotalCount();
}
