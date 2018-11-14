package be.heh.petclinic.web;

import be.heh.petclinic.component.Owner.OwnerComponent;
import be.heh.petclinic.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class OwnerRestController {
        @Autowired
        private OwnerComponent OwnerComponent;
        @RequestMapping("owner")
        public ResponseEntity<Owner> getVet(@RequestParam(value="name") String name){
            Owner own = OwnerComponent.getOwner(name);
            return own == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(own,HttpStatus.OK);
        }
}
