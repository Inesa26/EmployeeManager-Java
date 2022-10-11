package Manager;

import java.util.Scanner;

public class Insert {
    private static Scanner sc = new Scanner(System.in);

    public static void insert(Employee[] e, int nr) {
        for(int i =0; i<=nr-1; i++){
            System.out.println("Employee ["+ (i+1)+"]");
            System.out.println("Enter employee's name: ");
            String name = sc.nextLine();
            System.out.println("Enter employee's surname: ");
            String surname = sc.nextLine();
            System.out.println("Select gender of the employee: ");
            String gender;
            if(Menu.selectGender() == 1) gender = "Male"; else gender = "Female";
            e[i] = new Employee(name, surname, gender);
        }
    }
}