package be.heh.petclinic.component.visit;

import be.heh.petclinic.domain.Visit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;


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
        return select.query("SELECT * FROM visits", new VisitRowMapper());
    }

    public List<Visit> get(Integer pet_id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "SELECT * FROM visits WHERE visits.pet_id=?";

        List<Visit> res = template.query(query,new Object[] {pet_id},new VisitRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res;
        }
    }

    public Boolean add(Visit visit)
    {
        String query = "INSERT INTO visits (pet_id,visit_date,description) VALUES (?,?,?)";
        JdbcTemplate add = new JdbcTemplate(dataSource);
        return add.execute(query, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setInt(1,visit.getpet_id());
            ps.setDate(2,visit.getVisit_date());
            ps.setString(3,visit.getDescription());
            return ps.executeUpdate() != 0;
        });
    }
}
