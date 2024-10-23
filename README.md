# Flatmate Management System
A managent platorm that improves experience of sharing a flat. Core functionalities include user and role-based access to CRUD operations on tasks and shopping lists, Spring Security login and easy access to key data about the place you live in. The project is still actively developed, so more functionalities are in progress. 

# Demo
Soon!

# Tech stack
Java (Springboot, Spring Security, JDBC), MySQL database, HTML with Thymeleaf templates, CSS & Bootstrap.

# Before you jump to the files
Caution: The repo is missing some files that ensure that the application runs smoothly in the production, i.e. application.properties and DatabaseInfo.java class, as they include login information to the MySQL Database.
However, it just takes creating those and the database tables as below:

application.properties in com.flatmate.system\src\main\resources
```
spring.application.name=com.flatmate.system
spring.datasource.username=<yourdatabaselogin>
spring.datasource.password=<yourdatabasepassword>
spring.datasource.drive-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://<yourdatabaseurl, locally something like localhost:3360>
```

DatabaseInfo.java in com.flatmate.system\src\main\java\com\kingazm\com\flatmate\system
```
package com.kingazm.com.flatmate.system;
import org.springframework.beans.factory.annotation.Value;

public class DatabaseInfo {

    public final static String databaseUrl = "jdbc:mysql://<yourdatabaseurl>";;
    public final static String databasePassword = "<yourdatabasepassword>";
    public final static String databaseUsername = "<yourdatabaselogin>";
    public final static String databaseDriver = "com.mysql.cj.jdbc.Driver";
}
```

Code for setting up the database
```
CREATE DATABASE flatmatesdb;
USE flatmatesdb;

CREATE table personalShoppingList (
    Item VARCHAR(40) NOT NULL,
    Amount INT,
    User VARCHAR(20),
    Status ENUM('to buy', 'bought'),
    PRIMARY KEY(Item)
);

CREATE table flatShoppingList (
    Item VARCHAR(40) NOT NULL,
    Amount INT,
    Status ENUM('to buy', 'bought'),
    PRIMARY KEY(Item)
);

CREATE table tasks (
    Id INT NOT NULL AUTO_INCREMENT,
    Description VARCHAR(50),
    Category VARCHAR(20),
    AssignedUser VARCHAR(20),
    Deadline DATETIME,
    Priority ENUM('HIGH', 'MEDIUM', 'LOW'),
    Status ENUM('TO DO', 'DONE', 'IN PROGRESS'),
    PRIMARY KEY(Id)
);

CREATE TABLE users(
    Id int NOT NULL auto_increment,
    Username VARCHAR(20),
    Email VARCHAR(320),
    Password VARCHAR(20),
    Role ENUM('ADMIN', 'USER'),
    PRIMARY KEY(Id)
);
    
CREATE TABLE info(
    Street VARCHAR(100),
    Number INT,
    FlatNumber INT,
    Floor INT,
    PostCode VARCHAR(6),
    City VARCHAR(20),
    DoorCode VARCHAR(20),
    WiFiName VARCHAR(20),
    WiFiPassword VARCHAR(50)
);
    
```
