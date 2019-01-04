package be.heh.petclinic.web;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class OwnerRestController {
        @Autowired
        private OwnerComponent OwnerComponent;

        @RequestMapping("ownerByName")
        public ResponseEntity<Owner> getOwnerByName(@RequestParam(value="name") String name){
            Owner own = OwnerComponent.getOwner(name);
            return own == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(own,HttpStatus.OK);
        }

        @RequestMapping("ownerLike")
        public ResponseEntity<List<Owner>> getOwnerLike(@RequestParam(value="name") String name){
            System.out.println("ok");
            List<Owner> own = OwnerComponent.getOwnerLike(name);
            return own == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(own,HttpStatus.OK);
        }

        @RequestMapping(value = "addOwner", method = RequestMethod.POST,consumes="application/json")
        public String addOwner(@RequestBody Owner owner) {
            if (owner != null) {
                OwnerComponent.addOwner(owner);
                return "true";
            } else
                return "false";
        }
}
