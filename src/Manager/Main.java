package Manager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    static ArrayEmployeeManager arrayEmployee = new ArrayEmployeeManager();
    static BdManager bdManager = new BdManager();
    public static void main (String[] args){
        getResponse();
       List<Employee> employees = new ArrayList<>();

        do{
            switch (Menu.basicMenu()) {
                case "1":
                    arrayEmployee.create(employees);
                    break;
                case "2":
                    if (BdManager.checkExistenceOfData()){
                    boolean correctNr;
                do {
                       correctNr = true;
                    switch(Menu.viewModel()){
                    case 1: employees = bdManager.selectAll();
                    for(Employee emp: employees)
                        System.out.println(emp);
                        break;
                    case 2: System.out.println(bdManager.selectByID()); break;
                    default: System.out.println("The field with selected number doesn't exist. Please try again.");
                               correctNr = false;
                }}while (!correctNr); }
                    else System.out.println ("There are no employees for search.");
                   break;

                case "3":
                    if (BdManager.checkExistenceOfData()) arrayEmployee.update(bdManager.selectByID());
                    //if(employees.size()!=0) arrayEmployee.update(arrayEmployee.selectByID(employees));
                    else System.out.println ("There is no data for editing.");
                    break;

               case "4":
                   if (BdManager.checkExistenceOfData()) arrayEmployee.delete(employees);
                   // if(employees.size()!=0) { arrayEmployee.delete(employees);}
                    else System.out.println ("There is no employee to delete.");
                    break;
                case "5":
                    System.out.println("Are you sure you want to close application?");
                    switch (Menu.selectYesNo()) {
                        case 1:
                            System.exit(0);
                        case 2:
                            continue;
                        default:
                            System.out.println("The field with selected number doesn't exist. Please try again.");
                    }
                    break;
                default:
                    System.out.println("The field with selected number doesn't exist. Please try again.");
            }

        }while (true);}

    public static void getResponse(){
        System.out.println("Hello!\n" +
                "Welcome to the Employee Manager application.\n" +
                "This application was created to effectively manage the data about your company's employees.\n" +
                "The available functionalities are: entering, viewing and editing data.\n" +
                "Press any key to continue.");
       sc.next();
        }

    }


