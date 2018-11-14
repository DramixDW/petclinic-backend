package be.heh.domain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import be.heh.petclinic.component.Owner.OwnerComponentImpl;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.*;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class OwnerTests {
    /*
  @Test
  public void test_Owner_request(){
      DataSource dataSource
      OwnerComponentImpl ownImp = new OwnerComponentImpl(dataSource);
      Owner own = ownImp.getOwner("Harold");
      assertEquals("Harold",own.getFirstname());

  }
  */
}
