package Model;

public class Escola {
    private long id_escola;
    private String nom;
    private String lloc;
    private String aproximacio;
    private int numero_vies;
    private String popularitat;
    private String restriccions;

    public long getId_escola() {
        return id_escola;
    }

    public String getNom() {
        return nom;
    }

    public String getLloc() {
        return lloc;
    }

    public String getAproximacio() {
        return aproximacio;
    }

    public int getNumero_vies() {
        return numero_vies;
    }

    public String getPopularitat() {
        return popularitat;
    }

    public String getRestriccions() {
        return restriccions;
    }

    public void setId_escola(long id_escola) {
        this.id_escola = id_escola;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public void setAproximacio(String aproximacio) {
        this.aproximacio = aproximacio;
    }

    public void setNumero_vies(int numero_vies) {
        this.numero_vies = numero_vies;
    }

    public void setPopularitat(String popularitat) {
        this.popularitat = popularitat;
    }

    public void setRestriccions(String restriccions) {
        this.restriccions = restriccions;
    }

    @Override
    public String toString() {
        return
                id_escola + "\t\t" +
                nom + "\t\t" +
                lloc + "\t\t" +
                aproximacio + "\t\t" +
                numero_vies + "\t\t" +
                popularitat + "\t\t" +
                restriccions;
    }
}
