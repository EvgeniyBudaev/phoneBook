package database;

import entity.Phone;
import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DBManager {

    //Отображение всех пользователей
    public static ArrayList<User> getAllActivUsers(){
        ArrayList<User> allUsers = new ArrayList<>();

        try{
            String url = "jdbc:mysql://localhost:3306/phonebook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    url,"root","Prodaza58");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM phonebook.users where status = '1' ");
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setSurname(rs.getString("surname"));
                user.setName(rs.getString("name"));
                user.setPatronymic(rs.getString("patronymic"));
                user.setStatus(1);
                allUsers.add(user);
            }

        }catch (Exception e){
            System.out.println("Упс! Что-то пошло не так! Отображение всех пользователей не выполнено!");
        }

        return allUsers;
    }

    //Отображение всех пользователей с номерами телефонов
    public static LinkedHashMap<User, String> getAllActivUsersWithNumbers(){
        LinkedHashMap<User, String> userAndPhone = new LinkedHashMap<>();

        try{
            String url = "jdbc:mysql://localhost:3306/phonebook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    url,"root","Prodaza58");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT users.id, users.surname, users.name, users.patronymic, phones.user_id, phones.phoneNumber FROM phonebook.users join phonebook.phones on phones.user_id=users.id where (phonebook.phones.status = '1' and phonebook.users.status = '1') ");
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setSurname(rs.getString("surname"));
                user.setName(rs.getString("name"));
                user.setPatronymic(rs.getString("patronymic"));
                user.setStatus(1);
                String number = rs.getString("phoneNumber") + " ";

                userAndPhone.put(user, number);
            }
        }catch (Exception e){
            System.out.println("Упс! Что-то пошло не так! Отображение пользователей с номерами телефонов не выполнено!");
        }
        return userAndPhone;
    }


    //Добавление записи
    public static void createRecord(String surname, String name, String patronymic, String phoneNumber){

        try{
            String url = "jdbc:mysql://localhost:3306/phonebook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    url,"root","Prodaza58");
            Statement stmt = con.createStatement();
            if(phoneNumber.equals("")){
                stmt.execute("INSERT INTO `phonebook`.`users` (`surname`, `name`, `patronymic`) VALUES ('" + surname + "', '" + name + "', '" + patronymic + " ')");
            }else{
                stmt.execute("INSERT INTO `phonebook`.`users` (`surname`, `name`, `patronymic`) VALUES ('" + surname + "', '" + name + "', '" + patronymic + " ')");
                stmt.executeQuery("SELECT id FROM users WHERE surname='" + surname + "'");
                stmt.execute("INSERT INTO phones(user_id, phoneNumber) VALUES ((SELECT id FROM users WHERE surname='" + surname + "'), '" + phoneNumber + "') ;");

            }

        }catch (Exception e){
            System.out.println("Упс! Что-то пошло не так! Новая запись не добавлена!");
        }
    }

    //Удаление записи
    public static void deleteUser(String id) {
        try{
            String url = "jdbc:mysql://localhost:3306/phonebook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    url,"root","Prodaza58");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `phonebook`.`users` SET `status` = '0' WHERE (`id` = '"+id+"')");
            stmt.execute("UPDATE `phonebook`.`phones` SET `status` = '0' WHERE (`user_id` = '"+id+"')");


        }catch (Exception e){
            System.out.println("Упс! Что-то пошло не так! Удаление юзера не выполнено");
        }
    }


}
