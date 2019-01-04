package be.heh.petclinic.component.Owner;

import be.heh.petclinic.domain.Owner;
import javax.sql.DataSource;

public class OwnerComponentImpl implements OwnerComponent {

    private JdbcOwnerDao ownDao;


    public OwnerComponentImpl(DataSource datasource){
        ownDao = new JdbcOwnerDao(datasource);
    }

    @Override
    public Owner getOwner(String lastname){
        return ownDao.get(lastname);
    }
}
