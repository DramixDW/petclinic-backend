package be.heh.petclinic.component.visit;

import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;

import be.heh.petclinic.domain.Visit;
public class VisitRowMapper implements RowMapper<Visit>{
    @Override
    public Visit mapRow(ResultSet rs, int i) throws SQLException {
        Visit visit = new Visit();

        //check primary key , if it was NULL , return null
        visit.setId(rs.getInt("visits.id"));

        if (rs.wasNull())
            return null;

        visit.setDescription(rs.getString("visits.description"));
        visit.setPet_id(rs.getInt("visits.pet_id"));
        visit.setVisit_date(rs.getDate("visits.visit_date"));
        return visit;
    }
}
