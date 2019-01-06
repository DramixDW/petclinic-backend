package be.heh.petclinic.web;

import be.heh.petclinic.component.pet.PetComponent;
import be.heh.petclinic.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PetRestController {
    @Autowired
    private PetComponent petComponentImpl;

    @RequestMapping("getPetWithVisitsByOwnerId")
    public ResponseEntity<Pet> getPetWithVisitsByName(@RequestParam(value="id") Integer id) {
        Pet pet = petComponentImpl.getPetWithVisitsByOwnerId(id);
        return pet == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @RequestMapping("getPets")
    public ResponseEntity<Collection<Pet>> getPets() {
        Collection<Pet> pets = petComponentImpl.getPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @RequestMapping("getPetByID")
    public ResponseEntity<Pet> getPetById(@RequestParam(value="id") Integer pet_id) {
        Pet pet = petComponentImpl.getPetById(pet_id);
        return pet == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @RequestMapping(value = "addPet", method = RequestMethod.POST,consumes="application/json")
    public Boolean addOwner(@RequestBody Pet pet) {
        if (pet != null)
            return petComponentImpl.addPet(pet);
        else
            return false;
    }

    @RequestMapping(value = "editPet", method = RequestMethod.POST,consumes="application/json")
    public Boolean edit(@RequestBody Pet pet) {
        if (pet != null)
            return petComponentImpl.editPet(pet);
        else
            return false;
    }
}