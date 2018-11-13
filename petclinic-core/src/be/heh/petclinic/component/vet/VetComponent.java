package be.heh.petclinic.component.vet;

import be.heh.petclinic.domain.Vet;

import java.util.List;

import java.util.Collection;

public interface VetComponent{
    Collection<Vet> getVets();
    Vet getVet(String lastName);
    Vet getVet(Integer id);
}