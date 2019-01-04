package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

public class JdbcOwnerDao {


    private DataSource datasource;

    public JdbcOwnerDao(DataSource dataSource){
        this.datasource = dataSource;
    }

    public List<Owner> fetchAll() {
        JdbcTemplate select = new JdbcTemplate(datasource);
        return select.query("SELECT last_name, first_name FROM owners", new OwnerRowMapper());
    }

    public List<Owner> getLike(String last_name) {
        String query = "SELECT * FROM owners WHERE last_name LIKE ?";
        JdbcTemplate select = new JdbcTemplate(datasource);

        return select.query(query,new Object[] {last_name + "%"},new OwnerRowMapper());
    }

    public Owner get(String last_name) {
        String query = "SELECT * FROM owners WHERE last_name=?";
        JdbcTemplate select = new JdbcTemplate(datasource);
        List<Owner> res = select.query(query,new Object[] {last_name},new OwnerRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public void add(Owner owner)
    {
        String query = "INSERT INTO owners (first_name,last_name,address,city,telephone) VALUES (?,?,?,?,?)";
        JdbcTemplate add = new JdbcTemplate(datasource);
        add.update(query, owner.getFirstname(),owner.getLastname(),owner.getAddres(),owner.getCity(),owner.getTelephone());
    }
}
