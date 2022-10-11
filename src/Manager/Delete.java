package Manager;

import java.util.ArrayList;
import java.util.Arrays;

public class Delete {

    public static Employee[] deleteEmployee(Employee[] e){
        int ID =  Search.searchID(e);

        System.out.println("Are you sure you want to delete this employee?");
        switch (Menu.selectYesNo()) {

            case 1: ArrayList<Employee> employeeList = new ArrayList<>(Arrays.asList(e));
                employeeList.remove(ID-1);
                e = employeeList.toArray(new Employee[0]);
                System.out.println  ("The employee was successfully deleted from the list!");
                return e;
            case 2:
                break;
            default:
                System.out.println("The field with selected number doesn't exist. Please try again.");
        }
        return e;
    }
}