package DAO.Connexions;

import java.io.InputStream;
import java.util.Properties;

public class ConexionLoader {
    public static Properties load(){
        Properties prop = new Properties();

        try(InputStream is = ConexionLoader.class
                .getClassLoader()
                .getResourceAsStream("db.properties")){
            prop.load(is);
        }catch (Exception e){
            e.printStackTrace();
        }
        return prop;
    }
}
