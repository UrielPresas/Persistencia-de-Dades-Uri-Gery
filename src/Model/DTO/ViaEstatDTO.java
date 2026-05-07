package Model.DTO;

public class ViaEstatDTO {

    private String nom_via;
    private String grau;
    private String nom_sector;
    private String nom_escola;
    private String tipus_via;

    public ViaEstatDTO(String nom_via,
                       String grau,
                       String tipus_via,
                       String nom_sector,
                       String nom_escola) {

        this.nom_via = nom_via;
        this.grau = grau;
        this.tipus_via = tipus_via;
        this.nom_sector = nom_sector;
        this.nom_escola = nom_escola;
    }

    @Override
    public String toString() {

        return String.format(
                "%-20s %-12s %-10s %-20s %-20s",
                nom_via,
                tipus_via,
                grau,
                nom_sector,
                nom_escola
        );
    }
}