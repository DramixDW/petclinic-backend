package be.heh.petclinic.component.visit;

import be.heh.petclinic.domain.Vet;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;

import be.heh.petclinic.domain.Visits;
public class VisitRowMapper implements RowMapper<Visits>{
    @Override
    public Visits mapRow(ResultSet rs, int i) throws SQLException {
        Visits visits = new Visits();
        visits.setVisit_date(rs.getDate("visit_date"));
        visits.setDescription(rs.getString("description"));
       visits.setPet_id(rs.getInt("pet_id"));
        return visits;
    }
}
