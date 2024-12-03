package com.supra.petdb.repositories;

import com.supra.petdb.entities.Pet;
import com.supra.petdb.entities.PetRecord;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PetRepository implements IPetRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public Pet createPet(Pet pet) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("pets")
                .usingGeneratedKeyColumns("id");

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", pet.getName());
        params.addValue("animalType", pet.getAnimalType());
        params.addValue("breed", pet.getBreed());
        params.addValue("age", pet.getAge());

        int pk = simpleJdbcInsert.executeAndReturnKey(params).intValue();
        pet.setId(pk);
        return pet;
    }

    @Override
    public List<Pet> getAllPets() {
        String sql = "SELECT * FROM pets";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pet.class));
    }

    @Override
    public Optional<Pet> getPetById(int id) {
        String sql = "SELECT * FROM pets WHERE id = ?";

        try {
            Pet pet = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Pet.class), id);
            return Optional.of(pet);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public int updatePet(int id, Pet pet) {
        String sql = "UPDATE pets SET name = ?, animal_type = ?, breed = ?, age = ? WHERE id = ?";

        return jdbcTemplate.update(sql,
                pet.getName(),
                pet.getAnimalType(),
                pet.getBreed(),
                pet.getAge(),
                id);
    }

    @Override
    public int deletePetById(int id) {
        String sql = "DELETE FROM pets WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Pet> getPetsByType(String type) {
        String sql = "SELECT * FROM pets WHERE animalType = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pet.class), type);
    }

    @Override
    public List<Pet> getPetsByBreed(String breed) {
        String sql = "SELECT * FROM pets WHERE breed = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pet.class), breed);
    }

    @Override
    public List<PetRecord> getPetRecords() {
        String sql = "SELECT * FROM pets";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PetRecord.class));
    }

    @Override
    public int getAveragePetAge() {
        String sql = "SELECT AVG(age) FROM pets";
        return jdbcTemplate.queryForObject(sql, Integer.class);
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
