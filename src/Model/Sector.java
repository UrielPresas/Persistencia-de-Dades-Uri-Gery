package Model;

public class Sector {
    private long id_sector;
    private String nom;
    private String coordenades;
    private String aproximacio;
    private int numero_vies;
    private String popularitat;
    private String restriccions;
    private long escola_id;

    public long getId_sector() {
        return id_sector;
    }

    public String getNom() {
        return nom;
    }

    public String getCoordenades() {
        return coordenades;
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

    public long getEscola_id() {
        return escola_id;
    }

    public void setId_sector(long id_sector) {
        this.id_sector = id_sector;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCoordenades(String coordenades) {
        this.coordenades = coordenades;
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

    public void setEscola_id(long escola_id) {
        this.escola_id = escola_id;
    }
}
