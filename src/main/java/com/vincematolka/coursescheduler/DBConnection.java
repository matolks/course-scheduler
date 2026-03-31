package com.vincematolka.coursescheduler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    // Using embedded Apache Derby (local file-based DB).
    // For client-server mode, use: jdbc:derby://localhost:1527/dbName
    // 'create=true' will create the database if it does not exist.
    private static final String database = "jdbc:derby:courseSchedulerDB;create=true";

    public static Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                connection = DriverManager.getConnection(database);
            } catch (SQLException e)
            {
                e.printStackTrace();
                System.out.println("Could not open database.");
                System.exit(1);
            }
        }
        return connection;
    }

    
}
