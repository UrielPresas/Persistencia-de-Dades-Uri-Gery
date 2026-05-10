package Vista;

public class Headers {

    public static void viaHeader() {

        System.out.printf(
                "%-8s %-10s %-12s %-20s %-15s %-12s %-12s %-15s %-15s %-15s %-8s %-15s\n",
                "id_via",
                "sector_id",
                "creador_id",
                "nom",
                "tipus_via",
                "orientacio",
                "estat",
                "data_fi",
                "ancoratge",
                "tipus_roca",
                "grau",
                "restriccions"
        );
    }

    public static void escolaHeader() {

        System.out.printf(
                "%-10s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                "id_escola",
                "nom",
                "lloc",
                "aproximacio",
                "numero_vies",
                "popularitat",
                "restriccions"
        );
    }

    public static void sectorHeader() {

        System.out.printf(
                "%-12s %-20s %-15s %-15s %-15s %-15s %-15s %-10s\n",
                "id_sector",
                "nom",
                "coordenades",
                "aproximacio",
                "numero_vies",
                "popularitat",
                "restriccions",
                "escola_id"
        );
    }

    public static void escaladorHeader() {

        System.out.printf(
                "%-15s %-15s %-15s %-10s %-15s %-15s\n",
                "id_escalador",
                "nom",
                "alias",
                "edat",
                "nivell_maxim",
                "estil_preferit"
        );
    }

    public static void EscolaRestricionsActives() {

        System.out.printf(
                "%-20s %-20s %-30s\n",
                "ESCOLA",
                "LLOC",
                "RESTRICCIONS"
        );
    }

    public static void ViaRestriccioHeader(){
        System.out.printf(
                "%-8s %-15s %-15s %-20s %-15s %-12s %-15s %-15s %-15s %-15s %-8s %-15s\n",
                "id_via",
                "nom_sector",
                "nom_escola",
                "nom",
                "tipus_via",
                "orientacio",
                "estat",
                "data_fi_estat",
                "ancoratge",
                "tipus_roca",
                "grau",
                "restriccions"
        );    }
    public static void ViaDifHeader(){
        System.out.printf(
                "%-20s %-8s %-25s %-20s\n",
                "VIA",
                "GRAU",
                "SECTOR",
                "ESCOLA"
        );    }

    public static void ViesSegonEstat(){
        System.out.printf(
                "%-20s %-12s %-10s %-20s %-20s\n",
                "VIA",
                "TIPUS",
                "GRAU",
                "SECTOR",
                "ESCOLA"
        );    }

    public static void ViaApteFaPoc(){
        System.out.printf(
                "%-20s %-20s %-20s %-15s\n",
                "VIA",
                "SECTOR",
                "ESCOLA",
                "DATA_APTE"
        );
    }

    public static void ViaLlargada() {
        System.out.printf(
                "%-25s %-15s %-20s %-20s\n",
                "VIA",
                "LLARGADA",
                "SECTOR",
                "ESCOLA"
        );
    }

    public static void EscaladorMateixNivell(){

        System.out.printf(
                "%-20s %-20s %-15s\n",
                "NOM",
                "ALIAS",
                "NIVELL_MAXIM"
        );
    }

}