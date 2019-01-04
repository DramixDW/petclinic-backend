package be.heh.petclinic.component.owner;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import be.heh.petclinic.domain.Owner;

public class OwnerRowMapper  implements  RowMapper<Owner>{
        @Override
        public Owner mapRow(ResultSet rs, int i) throws SQLException {
            Owner own = new Owner();

            own.setId(rs.getInt("owners.id"));
            if (rs.wasNull())
                return null;

            own.setLastname(rs.getString("owners.last_name"));
            own.setFirstname(rs.getString("owners.first_name"));
            own.setTelephone(rs.getString("owners.telephone"));
            own.setAddres(rs.getString("owners.address"));
            own.setCity(rs.getString("owners.city"));
            return own;
        }

}
