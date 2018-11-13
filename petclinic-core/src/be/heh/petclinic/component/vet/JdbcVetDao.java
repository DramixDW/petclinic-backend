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

    private DataSource dataSource;

    public JdbcVetDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Vet> fetchAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT last_name, first_name FROM vets", new VetRowMapper());
    }

    public Vet get(Integer id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "SELECT last_name,first_name FROM vets WHERE id=?";

        List<Vet> res = template.query(query,new Object[] {id},new VetRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public Vet get(String last_name) {
        String query = "SELECT last_name,first_name FROM vets WHERE last_name=?";
        JdbcTemplate select = new JdbcTemplate(dataSource);
        List<Vet> res = select.query(query,new Object[] {last_name},new VetRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

}

