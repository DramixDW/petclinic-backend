package be.heh.petclinic.domain;

import java.sql.Date;

public class Pet {
    private Integer id;
    private String name;
    private Date birth_date;
    private Integer type_id;
    private Integer owner_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birth_date;
    }

    public void setBirthDate(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Integer getTypeId() {
        return type_id;
    }

    public void setTypeId(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }
}

