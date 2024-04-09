package com.ispw.circularbook.engineering.connection;



import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// uso il pattern Singleton
public class ConnectionDB {

    private ConnectionDB() {
        // definisco il costruttore privato anche se vuoto perché in questo modo non viene preso il costruttore pubblico di default
        // così da vietare alle altre classi di fare la new di ConnectionDB
    }

    private static Connection connection;


    // se fosse stata un'applicazione multi thread avrei dovuto mettere "synchronized"
    public static Statement getConnection() throws ErrorConnectionDbException {
        Statement stmt ;
        try {
            conn();
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new ErrorConnectionDbException();
        }
        return stmt;
    }

    private static void conn() {
        String username;
        String password;
        String url;
        String driverClassName;

        if (connection == null) {
            try{
                Properties properties=loadProperties();
                username=properties.getProperty("USER");
                password=properties.getProperty("PASS");
                url=properties.getProperty("DB_URL");
                driverClassName=properties.getProperty("DRIVER_CLASS_NAME");

                Class.forName(driverClassName);

                connection=DriverManager.getConnection(url,username,password);

            } catch (SQLException | IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/com/ispw/circularbook/engineering/connection/connection.properties");
        properties.load(fileInputStream);
        return properties;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}