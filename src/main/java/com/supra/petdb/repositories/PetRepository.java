package com.supra.petdb.repositories;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PetRepository implements IPetRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void createPet(Pet pet) {
        String sql = "INSERT INTO pets VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, pet);
    }

    @Override
    public List<Pet> getAllPets() {
        String sql = "SELECT * FROM pets";

        return List.of();
    }

    @Override
    public Pet getPetById(int id) {
        return null;
    }

    @Override
    public void updatePet(int id, Pet pet) {

    }

    @Override
    public void deletePetById(int id) {

    }

    @Override
    public void deletePetByName(String name) {

    }

    @Override
    public List<Pet> getPetsByType(String type) {
        return List.of();
    }

    @Override
    public List<Pet> getPetsByBreed(String breed) {
        return List.of();
    }

    @Override
    public List<PetRecord> getPetRecords() {
        return List.of();
    }

    @Override
    public int getAveragePetAge() {
        return 0;
    }

    @Override
    public int getTotalCount() {
        String sql = "SELECT COUNT(*) FROM pets";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        if (count == null) {
            return 0;
        }
        return count;
    }
}
