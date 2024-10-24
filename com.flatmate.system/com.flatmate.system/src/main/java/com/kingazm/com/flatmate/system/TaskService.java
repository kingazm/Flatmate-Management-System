package com.kingazm.com.flatmate.system;

import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    public static void saveTheTask(Task task) throws ClassNotFoundException { //practically saves the task by connecting to database

        String description = task.getDescription();
        String category = task.getCategory();

        System.out.println("Task Description: " + description); //control, to check working
        System.out.println("Task Category: " + category);


        try {

            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            int result = statement.executeUpdate("INSERT INTO tasks(Description, Category, AssignedUser, Deadline, Priority, Status) VALUES ('" + task.getDescription() + "', '" + task.getCategory()  + "', '" + task.getAssignedUser()  + "', '" + task.getDeadline()  + "', '" + task.getPriority()  + "', 'TO DO');");
            connection.close();

            task.setTaskAdditionResult(true);

        }

        catch (SQLException exception) {
            System.out.println(exception);
        }

    }

    public static String showTheTask() throws ClassNotFoundException {
        //shows a task from database, for now one and same for every user (to be adjusted in the future)

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            String loggedinUser =  UserInfo.getLoggedUser().getUsername(); //to show tasks only for logged in user

            ResultSet result = statement.executeQuery("SELECT Description, Category, AssignedUser, Deadline, Priority, Status FROM tasks WHERE AssignedUser='" + loggedinUser + "'"); //for AssignedUser, put globally recognized user who is logged in

            String tasksInfo = "";

            while (result.next()) {

                Task task = new Task(result.getString("Description"), result.getString("Category"), result.getString("AssignedUser"), result.getString("Deadline"), result.getString("Priority"), result.getString("Status"));

               //System.out.println(task.toString()); //log, to check the execution
                tasksInfo += task.toStringWebsiteView();
                tasksInfo += "\n";
            }

            connection.close();

            return tasksInfo;
        }

        catch (SQLException exception) {
            System.out.println(exception);
        }

        return "";

    }

    public List<Task> findUserTasks(){ //list of all tasks of a logged in user

        List<Task> TasksList = new ArrayList<>();

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            String loggedinUser =  UserInfo.getLoggedUser().getUsername(); //to show tasks only for logged in user

            ResultSet result = statement.executeQuery("SELECT Id, Description, Category, AssignedUser, Deadline, Priority, Status FROM tasks WHERE AssignedUser='" + loggedinUser + "'"); //for AssignedUser, put globally recognized user who is logged in

            String tasksInfo = "";

            while (result.next()) {

                Task task = new Task(result.getInt("Id"), result.getString("Description"), result.getString("Category"), result.getString("AssignedUser"), result.getString("Deadline"), result.getString("Priority"), result.getString("Status"));

                //System.out.println("Fetched from the list: " + task.toString()); //control, to check the execution

                TasksList.add(task);
            }

            connection.close();

            return TasksList;
        }

        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }


        return TasksList;
    }

    public List<Task> findAll() { //list of all tasks in database - no matter user

        List<Task> TasksList = new ArrayList<>();

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT Id, Description, Category, AssignedUser, Deadline, Priority, Status FROM tasks;"); //for AssignedUser, put globally recognized user who is logged in

            String tasksInfo = "";

            while (result.next()) {

                Task task = new Task(result.getInt("Id"), result.getString("Description"), result.getString("Category"), result.getString("AssignedUser"), result.getString("Deadline"), result.getString("Priority"), result.getString("Status"));

                //System.out.println("Fetched from the list: " + task.toString()); //log, to check the execution

                TasksList.add(task);
            }

            connection.close();

            return TasksList;
        }

        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }

        return TasksList;
    }

    //TODO: osobne query na oznaczanie taska jako done (status) i dopiero done taski sa pod review admina czy git i wtedy po accepcie usuwane
    public static void deleteTheTask(int id) throws ClassNotFoundException {
        //practically deletes the task by connecting to database
        //System.out.println("Task deletion activated");

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("DELETE FROM tasks WHERE Id = '" + id + "';"); // temp + task.getDescription() + ";");

            connection.close();

        }

        catch (SQLException exception) {
            System.out.println(exception);
        }
    }

}
