package be.heh.petclinic.web;

import be.heh.petclinic.component.visit.VisitsComponent; //////
import be.heh.petclinic.domain.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class VisitsRestController {
    @Autowired
    private VisitsComponent visitsComponentlmpl;

    @RequestMapping("getVisits")
    public ResponseEntity<Collection<Visit>> getVisits() {
        Collection<Visit> visits = visitsComponentlmpl.getVisits();
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

    @RequestMapping("getVisitByPetId")
    public ResponseEntity<List<Visit>> getVisits(@RequestParam(value="pet_id")Integer pet_id){
        List<Visit> visits = visitsComponentlmpl.getVisits(pet_id);
        return new ResponseEntity<>(visits,HttpStatus.OK);
    }

    @RequestMapping(value = "addVisit", method = RequestMethod.POST,consumes="application/json")
    public Boolean addOwner(@RequestBody Visit visit) {
        if (visit != null)
            return visitsComponentlmpl.addVisit(visit);
        else
            return false;
    }
}
