package be.heh.petclinic.component.vet;

import be.heh.petclinic.domain.Specialty;
import be.heh.petclinic.domain.Vet;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class VetExtractor implements ResultSetExtractor<Collection<Vet>> {
    @Override
    public Collection<Vet> extractData(ResultSet rs) throws SQLException, DataAccessException {
        HashMap<Integer,Vet> vetsMap = new HashMap<>();

        while(rs.next()) {
            Integer vetId = rs.getInt("vets.id");

            if(!vetsMap.containsKey(vetId))
            {
                Vet newVet = new VetRowMapper().mapRow(rs, -1);
                newVet.setSpecialties(new ArrayList<>());
                vetsMap.put(vetId,newVet);
            }

            Integer specId = rs.getInt("specialties.id");
            if (!rs.wasNull()) {
                Specialty spec = new Specialty(rs.getString("specialties.name"),specId);
                vetsMap.get(vetId).addSpecialty(spec);
            }
        }

        return vetsMap.values();
    }
}
