package be.heh.petclinic.component.vet;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import be.heh.petclinic.domain.Vet;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

public class JdbcVetDao {
    private static final String baseSpecialtiesQuery = "SELECT * FROM vets JOIN vet_specialties ON vet_specialties.vet_id=vets.id JOIN specialties ON vet_specialties.specialty_id=specialties.id";
    private static final String baseQuery = "SELECT * FROM vets";
    private DataSource dataSource;

    public JdbcVetDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Vet> fetchAll(Boolean withSpecialties) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query((withSpecialties) ? baseSpecialtiesQuery : baseQuery, new VetExtractor());
    }

    public Vet get(Integer id,Boolean withSpecialties) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = ((withSpecialties) ? baseSpecialtiesQuery : baseQuery) + " WHERE vets.id=?";

        List<Vet> res = (withSpecialties) ?
                template.query(query,new Object[] {id},new VetExtractor()) :
                template.query(query,new Object[] {id},new VetRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public Vet get(String last_name,Boolean withSpecialties) {
        String query = ((withSpecialties) ? baseSpecialtiesQuery : baseQuery) + " WHERE last_name=?";

        JdbcTemplate template = new JdbcTemplate(dataSource);

        List<Vet> res = (withSpecialties) ?
                template.query(query,new Object[] {last_name},new VetExtractor()) :
                template.query(query,new Object[] {last_name},new VetRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }
}

