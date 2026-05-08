package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.SectorDAO;
import Model.DTO.SectorViesDTO;
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
        String sql = "INSERT INTO sector (nom, coordenades, aproximacio, numero_vies, popularitat, restriccions, escola_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexioFactory.getConnection("mysql");
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNom());
            ps.setString(2, c.getCoordenades());
            ps.setString(3, c.getAproximacio());
            ps.setInt(4, c.getNumero_vies());
            ps.setString(5, c.getPopularitat());
            ps.setString(6, c.getRestriccions());
            ps.setLong(7, c.getEscola_id());;

            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Sector c) {
        String sql = "UPDATE sector SET nom=?, coordenades=?, aproximacio=?, numero_vies=?, popularitat=?, restriccions=? WHERE id_sector=?";
        try (Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNom());
            ps.setString(2, c.getCoordenades());
            ps.setString(3, c.getAproximacio());
            ps.setInt(4, c.getNumero_vies());
            ps.setString(5, c.getPopularitat());
            ps.setString(6, c.getRestriccions());
            ps.setLong(7, c.getId_sector());

            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
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
        String sql = "SELECT * FROM sector WHERE id_sector = ?";
        try (Connection conn = ConexioFactory.getConnection("mysql");
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Sector s = new Sector();

                s.setId_sector(rs.getLong("id_sector"));
                s.setNom(rs.getString("nom"));
                s.setCoordenades(rs.getString("coordenades"));
                s.setAproximacio(rs.getString("aproximacio"));
                s.setNumero_vies(rs.getInt("numero_vies"));
                s.setPopularitat(rs.getString("popularitat"));
                s.setRestriccions(rs.getString("restriccions"));
                s.setEscola_id(rs.getLong("escola_id"));

                return s;

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public List<SectorViesDTO> obtindreSectorsAmbMesDeXVies(int minimVies) {

        List<SectorViesDTO> sectors = new ArrayList<>();

        String sql = """
        SELECT s.nom AS nom_sector,
               COUNT(v.id_via) AS total_vies,
               e.nom AS nom_escola
        FROM sector s
        JOIN escola e ON s.escola_id = e.id_escola
        JOIN via v ON v.sector_id = s.id_sector
        GROUP BY s.id_sector, s.nom, e.nom
        HAVING COUNT(v.id_via) > ?
        ORDER BY total_vies DESC
    """;

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, minimVies);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SectorViesDTO s = new SectorViesDTO(
                        rs.getString("nom_sector"),
                        rs.getInt("total_vies"),
                        rs.getString("nom_escola")
                );

                sectors.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sectors;
    }
}
