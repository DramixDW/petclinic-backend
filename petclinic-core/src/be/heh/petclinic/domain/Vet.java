package be.heh.petclinic.domain;

public class Vet {

    private String lastname;
    private String firstname;

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


}