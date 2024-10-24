package com.kingazm.com.flatmate.system;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class InfoService {

    public static String getAddressInfo(){

        String adressInfo = "";

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT Street, Number, FlatNumber, Floor, PostCode, City, DoorCode FROM info LIMIT 1;");

            if (result.next()) {
                adressInfo = result.getString("Street") + " " + result.getInt("Number") + ", Flat no. " + result.getInt("FlatNumber") + ". " + result.getString("PostCode") + " " + result.getString("City") + ". " + "Doorcode: " + result.getString("DoorCode");

            }

            connection.close();
        }

        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }

        return adressInfo;
    }

    public static String getWiFiName(){

        String wifiName = "";

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT WiFiName FROM info LIMIT 1;");

            if (result.next()) {
                wifiName = result.getString("WiFiName");
            }

            connection.close();
        }

        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }

        return wifiName;
    }

    public static String getWiFiPassword(){

        String wifiPassword = "";

        try {
            Class.forName(DatabaseInfo.databaseDriver);
            Connection connection = DriverManager.getConnection(DatabaseInfo.databaseUrl, DatabaseInfo.databaseUsername, DatabaseInfo.databasePassword);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT WiFiPassword FROM info LIMIT 1;");

            if (result.next()) {
                wifiPassword = result.getString("WiFiPassword");
            }

            connection.close();
        }

        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }

        return wifiPassword;
    }


}
