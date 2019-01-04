package be.heh.petclinic.domain;

public class Visits {
    private String petname;
    private int type_id;

    public void setpetname(String petname){
        this.petname = petname;
    }

    public void settype_id(int type_id){
        this.type_id = type_id;
    }

    public String getpetname(){
        return this.petname;
    }

    public int gettype_id(){
        return this.type_id;
    }
}
