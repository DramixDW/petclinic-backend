package be.heh.petclinic.component.visit;

import be.heh.petclinic.component.vet.VetRowMapper;
import be.heh.petclinic.domain.Visits;
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

public class JdbcVisitDao {
    private DataSource dataSource;
    public JdbcVisitDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Visits> fetchAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT name,type_id FROM pets", new VisitRowMapper());
    }

    public Visits get(Integer id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "SELECT name,type_id FROM pets WHERE id=?";

        List<Visits> res = template.query(query,new Object[] {id},new VisitRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public Visits get(String name) {
        String query = "SELECT name,type_id FROM pets WHERE name=?";
        JdbcTemplate select = new JdbcTemplate(dataSource);
        List<Visits> res = select.query(query,new Object[] {name},new VisitRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }
}
