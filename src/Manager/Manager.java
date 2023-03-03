package Manager;
import java.util.List;
public interface Manager<T>{

    void create(T e);
    void updateName(Employee e);
    void updateSurname(Employee e);
    void updateGender(Employee e);
    void updateBirthdate(Employee e);
    void delete (T e);

}
