package be.heh.petclinic.web;

import be.heh.petclinic.component.visit.VisitsComponent; //////
import be.heh.petclinic.component.visit.VisitsComponentlmpl;
import be.heh.petclinic.domain.Vet;
import be.heh.petclinic.domain.Visits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/visits/")
public class VisitsRestController {
    @Autowired
    private VisitsComponent visitsComponentlmpl;

    @RequestMapping("visits")
    public ResponseEntity<Collection<Visits>> getVisits() {
        Collection<Visits> visits = visitsComponentlmpl.getVisits();
        return visits.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(visits, HttpStatus.OK);
    }

    @RequestMapping("visit")
    public ResponseEntity<List<Visits>> getVisits(@RequestParam(value="pet_id")Integer pet_id){
        List<Visits> visits = visitsComponentlmpl.getVisits(pet_id);
        return visits == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(visits,HttpStatus.OK);
    }
}
