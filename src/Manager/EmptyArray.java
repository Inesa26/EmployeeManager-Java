package Manager;

public class EmptyArray {

    public static boolean checkArray(Employee[] e){
        boolean allNull = true;
        for (Employee employee : e)
            if (employee != null) {
                allNull = false;
                break;
            }
        return !allNull;
    }}

