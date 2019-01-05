package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

public class OwnerComponentImpl implements OwnerComponent {

    private JdbcOwnerDao ownDao;

    public OwnerComponentImpl(DataSource datasource){
        ownDao = new JdbcOwnerDao(datasource);
    }

    @Override
    public Owner getOwner(String lastname){
        return ownDao.getBy("owners.last_name",lastname);
    }

    @Override
    public Collection<Owner> getOwnerLike(String lastName) {
        return ownDao.getWithPetsByName(lastName);
    }

    @Override
    public List<Owner> fetchAll() {
        return ownDao.fetchAll();
    }

    @Override
    public Boolean editOwner(Owner owner) {
        return ownDao.edit(owner);
    }

    @Override
    public Boolean addOwner(Owner owner) {
        return ownDao.add(owner);
    }
}
