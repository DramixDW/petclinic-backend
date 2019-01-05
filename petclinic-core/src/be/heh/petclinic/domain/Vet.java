package be.heh.petclinic.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Vet {
    private Integer id;
    private String lastname;
    private String firstname;
    private Collection<Specialty> specialties = new ArrayList<>();

    public Vet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return this.lastname;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public Collection<Specialty> getSpecialties() {
        return specialties;
    }

    public void addSpecialty(Specialty specialty) {
        specialties.add(specialty);
    }

    public void setSpecialties(Collection<Specialty> specialties) {
        this.specialties = specialties;
    }
}