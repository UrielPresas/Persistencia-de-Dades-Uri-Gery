package Model;

public class Escalador {
    private long id_escalador;
    private String nom;
    private String alias;
    private int edat;
    private String nivel_maxim;
    private String estil_preferit;

    public long getId_escalador() {
        return id_escalador;
    }

    public String getNom() {
        return nom;
    }

    public String getAlias() {
        return alias;
    }

    public int getEdat() {
        return edat;
    }

    public String getNivel_maxim() {
        return nivel_maxim;
    }

    public String getEstil_preferit() {
        return estil_preferit;
    }

    public void setId_escalador(long id_escalador) {
        this.id_escalador = id_escalador;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public void setNivel_maxim(String nivel_maxim) {
        this.nivel_maxim = nivel_maxim;
    }

    public void setEstil_preferit(String estil_preferit) {
        this.estil_preferit = estil_preferit;
    }
}
