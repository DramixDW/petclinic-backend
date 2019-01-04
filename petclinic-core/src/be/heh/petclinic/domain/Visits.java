package be.heh.petclinic.domain;

import java.util.Date;

public class Visits {
    private Date visit_date;
    private String description;
    private int pet_id;

    public void setVisit_date(Date visit_date){
        this.visit_date = visit_date;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPet_id(int pet_id){
        this.pet_id = pet_id;
    }

    public Date getVisit_date(){
        return this.visit_date;
    }

    public String getDescription(){
        return this.description;
    }

    public int getpet_id(){
        return this.pet_id;
    }
}
