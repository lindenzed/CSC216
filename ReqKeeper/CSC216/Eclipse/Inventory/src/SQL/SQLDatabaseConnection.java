package SQL;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:mysql://localhost:3306/mytestdatabase?user=root&password=1Caroline";
                        //+ "database=mytestdatabase;"
                       // + "user=root@localhost;"
                       // + "password=1Caroline;"
                       // + "encrypt=true;"
                      //  + "trustServerCertificate=false;"
                       // + "loginTimeout=30;";
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
        		java.sql.Statement statement = connection.createStatement();) {
            String selectSql = "SELECT NAME,AGE FROM import WHERE NAME LIKE 'A%'";
            Scanner s = new Scanner(System.in);
            String firstName = s.nextLine();
            String addName = "INSERT INTO import (ID, NAME, AGE) VALUES ('11', '" + firstName + "', '1')";
            System.out.println(addName);
            statement.execute(addName);
            s.close();
            resultSet = statement.executeQuery(selectSql);
            
            //Print Results
            while (resultSet.next()) {
            	System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}