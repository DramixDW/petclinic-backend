package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRowMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet rs, int i) throws SQLException{
        Pet pet = new Pet();
        pet.setBirthDate(rs.getDate("birth_date"));
        pet.setId(rs.getInt("id"));
        pet.setOwner_firstName(rs.getString("first_name"));
        pet.setOwner_lastname(rs.getString("last_name"));
        pet.setName(rs.getString("name"));
        pet.setType(rs.getString("types.name"));
        return pet;
    }
}
