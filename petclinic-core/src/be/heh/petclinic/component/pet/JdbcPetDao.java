package be.heh.petclinic.component.pet;

import be.heh.petclinic.component.owner.OwnerRowMapper;
import be.heh.petclinic.component.pet.PetRowMapper;
import be.heh.petclinic.component.visit.VisitRowMapper;
import be.heh.petclinic.domain.Pet;
import be.heh.petclinic.domain.Visit;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.io.Console;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

public class JdbcPetDao {

    public DataSource dataSource;

    public JdbcPetDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Pet> fetchAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(
                "SELECT * from pets INNER JOIN types ON type_id=types.id",
                new PetRowMapper()
        );
    }

    public Collection<Pet> getWithVisitsBy(String whereField,Object fieldValue) {
        String query = "SELECT * FROM pets " +
                "LEFT JOIN visits ON pet_id=pets.id " +
                "LEFT JOIN types ON type_id=types.id WHERE " + whereField + " = ?";

        JdbcTemplate select = new JdbcTemplate(dataSource);

        Collection<Pet> res = select.query(query, new Object[]{fieldValue}, rs -> {
            HashMap<Integer,Pet> petMap = new HashMap<>();

            while(rs.next()) {
                Integer petID = rs.getInt("pets.id");

                if(!petMap.containsKey(petID))
                {
                    Pet newPet = new PetRowMapper().mapRow(rs, -1);
                    newPet.setVisits(new ArrayList<>());
                    petMap.put(petID,newPet);
                }

                rs.getInt("visits.id");
                if (!rs.wasNull()) {
                    Visit visit = new VisitRowMapper().mapRow(rs,-1);
                    petMap.get(petID).addVisit(visit);
                }
            }

            return petMap.values();
        });

        return res;
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
            return ps.executeUpdate() != 0;
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
            return ps.executeUpdate() != 0;
        });
    }

    public Pet getPetById(Integer pet_id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query =
                "SELECT * FROM pets " +
                "INNER JOIN types ON type_id=types.id " +
                "WHERE pets.id=?";

        List<Pet> res = template.query(query, new Object[]{pet_id}, new RowMapper<Pet>() {
            @Override
            public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
                Pet pet = new PetRowMapper().mapRow(rs,rowNum);
                return pet;
            }
        });

        if (res.isEmpty()) {
            return null;
        }else{
            return res.get(0);
        }
    }
}

