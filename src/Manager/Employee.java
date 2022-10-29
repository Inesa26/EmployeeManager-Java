package Manager;

public class Employee {
private int id;
private  String name;
private String surname;
private String gender;

    public Employee ()
    {  }
  public Employee (String nam, String surn, String gen)
    {  this.name =nam;
       this.surname=surn;
       this.gender= gen;
    }

    public Employee (int id, String nam, String surn, String gen)
    {   this.id=id;
        this.name =nam;
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
  }


