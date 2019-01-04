package be.heh.petclinic.component.pet;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import be.heh.petclinic.component.pet.JdbcPetDao;
import be.heh.petclinic.domain.*;

public class PetComponentImpl implements PetComponent {

    private JdbcPetDao petDao;

    public PetComponentImpl(DataSource dataSource){ petDao = new JdbcPetDao(dataSource); }

    @Override
    public Collection<Pet> getPets() {
        return petDao.fetchAll();
    }

    @Override
    public Pet getPetWithVisits(String name) {
        return petDao.getWithVisitsBy("pets.name",name);
    }
    @Override
    public Pet getPetWithVisits(Integer pet_id) {
        return petDao.getWithVisitsBy("pets.id",pet_id);
    }
    @Override
    public Pet getPetWithVisitsByOwnerId(Integer owner_id) { return petDao.getWithVisitsBy("pets.owner_id",owner_id); }

    @Override
    public Pet getPetById(Integer pet_id) {
        return petDao.getPetById(pet_id);
    }

    @Override
    public Boolean editPet(Pet pet) {
        return petDao.edit(pet);
    }

    @Override
    public Boolean addPet(Pet pet) {
        return petDao.add(pet);
    }
}
