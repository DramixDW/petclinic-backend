package be.heh.petclinic.component.vet;

import be.heh.petclinic.domain.Vet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class VetRowMapper implements RowMapper<Vet> {
    @Override
    public Vet mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vet vet = new Vet();
        vet.setLastname(rs.getString("vets.last_name"));
        vet.setFirstname(rs.getString("vets.first_name"));
        vet.setId(rs.getInt("vets.id"));
        return vet;
    }
}
