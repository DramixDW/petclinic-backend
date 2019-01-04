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
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class JdbcVisitDao {


    private DataSource dataSource;
    public JdbcVisitDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

   public List<Visits> fetchAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT pet_id,visit_date,description FROM visits", new VisitRowMapper());
    }

    public Visits get(Date visit_date) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "SELECT visit_date,description FROM visits WHERE visit_date=?";

        List<Visits> res = template.query(query,new Object[] {visit_date},new VisitRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public Visits get(String description) {
        String query = "SELECT visit_date,description FROM visits WHERE description=?";
        JdbcTemplate select = new JdbcTemplate(dataSource);
        List<Visits> res = select.query(query,new Object[] {description},new VisitRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public List<Visits> get(int pet_id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "SELECT pet_id,visit_date,description FROM visits WHERE pet_id=?";

        List<Visits> res = template.query(query,new Object[] {pet_id},new VisitRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res;
        }
    }




}
