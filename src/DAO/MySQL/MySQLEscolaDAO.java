package DAO.MySQL;



import DAO.Connexions.ConexioFactory;
import DAO.EscolaDAO;
import Model.DTO.EscaladorNivellDTO;
import Model.DTO.EscolaRestriccioDTO;
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
        String sql = "INSERT INTO escola (nom, lloc, aproximacio, numero_vies, popularitat, restriccions) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNom());
            ps.setString(2, c.getLloc());
            ps.setString(3, c.getAproximacio());
            ps.setInt(4, c.getNumero_vies());
            ps.setString(5, c.getPopularitat());
            ps.setString(6, c.getRestriccions());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Escola c) {
        String sql = "UPDATE escola SET nom=?, lloc=?, aproximacio=?, numero_vies=?, popularitat=?, restriccions=? WHERE id_escola=?";
        try (Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNom());
            ps.setString(2, c.getLloc());
            ps.setString(3, c.getAproximacio());
            ps.setInt(4, c.getNumero_vies());
            ps.setString(5, c.getPopularitat());
            ps.setString(6, c.getRestriccions());
            ps.setLong(7, c.getId_escola());

            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Escola c) {
        String sql = "DELETE FROM escola WHERE id_escola = ?";

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, c.getId_escola());

            int files = ps.executeUpdate();

            if(files > 0){
                System.out.println("Escola eliminada correctament");
            } else {
                System.out.println("No s'ha trobat l'escola");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        String sql = "SELECT * FROM escola WHERE id_escola = ?";
        try (Connection conn = ConexioFactory.getConnection("mysql");
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Escola e = new Escola();

                e.setId_escola(rs.getLong("id_escola"));
                e.setNom(rs.getString("nom"));
                e.setLloc(rs.getString("lloc"));
                e.setAproximacio(rs.getString("aproximacio"));
                e.setNumero_vies(rs.getInt("numero_vies"));
                e.setPopularitat(rs.getString("popularitat"));
                e.setRestriccions(rs.getString("restriccions"));

                return e;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<EscolaRestriccioDTO> obtindreEscolesAmbRestriccions() {

        List<EscolaRestriccioDTO> escoles = new ArrayList<>();

        String sql = """
        SELECT nom, lloc, restriccions
        FROM escola
        WHERE restriccions IS NOT NULL
          AND restriccions <> 'cap'
    """;

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                EscolaRestriccioDTO e = new EscolaRestriccioDTO(
                        rs.getString("nom"),
                        rs.getString("lloc"),
                        rs.getString("restriccions")
                );

                escoles.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return escoles;
    }

}
