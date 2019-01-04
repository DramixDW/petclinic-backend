package be.heh.petclinic.component.visit;

import java.util.Date;
import java.util.List;
import java.util.Collection;

import javax.sql.DataSource;

import be.heh.petclinic.domain.*;
public class VisitsComponentlmpl implements VisitsComponent {

    private JdbcVisitDao visitDao;

    public VisitsComponentlmpl(DataSource dataSource){ visitDao = new JdbcVisitDao(dataSource); }

    @Override
    public Collection<Visit> getVisits() {
        return visitDao.fetchAll();
    }

    @Override
    public Visit getVisits(Date visit_date) {
        return visitDao.get(visit_date);
    }

    @Override
    public Visit getVisits(String description) {
        return visitDao.get(description);
    }

   @Override
    public List<Visit> getVisits(Integer pet_id) {
        return visitDao.get(pet_id);
    }

}
