package com.kingazm.com.flatmate.system;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ShoppingService {

    public List<ShoppingItem> findFlatList() {

        List<ShoppingItem> flatList = new ArrayList<ShoppingItem>();

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT Item, Amount FROM flatShoppingList WHERE Status = 'to buy';");

            while (result.next()) {

                ShoppingItem item = new ShoppingItem(result.getString("Item"), result.getInt("Amount"));

                System.out.println("Fetched from the list: " + item.toString()); //control, to check the execution

                flatList.add(item);
            }

            connection.close();

            return flatList;
        }

        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }


        return flatList;
    }

    public List<ShoppingItem> findPersonalList() {

        List<ShoppingItem> personalList = new ArrayList<ShoppingItem>();

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT Item, Amount FROM personalShoppingList WHERE Status = 'to buy' AND User = '" + UserInfo.getLoggedUser().getUsername() + "';");

            while (result.next()) {

                ShoppingItem item = new ShoppingItem(result.getString("Item"), result.getInt("Amount"));

                System.out.println("Fetched from the list: " + item.toString()); //control, to check the execution

                personalList.add(item);
            }

            connection.close();

            return personalList;
        }

        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }

        return personalList;
    }

    public void deleteCommonItem(String name) {

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("DELETE FROM flatShoppingList WHERE Item = '" + name + "';"); // temp + task.getDescription() + ";");

            connection.close();

        }

        catch (SQLException exception) {
            System.out.println(exception);

        }

        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUserItem(String name) {

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("DELETE FROM personalShoppingList WHERE Item = '" + name + "' AND User = '" + UserInfo.getLoggedUser().getUsername() + "';"); // temp + task.getDescription() + ";");

            connection.close();

        }

        catch (SQLException exception) {
            System.out.println(exception);

        }

        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public static void saveTheItem (ShoppingItem item) {

        String name = item.getName();
        int amount = item.getAmount();

        try {

            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            int result;

            System.out.println(item.getDestination());

            if (Objects.equals(item.getDestination(), "personal")) {
                result = statement.executeUpdate("INSERT INTO personalShoppingList(Item, Amount, Status, User) VALUES ('" + item.getName() + "', '" + item.getAmount()  + "', 'to buy', '" + UserInfo.getLoggedUser().getUsername() + "');");
            }

            else
                if (Objects.equals(item.getDestination(), "common")) {
                    result = statement.executeUpdate("INSERT INTO flatShoppingList(Item, Amount, Status) VALUES ('" + item.getName() + "', '" + item.getAmount()  + "', 'to buy');");
                }

            connection.close();

        }

        catch (SQLException exception) {
            System.out.println(exception);
        }

        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
