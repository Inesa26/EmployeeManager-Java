package Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BdManager {
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


    public static void create (Employee emp){


        try{
            String sql = "INSERT into employee(name, surname, gender) values(?,?,?)";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, emp.getName());
                statement.setString(2, emp.getSurname());
                statement.setString(3, emp.getGender());
                int rows = statement.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Error! The person's data has not been inserted into the database.");
        }
    }


    public static List<Employee> selectAll(){

        String sql = "Select id, name, surname, gender from employee";
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
                employees.add(new Employee(id, name, surname, gender));
            }
        }
        catch(SQLException ex){
            System.out.println("Data cannot be displayed");
        }
        return employees;
    }

    public static List<Employee> selectByID(){
        int ID;
        System.out.println ("Enter ID of the employee you are looking for: ");
        ID= sc.nextInt();
        String sql = "Select id, name, surname, gender from employee where id="+ ID;
        List<Employee> employees = new ArrayList<>();
        try{
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String gender = resultSet.getString("gender");
                employees.add(new Employee(id, name, surname, gender));
        }
        catch(SQLException ex){
            System.out.println("Data cannot be displayed");
        }
        return employees;
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

    public static void editName (Employee emp){
        try{
            String sql = "UPDATE employee set name=? where id=?";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, emp.getName());
                statement.setInt(2, emp.getId());
                int rows = statement.executeUpdate();
                System.out.print("Name changed successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Error! the name has not been updated.");
        }
    }

    public static void editSurname (Employee emp){
        try{
            String sql = "UPDATE employee set surname=? where id=?";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, emp.getSurname());
                statement.setInt(2, emp.getId());
                int rows = statement.executeUpdate();
                System.out.print("Surname changed successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Error! the surname has not been updated.");
        }
    }

    public static void editGender (Employee emp){
        try{
            String sql = "UPDATE employee set gender=? where id=?";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, emp.getGender());
                statement.setInt(2, emp.getId());
                int rows = statement.executeUpdate();
                System.out.print("Gender changed successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Error! the gender has not been updated.");
        }
    }

    public static void deleteEmployee (Employee emp){
        try{
            String sql = "DELETE FROM employee where id=?";
            Connection connection = getConnection();
            if(connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, emp.getId());
                int rows = statement.executeUpdate();
                System.out.println  ("The employee was successfully deleted from the list!");
            }
        } catch (SQLException ex) {
            System.out.println("Error! The employee's data has not been deleted from the database.");
        }
    }
}

