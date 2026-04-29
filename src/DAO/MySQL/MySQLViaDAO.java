package DAO.MySQL;

import DAO.ViaDAO;
import Model.Via;
import DAO.Connexions.ConexioFactory;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLViaDAO implements ViaDAO {
    @Override
    public void inserir(Via c) {

    }

    @Override
    public void modificar(Via c) {

    }

    @Override
    public void eliminar(Via c) {

    }

    @Override
    public List<Via> obtindreTots() {

        List<Via> vies = new ArrayList<>();

        String sql = "SELECT * FROM via";

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Via v = new Via();

                v.setId_via(rs.getLong("id_via"));
                v.setSector_id(rs.getLong("sector_id"));
                v.setCreador_id(rs.getLong("creador_id"));
                v.setNom(rs.getString("nom"));
                v.setTipus_via(rs.getString("tipus_via"));
                v.setOrientacio(rs.getString("orientacio"));
                v.setEstat(rs.getString("estat"));
                v.setData_fi_estat(rs.getDate("data_fi_estat"));
                v.setAncoratge(rs.getString("ancoratge"));
                v.setTipus_roca(rs.getString("tipus_roca"));
                v.setGrau(rs.getString("grau"));
                v.setRestriccions(rs.getBoolean("restriccions"));

                vies.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vies;
    }

    @Override
    public Via obtenir(Long id) {
        return null;
    }


}
