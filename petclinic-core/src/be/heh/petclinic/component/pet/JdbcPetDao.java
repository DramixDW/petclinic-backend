package be.heh.petclinic.component.pet;

import be.heh.petclinic.component.pet.PetRowMapper;
import be.heh.petclinic.domain.Pet;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import java.io.Console;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

public class JdbcPetDao {

    public DataSource dataSource;

    public JdbcPetDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Pet> fetchAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT pets.id ,pets.name, pets.birth_date, types.name, CONCAT(owners.first_name, \" \", owners.last_name) AS owner from pets INNER JOIN types ON type_id=types.id INNER JOIN owners ON owner_id=owners.id",new PetRowMapper());
    }

    public Pet get(String name) {
        String query = "SELECT type from types UNION SELECT name FROM pets WHERE name=?";
        JdbcTemplate select = new JdbcTemplate(dataSource);
        List<Pet> res = select.query(query, new Object[]{name}, new PetRowMapper());

        if (res.isEmpty()) {
            return null;
        } else {
            return res.get(0);
        }
    }

    public Boolean add(Pet pet)
    {
        String query = "INSERT INTO pets (name,birth_date,type_id,owner_id) VALUES (?,?,?,?)";
        JdbcTemplate add = new JdbcTemplate(dataSource);
        return add.execute(query, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setString(1,pet.getName());
            ps.setDate(2,pet.getBirthDate());
            ps.setInt(3,pet.getTypeId());
            ps.setInt(4,pet.getOwner_id());
            return ps.execute();
        });
    }

    public Boolean edit(Pet pet)
    {
        String query = "UPDATE pets SET name = ?,birth_date = ?,type_id = ?,owner_id = ? WHERE id= ?";
        JdbcTemplate add = new JdbcTemplate(dataSource);
        return add.execute(query, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setString(1,pet.getName());
            ps.setDate(2,pet.getBirthDate());
            ps.setInt(3,pet.getTypeId());
            ps.setInt(4,pet.getOwner_id());
            ps.setInt(5,pet.getId());
            return ps.execute();
        });
    }

    public Pet getPetById(Integer pet_id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query =
                "SELECT pets.name, pets.id , pets.birth_date, types.name, CONCAT(owners.first_name, \" \", owners.last_name) AS owner FROM pets " +
                "INNER JOIN types ON type_id=types.id " +
                "INNER JOIN owners ON owner_id=owners.id " +
                "WHERE pets.id=?";

        List<Pet> res = template.query(query,new Object[] {pet_id},new PetRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }

    public Pet getPets(String name) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "SELECT name FROM pets UNION SELECT name from types WHERE name=?";

        List<Pet> res = template.query(query,new Object[] {name},new PetRowMapper());

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }
}

