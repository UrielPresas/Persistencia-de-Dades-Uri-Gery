package Model;

public class Escalador {
    private long id_escalador;
    private String nom;
    private String alias;
    private int edat;
    private String nivell_maxim;
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

    public String getNivell_maxim() {
        return nivell_maxim;
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

    public void setNivell_maxim(String nivell_maxim) {
        this.nivell_maxim = nivell_maxim;
    }

    public void setEstil_preferit(String estil_preferit) {
        this.estil_preferit = estil_preferit;
    }

    @Override
    public String toString() {
        return
                id_escalador + "\t\t" +
                nom + "\t\t" +
                alias + "\t\t" +
                edat + "\t\t" +
                nivell_maxim + "\t\t" +
                estil_preferit;
    }
}
