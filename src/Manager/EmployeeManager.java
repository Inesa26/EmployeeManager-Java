package Manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
 private static Scanner sc = new Scanner(System.in);

    public static void insertEmployee(Employee[] e, int nr) {
        for(int i =0; i<=nr-1; i++){
            System.out.println("Employee ["+ (i+1)+"]");
            System.out.println("Enter employee's name: ");
            String name = sc.nextLine();
            System.out.println("Enter employee's surname: ");
            String surname = sc.nextLine();
            System.out.println("Select gender of the employee: ");
            String gender;
            if(Menu.selectGender() == 1) gender = "Male"; else gender = "Female";
            System.out.println("Enter date of birth in the format day/month/year (dd/mm/yyyy)");
            LocalDate birthdate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/y"));
            e[i] = new Employee(name, surname, gender, birthdate);
            BdManager.create(e[i]);
        }
    }

    public static void viewAll(List<Employee> employees){
        for(Employee employee:employees){
            System.out.println("Employee ["+ employee.getId()+"] "+ employee.getName() + " " + employee.getSurname()+ " - " + employee.getGender() + " " + employee.getBirthdate());
        }
    }

    public static void editData()  {
        List<Employee> employees = BdManager.selectByID();
        if(!employees.isEmpty()){
            Employee[] e = employees.toArray(new Employee[0]);
            boolean correctNr;
            do {
                correctNr = true;
                switch(Menu.personalDataEditing()){
                    case 1:
                        System.out.println ("Changing name from " + e[0].getName() + " to: " );
                        e[0].setName(sc.nextLine());
                        BdManager.editName(e[0]);
                        break;
                    case 2:
                        System.out.println ("Changing surname from " + e[0].getSurname() + " to: " );
                        e[0].setSurname(sc.nextLine());
                        BdManager.editSurname(e[0]);
                        break;
                    case 3:
                        System.out.println ("Changing gender from " + e[0].getGender() + " to: " );
                        if(Menu.selectGender() == 1)  e[0].setGender("Male"); else e[0].setGender("Female") ;
                        BdManager.editGender(e[0]);
                        break;
                    case 4:
                        System.out.println ("Enter date of birth in the format day/month/year (dd/mm/yyyy)\nChanging birthdate from " + e[0].getBirthdate() + " to: " );
                        e[0].setBirthdate(LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/y")) );
                        BdManager.editBirthdate(e[0]);
                        break;
                    default:
                        System.out.println("The field with selected number doesn't exist. Please try again.");
                        correctNr = false;
                } switch(Menu.continueDataEditing()){
                    case 1: correctNr = false; break;

                    case 2: EmployeeManager.editData();
                        break;
                    case 3: correctNr = true;break;
                    default: System.out.println("The field with selected number doesn't exist. Please try again.");
                        Menu.continueDataEditing();

                } } while (!correctNr);
        }
    }

    public static void deleteEmployee(){
        List<Employee> employees = BdManager.selectByID();
        if(!employees.isEmpty()){
            Employee[] e = employees.toArray(new Employee[0]);
            System.out.println("Are you sure you want to delete this employee?");
            switch (Menu.selectYesNo()) {

                case 1:
                    BdManager.deleteEmployee(e[0]);
                case 2:
                    break;
                default:
                    System.out.println("The field with selected number doesn't exist. Please try again.");
            }}
    }
}
