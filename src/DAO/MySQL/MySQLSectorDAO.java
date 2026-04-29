package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.SectorDAO;
import Model.Sector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLSectorDAO implements SectorDAO {
    @Override
    public void inserir(Sector c) {

    }

    @Override
    public void modificar(Sector c) {

    }

    @Override
    public void eliminar(Sector c) {

    }

    @Override
    public List<Sector> obtindreTots() {
        List<Sector> sectors = new ArrayList<>();

        String sql = "SELECT * FROM sector";

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Sector s = new Sector();

                s.setId_sector(rs.getLong("id_sector"));
                s.setNom(rs.getString("nom"));
                s.setCoordenades(rs.getString("coordenades"));
                s.setAproximacio(rs.getString("aproximacio"));
                s.setNumero_vies(rs.getInt("numero_vies"));
                s.setPopularitat(rs.getString("popularitat"));
                s.setRestriccions(rs.getString("restriccions"));
                s.setEscola_id(rs.getLong("escola_id"));
                sectors.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sectors;
    }

    @Override
    public Sector obtenir(Long id) {
        return null;
    }
}
