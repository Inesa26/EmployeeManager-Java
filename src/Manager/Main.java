package Manager;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main (String[] args){

        int employeeNumber = getNumber();
        Employee[] employees = new Employee[employeeNumber];

        do{
            switch (Menu.basicMenu()) {
                case 1:
                    Inserts.insert(employees, employeeNumber);
                    break;
                case 2: if(EmptyArray.checkArray(employees)){
                    boolean correctNr;
                    do {
                        correctNr = true;
                        switch (Menu.viewModel()) {
                            case 1:
                                Searches.searchAll(employees);
                                break;
                            case 2:
                                Searches.searchID(employees);
                                break;
                            default:
                                System.out.println("The field with selected number doesn't exist. Please try again.");
                                correctNr = false;
                        }
                    } while (!correctNr);} else System.out.println ("There are no employees for search.");
                    break;

                case 3:  if(EmptyArray.checkArray(employees)) Editings.editData(employees);
                        else System.out.println ("There is no data for editing.");
                    break;

                case 4: if(EmptyArray.checkArray(employees)) employees = Deletions.deleteEmployee(employees);
                else System.out.println ("There is no employee to delete.");
                    break;
                case 5:
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

        public static int getNumber(){
            System.out.println("Hello!\n" +
                    "Welcome to the Employee Manager application.\n" +
                    "This application was created to effectively manage the data about your company's employees.\n" +
                    "The available functionalities are: entering, viewing and editing data.\n" +
                    "To start, enter the number of employees.");
            return sc.nextInt();
        }

    }


