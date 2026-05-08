package Model.DTO;

import java.time.LocalDate;

public class ViaApteDTO {

    private String nom_via;
    private String nom_sector;
    private String nom_escola;
    private LocalDate data_fi_estat;

    public ViaApteDTO(String nom_via,
                      String nom_sector,
                      String nom_escola,
                      LocalDate data_fi_estat) {

        this.nom_via = nom_via;
        this.nom_sector = nom_sector;
        this.nom_escola = nom_escola;
        this.data_fi_estat = data_fi_estat;
    }

    @Override
    public String toString() {

        return String.format(
                "%-20s %-20s %-20s %-15s",
                nom_via,
                nom_sector,
                nom_escola,
                data_fi_estat
        );
    }
}