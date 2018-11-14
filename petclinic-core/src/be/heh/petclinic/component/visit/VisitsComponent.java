package be.heh.petclinic.component.visit;


import be.heh.petclinic.domain.Visits;

import java.util.List;

import java.util.Collection;

public interface VisitsComponent {
    Collection<Visits> getVisits();
    Visits getVisits(String petname);
    Visits getVisits(Integer type_id);

}
