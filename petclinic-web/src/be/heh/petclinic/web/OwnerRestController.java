package be.heh.petclinic.web;

import be.heh.petclinic.component.owner.OwnerComponent;
import be.heh.petclinic.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class OwnerRestController {
    @Autowired
    private OwnerComponent OwnerComponent;

    @RequestMapping("getOwnerByName")
    public ResponseEntity<Owner> getOwnerByName(@RequestParam(value="name") String name){
        Owner own = OwnerComponent.getOwner(name);
        return own == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(own,HttpStatus.OK);
    }

    @RequestMapping("getOwnerById")
    public ResponseEntity<Owner> getOwnerById(@RequestParam(value="id") Integer id){
        Owner own = OwnerComponent.getOwner(id);
        return own == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(own,HttpStatus.OK);
    }

    @RequestMapping("getOwnerByNameLike")
    public ResponseEntity<Collection<Owner>> getOwnerLike(@RequestParam(value="name") String name){
        Collection<Owner> own = OwnerComponent.getOwnerLike(name);
        return new ResponseEntity<>(own,HttpStatus.OK);
    }

    @RequestMapping(value = "addOwner", method = RequestMethod.POST,consumes="application/json")
    public Boolean addOwner(@RequestBody Owner owner) {
        if (owner != null)
            return OwnerComponent.addOwner(owner);
        else
            return false;
    }

    @RequestMapping(value = "editOwner", method = RequestMethod.POST,consumes="application/json")
    public Boolean edit(@RequestBody Owner owner) {
        if (owner != null)
            return OwnerComponent.editOwner(owner);
        else
            return false;
    }
}
