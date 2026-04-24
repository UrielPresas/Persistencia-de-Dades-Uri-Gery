package DAO.Connexions;
import java.sql.*;


public class ConnexioMySQL {

    public static void main(String[] args) {
        //Hacer un archivo de configuracion con los datos de las base de datos
        //Inputstream para leer el archivo con credenciales, con Properties
        String url = "jdbc:mysql://127.0.0.1:3306/Pillam";
        String user = "root";
        String pass = "Blanes2007!";
        String sql = "SELECT * FROM sector";


        try (
                Connection con = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_escalador") + " | " +
                                rs.getString("nom") + " | " +
                                rs.getString("alias") + " | " +
                                rs.getInt("edat") + " | " +
                                rs.getString("nivell_maxim") + " | " +
                                rs.getString("estil_preferit")  );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}
