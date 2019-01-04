package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;

import java.util.List;

public interface OwnerComponent {
        Owner getOwner(String lastName);
        List<Owner> getOwnerLike(String lastName);
        List<Owner> fetchAll();
        Boolean editOwner(Owner owner);
        Boolean addOwner(Owner owner);
}
