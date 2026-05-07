package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.EscaladorDAO;
import Model.Escalador;
import Model.Via;
import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLEscaladorDAO implements EscaladorDAO {

    @Override
    public void inserir(Escalador c) {

    }

    @Override
    public void modificar(Escalador c) {
        String sql = "UPDATE escalador SET nom=?, alias=?, edat=?, nivell_maxim=?, estil_preferit=? WHERE id_escalador=?";
        try (Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNom());
            ps.setString(2, c.getAlias());
            ps.setInt(3, c.getEdat());
            ps.setString(4, c.getNivell_maxim());
            ps.setString(5, c.getEstil_preferit());
            ps.setLong(6, c.getId_escalador());

            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Escalador c) {

    }

    @Override
    public List<Escalador> obtindreTots() {

        List<Escalador> escaladors = new ArrayList<>();

        String sql = "SELECT * FROM escalador";

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Escalador e = new Escalador();

                e.setId_escalador(rs.getLong("id_escalador"));
                e.setNom(rs.getString("nom"));
                e.setAlias(rs.getString("alias"));
                e.setEdat(rs.getInt("edat"));
                e.setNivell_maxim(rs.getString("nivell_maxim"));
                e.setEstil_preferit(rs.getString("estil_preferit"));

                escaladors.add(e);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return escaladors;

    }

    @Override
    public Escalador obtenir(Long id) {
        String sql = "SELECT * FROM escalador WHERE id_escalador = ?";
        try (Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Escalador e = new Escalador();

                e.setId_escalador(rs.getLong("id_escalador"));
                e.setNom(rs.getString("nom"));
                e.setAlias(rs.getString("alias"));
                e.setEdat(rs.getInt("edat"));
                e.setNivell_maxim(rs.getString("nivell_maxim"));
                e.setEstil_preferit(rs.getString("estil_preferit"));

                return e;

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
