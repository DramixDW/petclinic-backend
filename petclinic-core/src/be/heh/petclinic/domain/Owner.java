package be.heh.petclinic.domain;

import java.util.ArrayList;
import java.util.List;

public class Owner {

    private String lastname;
    private String firstname;
    private String address;
    private String telephone;
    private String city;
    private List<Pet> pets;
    private Integer id;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        if (pets == null)
            pets = new ArrayList<>();
        this.pets.add(pet);
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAddres(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getCity() {
        return this.city;
    }

    public String getAddres() {
        return this.address;
    }

    public Integer getId() {
        return this.id;
    }


    @Override
    public String toString() {
        return "Owner{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", city='" + city + '\'' +
                ", id=" + id +
                '}';
    }
}