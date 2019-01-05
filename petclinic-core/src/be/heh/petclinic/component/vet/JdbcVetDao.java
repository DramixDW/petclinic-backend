package be.heh.petclinic.component.vet;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import be.heh.petclinic.domain.Vet;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

public class JdbcVetDao {
    private DataSource dataSource;

    public JdbcVetDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Collection<Vet> fetchAll() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template.query("SELECT * FROM vets " +
                "LEFT JOIN vet_specialties ON vet_specialties.vet_id=vets.id " +
                "LEFT JOIN specialties ON vet_specialties.specialty_id=specialties.id",new VetExtractor());
    }
}

