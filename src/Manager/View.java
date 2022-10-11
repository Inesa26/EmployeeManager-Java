package Manager;

public class View {

    public static void viewID(Employee[] e, int nr) {
        System.out.println("Employee [" + nr + "] " + e[nr - 1].getName() + " " + e[nr - 1].getSurname() + " - " + e[nr - 1].getGender());

    }
    public static void viewAll(Employee[] e){
         for(int i =0; i<e.length; i++) {
             System.out.println("Employee ["+ (i+1)+"] "+ e[i].getName() + " " + e[i].getSurname()+ " - " + e[i].getGender());
         }
     }}





