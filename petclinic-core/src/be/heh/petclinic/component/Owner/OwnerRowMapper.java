package be.heh.petclinic.component.Owner;

import be.heh.petclinic.domain.Vet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import be.heh.petclinic.domain.Owner;

public class OwnerRowMapper  implements  RowMapper<Owner>{
        @Override
        public Owner mapRow(ResultSet rs, int i) throws SQLException {
            Owner own = new Owner();
            own.setLastname(rs.getString("last_name"));
            own.setFirstname(rs.getString("first_name"));
            own.setTelephone(rs.getString("telephone"));
            own.setAddres(rs.getString("address"));
            own.setCity(rs.getString("city"));
            own.setId(rs.getInt("id"));
            return own;
        }

}
