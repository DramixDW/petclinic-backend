package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import javax.sql.DataSource;
import java.util.List;

public class OwnerComponentImpl implements OwnerComponent {

    private JdbcOwnerDao ownDao;

    public OwnerComponentImpl(DataSource datasource){
        ownDao = new JdbcOwnerDao(datasource);
    }

    @Override
    public Owner getOwner(String lastname){
        return ownDao.get(lastname);
    }

    @Override
    public List<Owner> getOwnerLike(String lastName) {
        return ownDao.getLike(lastName);
    }

    @Override
    public List<Owner> fetchAll() {
        return ownDao.fetchAll();
    }

    @Override
    public void addOwner(Owner owner) {
        ownDao.add(owner);
    }
}
