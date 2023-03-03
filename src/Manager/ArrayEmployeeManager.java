package Manager;


import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ArrayEmployeeManager implements Manager<List<Employee>>{

    static BdManager bdManager = new BdManager();
    private static Scanner sc = new Scanner(System.in);
    List<Employee> employees = new ArrayList<>();
    @Override
    public void create(List<Employee> e) {
            System.out.println("Employee [" + (e.size()+1) + "]");
            int id = e.size()+1;
            System.out.println("Enter employee's name: ");
            String name = sc.next();
            System.out.println("Enter employee's surname: ");
            String surname = sc.next();
            System.out.println("Select gender of the employee: ");
            String gender;
            if (Menu.selectGender() == 1) gender = "Male";
            else gender = "Female";
            System.out.println("Enter date of birth in the format day/month/year (dd/mm/yyyy)");
            LocalDate birthdate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/y"));
            e.add(new Employee(id, name, surname, gender, birthdate));
            bdManager.create(e.get(e.size()-1));
    }

    public void update(Employee e) {
  boolean correctNr;
       do { correctNr=true;
           switch (Menu.personalDataEditing()) {
               case "1":
                   updateName(e);
                   break;
               case "2":
                  updateSurname(e);
                   break;
               case "3":
                   updateGender(e);
                   break;
               case "4":
                   updateBirthdate(e);
                   break;
               default:
                   System.out.println("The field with selected number doesn't exist. Please try again.");
                   correctNr = false;
           }
       }  while(!correctNr);
           }

    public void continueEditData(Employee e) {
        boolean correctNr;
        do { correctNr=true;
       switch (Menu.continueDataEditing()) {
        case "1":
            update(e);
            break;
        case "2":
            update(bdManager.selectByID());
            break;
        case "3":
            break;
        default:
            System.out.println("The field with selected number doesn't exist. Please try again.");
            correctNr = false; } }  while(!correctNr);}

    @Override
    public void updateBirthdate(Employee e) {
        System.out.println ("Enter date of birth in the format day/month/year (dd/mm/yyyy)\nChanging birthdate from " + e.getBirthdate() + " to: " );
        e.setBirthdate(LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/y")) );
       bdManager.updateBirthdate(e);
    }

    @Override
    public void updateGender(Employee e) {
        System.out.println ("Changing gender from " + e.getGender() + " to: " );
        if(Menu.selectGender() == 1)  e.setGender("Male"); else e.setGender("Female") ;
        bdManager.updateGender(e);
    }

    @Override
    public void updateSurname(Employee e) {
        System.out.println ("Changing surname from " + e.getSurname() + " to: " );
        e.setSurname(sc.nextLine());
       bdManager.updateSurname(e);
    }

    @Override
    public void updateName(Employee e) {
        System.out.println ("Changing name from " + e.getName() + " to: " );
        e.setName(sc.next());
       bdManager.updateName(e);
    }


    @Override
    public void delete(List<Employee> e) {
        //Employee toDelete = selectByID(e);
        Employee toDelete = bdManager.selectByID();
        System.out.println("Are you sure you want to delete this employee?");
        switch (Menu.selectYesNo()) {

                case 1: //e.remove(toDelete);
                    bdManager.delete(toDelete);
                case 2:
                    break;
                default:
                    System.out.println("The field with selected number doesn't exist. Please try again.");
            }
    }


    public void selectAll(List<Employee> e) {
        for (Employee emp: e){
            System.out.println(emp);
        }
    }

    public Employee selectByID(List<Employee> e){
        boolean correctId=false;
        String iD;
        Employee found =null;
        while(!correctId){
            System.out.println ("Enter ID of the employee you are looking for: ");
            iD= sc.next();
          try{ for(Employee emp:e){
                  if (emp.getId()==Integer.parseInt(iD)){
                    found=emp;
                    correctId=true;
                }}  if(found==null) System.out.println("Data cannot be displayed. There is no Employee with that ID.");}
          catch(NumberFormatException ex){ System.out.println("NumberFormat Exception: invalid input.");}

        }
        return found;
    }
}
