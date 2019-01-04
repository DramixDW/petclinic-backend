package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;

import java.util.Date;
import java.util.List;

import java.util.Collection;

public interface PetComponent{
    Collection<Pet> getPets();
    Pet getPet(String name);
    Pet getPet(Integer pet_id);
    Boolean editPet(Pet pet);
    Boolean addPet(Pet pet);
}

