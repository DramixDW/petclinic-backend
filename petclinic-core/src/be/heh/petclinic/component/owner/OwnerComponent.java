package be.heh.petclinic.component.Owner;

import be.heh.petclinic.domain.Owner;

import java.util.Collection;

public interface OwnerComponent {
        Owner getOwner(String lastName);
}
