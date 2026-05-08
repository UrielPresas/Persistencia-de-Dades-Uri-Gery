package Model.DTO;

public class ViaLlargaDTO {

    private String nom_via;
    private int llargada;
    private String nom_sector;
    private String nom_escola;

    public ViaLlargaDTO(String nom_via,
                        int llargada,
                        String nom_sector,
                        String nom_escola) {

        this.nom_via = nom_via;
        this.llargada = llargada;
        this.nom_sector = nom_sector;
        this.nom_escola = nom_escola;
    }

    @Override
    public String toString() {

        return String.format(
                "%-25s %-15d %-20s %-20s",
                nom_via,
                llargada,
                nom_sector,
                nom_escola
        );
    }
}