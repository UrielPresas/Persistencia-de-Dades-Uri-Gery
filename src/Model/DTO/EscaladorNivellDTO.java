package Model.DTO;

public class EscaladorNivellDTO {

    private String nom;
    private String alias;
    private String nivell_maxim;

    public EscaladorNivellDTO(String nom,
                              String alias,
                              String nivell_maxim) {

        this.nom = nom;
        this.alias = alias;
        this.nivell_maxim = nivell_maxim;
    }

    @Override
    public String toString() {

        return String.format(
                "%-20s %-20s %-15s",
                nom,
                alias,
                nivell_maxim
        );
    }
}