package be.heh.petclinic.component.vet;

import be.heh.petclinic.domain.Vet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class VetRowMapper implements RowMapper<Vet> {
    @Override
    public Vet mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResultSetMetaData data = rs.getMetaData();
        return new Vet(rs.getString("last_name"),rs.getString("first_name"));
    }
}
