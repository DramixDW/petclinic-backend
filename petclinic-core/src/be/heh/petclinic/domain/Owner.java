package be.heh.petclinic.domain;

public class Owner {

    private String lastname;
    private String firstname;
    private String address;
    private String telephone;
    private String city;
    private int id;

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

    public void setId(int id) {
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

    public int getId() {
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