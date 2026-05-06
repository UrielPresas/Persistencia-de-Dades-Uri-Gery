package Model.DTO;

public class ViaDifDTO {

    private String nom_via;
    private String grau;
    private String nom_sector;
    private String nom_escola;

    public ViaDifDTO(String nom_via,
                     String grau,
                     String nom_sector,
                     String nom_escola) {

        this.nom_via = nom_via;
        this.grau = grau;
        this.nom_sector = nom_sector;
        this.nom_escola = nom_escola;
    }

    public String getNom_via() {
        return nom_via;
    }

    public String getGrau() {
        return grau;
    }

    public String getNom_sector() {
        return nom_sector;
    }

    public String getNom_escola() {
        return nom_escola;
    }

    @Override
    public String toString() {
        return String.format(
                "%-20s %-8s %-25s %-20s",
                nom_via,
                grau,
                nom_sector,
                nom_escola
        );
    }
}