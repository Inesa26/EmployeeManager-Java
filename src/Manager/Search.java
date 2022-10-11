package Manager;

import java.util.Scanner;

public class Search {
    private static Scanner sc = new Scanner(System.in);

    public static void searchAll(Employee[] e){
      //  if(!EmptyArray.checkArray(e)){
             View.viewAll(e);}
      //  else System.out.println("There are no employees for search.");}

    public static int searchID(Employee[] e) {
        int ID;
        boolean correctID = false;
        do{ System.out.println ("Enter ID of the employee you are looking for: ");
            ID= sc.nextInt();
            for (int i=0; i<e.length; i++){
                if (i+1 == ID) {
                    correctID = true;
                    break;
                }
            }
            if(correctID) View.viewID(e, ID);
            else System.out.println("There is no employee with this ID, please try again.");
        }while (!correctID); return ID;}
    }



