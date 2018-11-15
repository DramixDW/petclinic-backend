package be.heh.petclinic.domain;

import java.util.Date;

public class Pet {
    private int id;
    private String name;
    private String type;
    private String owner_firstName;
    private String owner_lastName;
    private Date  birthDate;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getOwner_firstName() { return owner_firstName; }

    public void setOwner_firstName(String owner_firstName) { this.owner_firstName = owner_firstName; }

    public String getOwner_lastname() { return owner_lastName; }

    public void setOwner_lastname(String owner_lastname) { this.owner_lastName = owner_lastname; }

    public Date getBirthDate() { return birthDate; }

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
}
