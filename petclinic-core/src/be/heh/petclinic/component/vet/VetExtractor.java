package be.heh.petclinic.component.vet;

import be.heh.petclinic.domain.Specialty;
import be.heh.petclinic.domain.Vet;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VetExtractor implements ResultSetExtractor<List<Vet>> {
    @Override
    public List<Vet> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Vet> map = new HashMap<>();
        Vet vet;

        while (rs.next()) {
            Integer id = rs.getInt("vets.id");
            vet = map.get(id);

            if(vet == null){
                vet = new Vet(rs.getString("vets.first_name"),rs.getString("vets.last_name"));
                map.put(id, vet);
            }


            vet.addSpecialty(new Specialty(rs.getString("specialties.name"),rs.getInt("specialties.id")));
        }
        return new ArrayList<>(map.values());
    }
}
