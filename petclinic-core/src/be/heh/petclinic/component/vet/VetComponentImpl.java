package be.heh.petclinic.component.vet;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import javax.sql.DataSource;

import be.heh.petclinic.domain.*;

class VetComponentImpl implements VetComponent {

    private JdbcVetDao vetDao;
  
    public VetComponentImpl(DataSource dataSource){
        vetDao = new JdbcVetDao(dataSource);
    }

    @Override
    public Collection<Vet> getVets() {
        return vetDao.fetchAll();
    }

    @Override
    public Vet getVet(String lastName) {
        return vetDao.get(lastName);
    }

    @Override
    public Vet getVet(Integer id) {
        return vetDao.get(id);
    }


}