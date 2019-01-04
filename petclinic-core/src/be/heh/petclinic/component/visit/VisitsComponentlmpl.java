package be.heh.petclinic.component.visit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collection;

import javax.sql.DataSource;

import be.heh.petclinic.component.vet.JdbcVetDao;
import be.heh.petclinic.component.vet.VetComponent;
import be.heh.petclinic.domain.*;
public class VisitsComponentlmpl implements VisitsComponent {

    private JdbcVisitDao visitDao;

    public VisitsComponentlmpl(DataSource dataSource){ visitDao = new JdbcVisitDao(dataSource); }

    @Override
    public Collection<Visits> getVisits() {
        return visitDao.fetchAll();
    }

    @Override
    public Visits getVisits(Date visit_date) {
        return visitDao.get(visit_date);
    }

    @Override
    public Visits getVisits(String description) {
        return visitDao.get(description);
    }

   @Override
    public List<Visits> getVisits(Integer pet_id) {
        return visitDao.get(pet_id);
    }

}
