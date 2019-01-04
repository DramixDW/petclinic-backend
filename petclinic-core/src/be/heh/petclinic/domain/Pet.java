package be.heh.petclinic.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

public class Pet {

    private Integer id;
    private String name;
    private Date birth_date;
    private Integer type_id;

    // null by default
    private Owner owner;

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public void addVisit(Visit visit)
    {
        if (visits == null)
            visits = new ArrayList<>();

        visits.add(visit);
    }

    private List<Visit> visits;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getTypeName() {
        return type_name;
    }

    public void setTypeName(String type_name) {
        this.type_name = type_name;
    }

    private String type_name;
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

