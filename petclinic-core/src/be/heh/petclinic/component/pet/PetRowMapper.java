package be.heh.petclinic.component.pet;

import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;

import be.heh.petclinic.domain.Pet;

public class PetRowMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet rs,int i) throws SQLException {
        Pet pet = new Pet();

        pet.setId(rs.getInt("pets.id"));
        if (rs.wasNull())
            return null;

        pet.setName(rs.getString("pets.name"));
        pet.setBirthDate(rs.getDate("pets.birth_date"));
        pet.setTypeId(rs.getInt("pets.type_id"));
        pet.setOwner_id(rs.getInt("pets.owner_id"));
        pet.setTypeName(rs.getString("types.name"));
        return pet;
    }
}
