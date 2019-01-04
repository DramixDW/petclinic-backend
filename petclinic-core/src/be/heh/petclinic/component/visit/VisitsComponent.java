package be.heh.petclinic.component.visit;


import be.heh.petclinic.domain.Visits;

import java.util.Date;
import java.util.List;

import java.util.Collection;

public interface VisitsComponent {
    Collection<Visits> getVisits();
    Visits getVisits(Date visit_date);
    Visits getVisits(String description);
    List<Visits> getVisits(Integer pet_id);

}
