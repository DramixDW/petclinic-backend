package be.heh.petclinic.domain;

import java.sql.Date;

public class Visit {
    private Date visit_date;
    private String description;
    private Integer pet_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    public void setVisit_date(Date visit_date){
        this.visit_date = visit_date;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPet_id(Integer pet_id){
        this.pet_id = pet_id;
    }

    public Date getVisit_date(){
        return this.visit_date;
    }

    public String getDescription(){
        return this.description;
    }

    public Integer getpet_id(){
        return this.pet_id;
    }
}
