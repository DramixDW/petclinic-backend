package be.heh.petclinic.component.owner;

import be.heh.petclinic.component.pet.PetRowMapper;
import be.heh.petclinic.component.visit.VisitRowMapper;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.Visit;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JdbcOwnerDao {


    private DataSource datasource;

    public JdbcOwnerDao(DataSource dataSource){
        this.datasource = dataSource;
    }

    public List<Owner> fetchAll() {
        JdbcTemplate select = new JdbcTemplate(datasource);
        return select.query("SELECT last_name, first_name FROM owners", new OwnerRowMapper());
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

    public Collection<Owner> getWithPetsByName(String name) {
        String query = "SELECT * FROM owners " +
                "LEFT JOIN pets ON owners.id=pets.owner_id " +
                "INNER JOIN types ON type_id=types.id " +
                "WHERE owners.last_name LIKE ? OR pets.name LIKE ?";

        JdbcTemplate select = new JdbcTemplate(datasource);

        Collection<Owner> res = select.query(query, new Object[]{name + "%",name + "%"}, rs -> {
            HashMap<Integer,Owner> ownersMap = new HashMap<>();

            while(rs.next()) {
                Integer ownerID = rs.getInt("owners.id");

                if(!ownersMap.containsKey(ownerID))
                {
                    Owner newOwner = new OwnerRowMapper().mapRow(rs, -1);
                    newOwner.setPets(new ArrayList<>());
                    ownersMap.put(ownerID,newOwner);
                }

                Pet pet = new PetRowMapper().mapRow(rs,-1);
                if (pet != null) {
                    ownersMap.get(ownerID).addPet(pet);
                }
            }

            return ownersMap.values();
        });

        return res;
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
