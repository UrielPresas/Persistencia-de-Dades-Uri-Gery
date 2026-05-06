package Model.DTO;

import java.time.LocalDate;

public class ViaTancadaDTO {

    private long id_via;
    private String nom_sector;
    private String nom_escola;
    private String nom;
    private String tipus_via;
    private String orientacio;
    private String estat;
    private LocalDate data_fi_estat;
    private String ancoratge;
    private String tipus_roca;
    private String grau;
    private boolean restriccions;

    public ViaTancadaDTO(long id_via,
                         String nom_sector,
                         String nom_escola,
                         String nom,
                         String tipus_via,
                         String orientacio,
                         String estat,
                         LocalDate data_fi_estat,
                         String ancoratge,
                         String tipus_roca,
                         String grau,
                         boolean restriccions) {

        this.id_via = id_via;
        this.nom_sector = nom_sector;
        this.nom_escola = nom_escola;
        this.nom = nom;
        this.tipus_via = tipus_via;
        this.orientacio = orientacio;
        this.estat = estat;
        this.data_fi_estat = data_fi_estat;
        this.ancoratge = ancoratge;
        this.tipus_roca = tipus_roca;
        this.grau = grau;
        this.restriccions = restriccions;
    }

    public long getId_via() {
        return id_via;
    }

    public String getNom_sector() {
        return nom_sector;
    }

    public String getNom_escola() {
        return nom_escola;
    }

    public String getNom() {
        return nom;
    }

    public String getTipus_via() {
        return tipus_via;
    }

    public String getOrientacio() {
        return orientacio;
    }

    public String getEstat() {
        return estat;
    }

    public LocalDate getData_fi_estat() {
        return data_fi_estat;
    }

    public String getAncoratge() {
        return ancoratge;
    }

    public String getTipus_roca() {
        return tipus_roca;
    }

    public String getGrau() {
        return grau;
    }

    public boolean isRestriccions() {
        return restriccions;
    }

    @Override
    public String toString() {
        return String.format(
                "%-8d %-15s %-15s %-20s %-15s %-12s %-15s %-15s %-15s %-15s %-8s %-15s",
                id_via,
                nom_sector,
                nom_escola,
                nom,
                tipus_via,
                orientacio,
                estat,
                data_fi_estat,
                ancoratge,
                tipus_roca,
                grau,
                restriccions
        );
    }
}