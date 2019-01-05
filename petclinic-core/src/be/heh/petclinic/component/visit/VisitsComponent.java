package be.heh.petclinic.component.visit;


import be.heh.petclinic.domain.Visit;

import java.util.Date;
import java.util.List;

import java.util.Collection;

public interface VisitsComponent {
    Collection<Visit> getVisits();
    List<Visit> getVisits(Integer pet_id);
    Boolean addVisit(Visit visit);
}
