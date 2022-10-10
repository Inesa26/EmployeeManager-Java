package Manager;
import java.util.Scanner;


public class Editings {
    private static Scanner sc = new Scanner(System.in);
    public static void editData(Employee[] e)  {
        int ID =  Searches.searchID(e);
        boolean correctNr;
        do {
            correctNr = true;
              switch(Menu.personalDataEditing()){
                  case 1:
                      System.out.println ("Changing name from " + e[ID-1].getName() + " to: " );
                      e[ID-1].setName(sc.nextLine());
                      System.out.print("The changes were made successfully !!!");
                      break;
                  case 2:
                      System.out.println ("Changing surname from " + e[ID-1].getSurname() + " to: " );
                      e[ID-1].setSurname(sc.nextLine());
                      System.out.print("The changes were made successfully !!!");
                      break;
                  case 3:
                      System.out.println ("Changing gender from " + e[ID-1].getGender() + " to: " );
                      if(Menu.selectGender() == 1)  e[ID-1].setGender("Male"); else e[ID-1].setGender("Female") ;
                      System.out.println("The changes were made successfully !!!");
                      break;
                  default:
                      System.out.println("The field with selected number doesn't exist. Please try again.");
                      correctNr = false;
              } switch(Menu.continueDataEditing()){
                case 1: correctNr = false; break;

                case 2: Editings.editData(e);break;
                case 3: correctNr = true;break;
                default: System.out.println("The field with selected number doesn't exist. Please try again.");
                    Menu.continueDataEditing();

            } } while (!correctNr);
    }
}