package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.LlargDAO;
import Model.Llarg;
import Model.Via;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLLlargDAO implements LlargDAO {
    @Override
    public void inserir(Llarg c) {

    }

    @Override
    public void modificar(Llarg c) {

    }

    @Override
    public void eliminar(Llarg c) {

    }

    @Override
    public List<Llarg> obtindreTots() {

        List<Llarg> llargs = new ArrayList<>();

        String sql = "SELECT * FROM llarg";

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Llarg l = new Llarg();

                l.setId_llarg(rs.getLong("id_llarg"));
                l.setVia_id(rs.getInt("via_id"));
                l.setLlargada_llarg(rs.getInt("llargada_llarg"));
                l.setNºLlarg(rs.getInt("NºLlarg"));
                l.setLlargada_total(rs.getInt("llargada_total"));

                llargs.add(l);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llargs;

    }

    @Override
    public Llarg obtenir(Long id) {
        return null;
    }
}
