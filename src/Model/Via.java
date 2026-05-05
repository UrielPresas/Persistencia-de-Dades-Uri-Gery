package Model;

//import java.util.Date;
import java.time.LocalDate;

public class Via {
    private long id_via;
    private long sector_id;
    private long creador_id;
    private String nom;
    private String tipus_via;
    private String orientacio;
    private String estat;
    //private Date data_fi_estat;
    private LocalDate data_fi_estat;
    private String ancoratge;
    private String tipus_roca;
    private String grau;
    private boolean restriccions;

    public long getId_via() {
        return id_via;
    }

    public long getSector_id() {
        return sector_id;
    }

    public long getCreador_id() {
        return creador_id;
    }

    public String getNom() {
        return nom;
    }

    public String getTipus_via() {
        return tipus_via;
    }

    public String getOrientacio() {
        return orientacio;
    }

    public String getEstat() {
        return estat;
    }

    public LocalDate getData_fi_estat() {
        return data_fi_estat;
    }

    public String getAncoratge() {
        return ancoratge;
    }

    public String getTipus_roca() {
        return tipus_roca;
    }

    public String getGrau() {
        return grau;
    }

    public boolean isRestriccions() {
        return restriccions;
    }

    public void setId_via(long id_via) {
        this.id_via = id_via;
    }

    public void setSector_id(long sector_id) {
        this.sector_id = sector_id;
    }

    public void setCreador_id(long creador_id) {
        this.creador_id = creador_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTipus_via(String tipus_via) {
        this.tipus_via = tipus_via;
    }

    public void setOrientacio(String orientacio) {
        this.orientacio = orientacio;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public void setData_fi_estat(LocalDate data_fi_estat) {
        this.data_fi_estat = data_fi_estat;
    }

    public void setAncoratge(String ancoratge) {
        this.ancoratge = ancoratge;
    }

    public void setTipus_roca(String tipus_roca) {
        this.tipus_roca = tipus_roca;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public void setRestriccions(boolean restriccions) {
        this.restriccions = restriccions;
    }

    @Override
    public String toString() {
        return
                id_via + "\t\t" +
                sector_id + "\t\t" +
                creador_id + "\t\t" +
                nom + "\t\t" +
                tipus_via + "\t\t" +
                orientacio + "\t\t" +
                estat + "\t\t" +
                data_fi_estat + "\t\t" +
                ancoratge + "\t\t" +
                tipus_roca + "\t\t" +
                grau + "\t\t" +
                restriccions;
    }
}
