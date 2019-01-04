package be.heh.petclinic.component.visit;

import be.heh.petclinic.domain.Visit;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class JdbcVisitDao {


    private DataSource dataSource;
    public JdbcVisitDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

   public List<Visit> fetchAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT pet_id,visit_date,description FROM visits", new VisitRowMapper());
    }

    public Visit get(Date visit_date) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "SELECT visit_date,description FROM visits WHERE visit_date=?";

        List<Visit> res = template.query(query,new Object[] {visit_date},new VisitRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public Visit get(String description) {
        String query = "SELECT visit_date,description FROM visits WHERE description=?";
        JdbcTemplate select = new JdbcTemplate(dataSource);
        List<Visit> res = select.query(query,new Object[] {description},new VisitRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public List<Visit> get(int pet_id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "SELECT pet_id,visit_date,description FROM visits WHERE pet_id=?";

        List<Visit> res = template.query(query,new Object[] {pet_id},new VisitRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res;
        }
    }




}
