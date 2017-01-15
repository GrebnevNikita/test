package CRUD;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by futer25 on 10.01.2017.
 */
public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DBConnection() {
        CreateConnection();
    }

    public DBConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        CreateConnection();
    }

    public void CreateConnection() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, username, password);


        } catch (Exception e)

        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}
