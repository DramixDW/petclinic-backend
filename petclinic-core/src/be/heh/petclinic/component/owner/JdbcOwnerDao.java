package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public Owner getBy(String whereField,Object fieldValue) {
        String query = "SELECT * FROM owners WHERE " + whereField + " = ?";
        JdbcTemplate select = new JdbcTemplate(datasource);
        List<Owner> res = select.query(query,new Object[] {fieldValue},new OwnerRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public Boolean add(Owner owner)
    {
        String query = "INSERT INTO owners (first_name,last_name,address,city,telephone) VALUES (?,?,?,?,?)";
        JdbcTemplate add = new JdbcTemplate(datasource);
        return add.execute(query, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setString(1,owner.getFirstname());
            ps.setString(2,owner.getLastname());
            ps.setString(3,owner.getAddres());
            ps.setString(4,owner.getCity());
            ps.setString(5,owner.getTelephone());
            return ps.executeUpdate() != 0;
        });
    }

    public Boolean edit(Owner owner)
    {
        String query = "UPDATE owners SET first_name = ?,last_name = ?,address = ?,city = ?,telephone = ? WHERE id= ?";
        JdbcTemplate edit = new JdbcTemplate(datasource);
        return edit.execute(query, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setString(1,owner.getFirstname());
            ps.setString(2,owner.getLastname());
            ps.setString(3,owner.getAddres());
            ps.setString(4,owner.getCity());
            ps.setString(5,owner.getTelephone());
            ps.setInt(6,owner.getId());
            return ps.executeUpdate() != 0;
        });
    }
}
