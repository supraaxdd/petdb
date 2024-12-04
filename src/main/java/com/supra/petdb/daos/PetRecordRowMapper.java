package com.supra.petdb.daos;

import com.supra.petdb.entities.PetRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRecordRowMapper implements RowMapper<PetRecord> {

    @Override
    public PetRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PetRecord(
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
        );
    }
}
