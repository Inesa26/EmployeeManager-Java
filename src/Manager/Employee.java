package Manager;

import java.time.LocalDate;

public class Employee {
private int id;
private  String name;
private String surname;
private String gender;
private LocalDate birthdate;
    public Employee ()
    {  }
  public Employee (String nam, String surn, String gen, LocalDate birthdate)
    {  this.name =nam;
       this.surname=surn;
       this.gender= gen;
       this.birthdate=birthdate;
    }

    public Employee (int id, String nam, String surn, String gen, LocalDate birthdate)
    {   this.id=id;
        this.name =nam;
        this.surname=surn;
        this.gender= gen;
        this.birthdate=birthdate;
    }

    public void setName(String value){
        name=value;
    }
    public void setSurname(String value){
        surname=value;
    }
    public void setGender(String value){
        gender=value;
    }
    public void setBirthdate(LocalDate value){birthdate=value;}


    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getGender(){
        return this.gender;
    }
    public LocalDate getBirthdate(){return this.birthdate;}
  }


