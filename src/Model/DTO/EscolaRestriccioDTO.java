package Model.DTO;

public class EscolaRestriccioDTO {

    private String nom;
    private String lloc;
    private String restriccions;

    public EscolaRestriccioDTO(String nom,
                               String lloc,
                               String restriccions) {

        this.nom = nom;
        this.lloc = lloc;
        this.restriccions = restriccions;
    }

    @Override
    public String toString() {

        return String.format(
                "%-20s %-20s %-30s",
                nom,
                lloc,
                restriccions
        );
    }
}