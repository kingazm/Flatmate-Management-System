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
