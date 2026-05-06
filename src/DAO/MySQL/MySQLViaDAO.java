package DAO.MySQL;

import DAO.ViaDAO;
import Model.DTO.ViaDifDTO;
import Model.DTO.ViaTancadaDTO;
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
        String sql = "UPDATE via SET nom=?, tipus_via=?, orientacio=?, estat=?, data_fi_estat=?, ancoratge=?, tipus_roca=?, grau=?, restriccions=? WHERE id_via=?";
        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNom());
            ps.setString(2, c.getTipus_via());
            ps.setString(3, c.getOrientacio());
            ps.setString(4, c.getEstat());
            //ps.setDate(5, java.sql.Date.valueOf(c.getData_fi_estat()));
            if (c.getData_fi_estat() != null) {
                ps.setDate(5, java.sql.Date.valueOf(c.getData_fi_estat()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }
            ps.setString(6, c.getAncoratge());
            ps.setString(7, c.getTipus_roca());
            ps.setString(8, c.getGrau());
            ps.setBoolean(9, c.isRestriccions());
            ps.setLong(10, c.getId_via());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

                Date data = rs.getDate("data_fi_estat");
                if(data != null){
                    v.setData_fi_estat(data.toLocalDate());
                }

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
        String sql = "SELECT * from via WHERE id_via = ?";
        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Via v = new Via();

                v.setId_via(rs.getLong("id_via"));
                v.setSector_id(rs.getLong("sector_id"));
                v.setCreador_id(rs.getLong("creador_id"));
                v.setNom(rs.getString("nom"));
                v.setTipus_via(rs.getString("tipus_via"));
                v.setOrientacio(rs.getString("orientacio"));
                v.setEstat(rs.getString("estat"));

                Date data = rs.getDate("data_fi_estat");
                if(data != null){
                    v.setData_fi_estat(data.toLocalDate());
                }

                v.setAncoratge(rs.getString("ancoratge"));
                v.setTipus_roca(rs.getString("tipus_roca"));
                v.setGrau(rs.getString("grau"));
                v.setRestriccions(rs.getBoolean("restriccions"));

                return v;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<ViaTancadaDTO> obtindreViesAmbRestriccionsPerEscola(long idEscola) {

        List<ViaTancadaDTO> vies = new ArrayList<>();

        String sql = """
        SELECT v.*, s.nom AS nom_sector, e.nom AS nom_escola
        FROM via v
        JOIN sector s ON v.sector_id = s.id_sector
        JOIN escola e ON s.escola_id = e.id_escola
        WHERE s.escola_id = ?
          AND v.restriccions = true
          AND v.data_fi_estat BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 14 DAY)
    """;

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, idEscola);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Date data = rs.getDate("data_fi_estat");

                ViaTancadaDTO v = new ViaTancadaDTO(
                        rs.getLong("id_via"),
                        rs.getString("nom_sector"),
                        rs.getString("nom_escola"),
                        rs.getString("nom"),
                        rs.getString("tipus_via"),
                        rs.getString("orientacio"),
                        rs.getString("estat"),
                        data != null ? data.toLocalDate() : null,
                        rs.getString("ancoratge"),
                        rs.getString("tipus_roca"),
                        rs.getString("grau"),
                        rs.getBoolean("restriccions")
                );

                vies.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vies;
    }

    public List<ViaDifDTO> cercarViesPerDificultat(String grauMin, String grauMax) {

        List<ViaDifDTO> vies = new ArrayList<>();

        String sql = """
        SELECT v.nom AS nom_via,
               v.grau,
               s.nom AS nom_sector,
               e.nom AS nom_escola
        FROM via v
        JOIN sector s ON v.sector_id = s.id_sector
        JOIN escola e ON s.escola_id = e.id_escola
        WHERE v.grau BETWEEN ? AND ?
        ORDER BY v.grau
    """;

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, grauMin);
            ps.setString(2, grauMax);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ViaDifDTO v = new ViaDifDTO(
                        rs.getString("nom_via"),
                        rs.getString("grau"),
                        rs.getString("nom_sector"),
                        rs.getString("nom_escola")
                );

                vies.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vies;
    }


}
