package com.codecool.shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>The Database Connection Object</h1>
 * <p>To get connection with the database</p>
 * @author Fanni Skoda
 * @since 2017.05.08.
 */
public class DbConnection {

    /**
     * To get the connection with the database, setup the user and password
     * @return This returns the connection object
     * @throws IOException
     * @throws SQLException
     */

    public Connection getConnection() throws IOException, SQLException {

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/connection.properties"));
        final String DATABASE = "jdbc:postgresql://" + br.readLine() + "/" + br.readLine();
        final String DB_USER = br.readLine();
        final String DB_PASSWORD = br.readLine();
        br.close();

        return DriverManager.getConnection(
                DATABASE,
                DB_USER,
                DB_PASSWORD);
    }

    /**
     * This method executes the given query
     * @param query This parameter represents the query what we want to execute
     */
    public void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
        ){
            statement.execute(query);
        }
        catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}