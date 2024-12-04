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
    int deletePetByName(@Param("name") String name);

    @Query("SELECT p FROM Pet p WHERE p.animalType = :type")
    List<Pet> getPetsByType(@Param("type") String type);

    @Query("SELECT p FROM Pet p WHERE p.breed = :breed")
    List<Pet> getPetsByBreed(@Param("breed") String breed);

    @Query("SELECT new com.supra.petdb.entities.PetRecord(p.name, p.animalType, p.breed) FROM Pet p")
    List<PetRecord> getPetRecords();

    @Query("SELECT AVG(p.age) FROM Pet p")
    int getAveragePetAge();

    @Query("SELECT COUNT(*) FROM Pet p")
    int getTotalCount();
}
