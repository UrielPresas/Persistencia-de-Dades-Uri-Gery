package Model.DTO;

public class SectorViesDTO {

    private String nom_sector;
    private int total_vies;
    private String nom_escola;

    public SectorViesDTO(String nom_sector,
                         int total_vies,
                         String nom_escola) {

        this.nom_sector = nom_sector;
        this.total_vies = total_vies;
        this.nom_escola = nom_escola;
    }

    @Override
    public String toString() {

        return String.format(
                "%-25s %-15d %-20s",
                nom_sector,
                total_vies,
                nom_escola
        );
    }
}