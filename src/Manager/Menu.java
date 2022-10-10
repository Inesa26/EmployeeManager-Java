package Manager;

import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    static int basicMenu() {
    System.out.println("\n\n\tMENU EMPLOYEE");
    System.out.println("\t1. Enter employee");
    System.out.println("\t2. Show employee");
    System.out.println("\t3. Edit personal data");
    System.out.println("\t4. Delete employee from the list");
    System.out.println("\t5. Exit");
    return sc.nextInt();
}

    static int viewModel() {
        System.out.println("\t1. View the full list of employees.");
        System.out.println("\t2. View a specific employee.");
        return sc.nextInt();
    }

    static int selectGender() {
        System.out.println("\t1. Male");
        System.out.println("\t2. Female");
        return sc.nextInt();
    }

    static int selectYesNo() {
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");
        return sc.nextInt();
    }

    static int personalDataEditing() {
        System.out.println("\t1. Edit Employee's name");
        System.out.println("\t2. Edit Employee's surname");
        System.out.println("\t3. Edit Employee's gender");
        return sc.nextInt();
    }

    static int continueDataEditing() {
        System.out.println("\t1. Modify the data of the present employee");
        System.out.println("\t2. Modify another employee's data");
        System.out.println("\t3. Return to the main menu");
        return sc.nextInt();
    }
}



