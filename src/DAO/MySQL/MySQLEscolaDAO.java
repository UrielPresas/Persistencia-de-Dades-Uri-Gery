package DAO.MySQL;



import DAO.Connexions.ConexioFactory;
import DAO.EscolaDAO;
import Model.Escola;
import Model.Sector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLEscolaDAO implements EscolaDAO {

    @Override
    public void inserir(Escola c) {

    }

    @Override
    public void modificar(Escola c) {

    }

    @Override
    public void eliminar(Escola c) {

    }

    @Override
    public List<Escola> obtindreTots() {

        List<Escola> escoles = new ArrayList<>();

        String sql = "SELECT * FROM escola";

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Escola e = new Escola();

                e.setId_escola(rs.getLong("id_escola"));
                e.setNom(rs.getString("nom"));
                e.setLloc(rs.getString("lloc"));
                e.setAproximacio(rs.getString("aproximacio"));
                e.setNumero_vies(rs.getInt("numero_vies"));
                e.setPopularitat(rs.getString("popularitat"));
                e.setRestriccions(rs.getString("restriccions"));
                escoles.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return escoles;
    }

    @Override
    public Escola obtenir(Long id) {
        return null;
    }
}
