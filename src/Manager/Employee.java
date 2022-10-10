package Manager;

public class Employee {
private  String name;
private String surname;
private String gender;


  public Employee (String nam, String surn, String gen)
    {  this.name =nam;
       this.surname=surn;
       this.gender= gen;
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

    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getGender(){
        return this.gender;
    }
  }


