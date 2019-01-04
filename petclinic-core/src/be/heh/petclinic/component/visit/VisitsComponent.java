package be.heh.petclinic.component.visit;


import be.heh.petclinic.domain.Visit;

import java.util.Date;
import java.util.List;

import java.util.Collection;

public interface VisitsComponent {
    Collection<Visit> getVisits();
    Visit getVisits(Date visit_date);
    Visit getVisits(String description);
    List<Visit> getVisits(Integer pet_id);
}
