package DAO.Connexions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexioFactory {

    public static Connection getConnectionMySQL(){
        Properties prop = ConexionLoader.load();

        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String pass = prop.getProperty("db.pass");
        try{
            return DriverManager.getConnection(url,user,pass);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("No s'ha trobat els paràmetres de la sessió");
            return null;
        }
    }

    public static Connection getConnectionPostgres(){
        Properties prop = ConexionLoader.load();

        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String pass = prop.getProperty("db.pass");
        try{
            return DriverManager.getConnection(url,user,pass);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("No s'ha trobat els paràmetres de la sessió");
            return null;
        }
    }
}
