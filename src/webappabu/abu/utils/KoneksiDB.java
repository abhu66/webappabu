/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappabu.abu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author khoerulAbu
 */
public class KoneksiDB {
    
    private static Connection connection = null;

    public static Connection getConnection() throws IOException, SQLException {
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop         = new Properties();
                InputStream inputStream = KoneksiDB.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver   = prop.getProperty("driver");
                String url      = prop.getProperty("url");
                String user     = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException | IOException e) {
                System.out.print("Error : "+e.getMessage());
            }
            return connection;
        }

    }
}
