package Manager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BdManager implements Manager <Employee>{
    private static Scanner sc = new Scanner(System.in);
    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE_MANAGER", "root", "Grawe987");
            System.out.println(" Conexiune reusita: ");
            return connection;
        }catch(SQLException ex){
            System.out.println("Eroare de conexiune: "+ ex.getMessage());
            return null;
        } }


    public void create (Employee emp){


        try{
            String sql = "INSERT into employee(name, surname, gender, birthdate) values(?,?,?,?)";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, emp.getName());
                statement.setString(2, emp.getSurname());
                statement.setString(3, emp.getGender());
                statement.setDate(4, Date.valueOf(emp.getBirthdate()));
                int rows = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Error! The person's data has not been inserted into the database.");
        }    }


    @Override
    public void delete(Employee e) {
        try{
            String sql = "DELETE FROM employee where id=?";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, e.getId());
                int rows = statement.executeUpdate();
                System.out.println  ("The employee was successfully deleted from the list!");
            }
        } catch (SQLException ex) {
            System.out.println("Error! The employee's data has not been deleted from the database.");
        }

    }


    @Override
    public void updateBirthdate(Employee e) {
        try{
            String sql = "UPDATE employee set birthdate=? where id=?";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setDate(1, Date.valueOf(e.getBirthdate()));
                statement.setInt(2, e.getId());
                int rows = statement.executeUpdate();
                System.out.print("Birthdate changed successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Error! the birthdate has not been updated.");
        }
    }

    @Override
    public void updateGender(Employee e) {
        try{
            String sql = "UPDATE employee set gender=? where id=?";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, e.getGender());
                statement.setInt(2, e.getId());
                int rows = statement.executeUpdate();
                System.out.print("Gender changed successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Error! the gender has not been updated.");
        }
    }

    @Override
    public void updateSurname(Employee e) {
        try{
            String sql = "UPDATE employee set surname=? where id=?";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, e.getSurname());
                statement.setInt(2, e.getId());
                int rows = statement.executeUpdate();
                System.out.print("Surname changed successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Error! the surname has not been updated.");
        }
    }

    @Override
    public void updateName(Employee e) {
        try{
            String sql = "UPDATE employee set name=? where id=?";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, e.getName());
                statement.setInt(2, e.getId());
                int rows = statement.executeUpdate();
                System.out.print("Name changed successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Error! the name has not been updated.");
        }
    }


    public  List<Employee> selectAll(){

        String sql = "Select id, name, surname, gender, birthdate from employee";
        List<Employee> employees = new ArrayList<>();
        try{
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String gender = resultSet.getString("gender");
                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                employees.add(new Employee(id, name, surname, gender, birthdate));
            }
        }
        catch(SQLException ex){
            System.out.println("Data cannot be displayed");
        }
        return employees;
    }

    public  Employee selectByID(){
        boolean correctId=false;
        String iD;
        Employee selectEmp=null;
        while(!correctId){
        System.out.println ("Enter ID of the employee you are looking for: ");
        iD= sc.next();
        String sql = "Select id, name, surname, gender, birthdate from employee where id="+ iD;

        try {
            Connection connection = getConnection();
            if (connection != null){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String gender = resultSet.getString("gender");
                LocalDate birthdate = resultSet.getDate("birthdate").toLocalDate();
                selectEmp = new Employee (id, name, surname, gender, birthdate);
            correctId=true;
        }}
        catch(SQLException ex) {
            System.out.println("Data cannot be displayed");
        }

        }
        return selectEmp;
    }



    public static boolean checkExistenceOfData(){

        boolean dataExists = false;
        try{
            String sql = "Select * from employee";
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                dataExists = true;
            }}
        catch(SQLException ex){
            System.out.println("Data cannot be displayed");
        }
        return dataExists;
    }

}

