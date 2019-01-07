package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;

import java.util.Date;
import java.util.List;

import java.util.Collection;

public interface PetComponent{
    Collection<Pet> getPets();
    Collection<Pet> getPetWithVisits(String name);
    Collection<Pet> getPetWithVisits(Integer pet_id);
    Collection<Pet> getPetWithVisitsByOwnerId(Integer owner_id);
    Pet getPetById(Integer pet_id);
    Boolean editPet(Pet pet);
    Boolean addPet(Pet pet);
}

