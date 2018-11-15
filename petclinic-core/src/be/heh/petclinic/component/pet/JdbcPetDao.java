package be.heh.petclinic.component.pet;
import org.springframework.jdbc.core.JdbcTemplate;
import be.heh.petclinic.domain.Pet;
import javax.sql.DataSource;
import java.util.List;

public class JdbcPetDao {
    DataSource datasource;
    public JdbcPetDao(DataSource datasource){ this.datasource = datasource; }

    public Pet get(String name) {
        String query = "SELECT * FROM owners WHERE last_name=?";
        JdbcTemplate select = new JdbcTemplate(datasource);
        List<Pet> res = select.query(query,new Object[] {name},new PetRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

}
