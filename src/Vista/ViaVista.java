package Vista;

import DAO.MySQL.MySQLEscolaDAO;
import DAO.MySQL.MySQLViaDAO;
import DAO.ViaDAO;
import Model.DTO.ViaApteDTO;
import Model.DTO.ViaDifDTO;
import Model.DTO.ViaEstatDTO;
import Model.DTO.ViaLlargaDTO;
import Model.Escola;
import Model.Via;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ViaVista {


    public static void crudVies(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n-------------------VIES-------------------\n" +
                            "1. Crear Via\n" +
                            "2. Modificar Via\n" +
                            "3. Llistar Via\n" +
                            "4. Eliminar Via\n" +
                            "0. Sortir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    inserirVia();
                    break;
                case 2:
                    modificarVia();
                    break;
                case 3:
                    llistarVies();
                    break;
                case 4:
                    eliminarVia();
                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }


    private static void inserirVia() {
        Scanner sc = new Scanner(System.in);
        Via via = new Via();
        ViaDAO viaDAO = new MySQLViaDAO();

        // SECTOR
        System.out.println("Introdueix el sector_id:");
        long sector_id = Long.parseLong(sc.nextLine());
        if (sector_id == 0) return;
        via.setSector_id(sector_id);

        // CREADOR
        System.out.println("Introdueix el creador_id:");
        long creador_id = Long.parseLong(sc.nextLine());
        if (creador_id == 0) return;
        via.setCreador_id(creador_id);

        // NOM
        System.out.println("Introdueix el nom:");
        String nom = sc.nextLine();
        if (nom.isBlank()) {
            System.out.println("Nom obligatori");
            return;
        }
        via.setNom(nom);

        // TIPUS VIA (CLAVE DEL FLUJO)
        System.out.println("Tipus via (esportiva, classica, gel):");
        String tipus_via = sc.nextLine().toLowerCase();

        if (tipus_via.isBlank()) {
            System.out.println("Tipus via obligatori");
            return;
        }
        via.setTipus_via(tipus_via);

        // ORIENTACIÓ
        System.out.println("Orientació (N,NE,NO,SE,SO,E,O,S):");
        String orientacio = sc.nextLine();
        via.setOrientacio(orientacio);

        // ESTAT
        System.out.println("Estat (apte, construccio, tancada):");
        String estat = sc.nextLine();
        via.setEstat(estat);

        via.aplicarReglesEstat();

        // DATA FI ESTAT si cal
        if (via.isRestriccions()) {
            System.out.println("Data fi estat (YYYY-MM-DD):");
            String data = sc.nextLine();
            if (!data.isBlank()) {
                via.setData_fi_estat(LocalDate.parse(data));
            }
        }

        // ANCORATGE SEGONS TIPUS VIA
        String ancoratge = "";

        switch (tipus_via) {

            case "esportiva":
                System.out.println("Ancoratge (spits, parabolts, químics):");
                ancoratge = sc.nextLine();

                if (!ancoratge.matches("spits|parabolts|químics")) {
                    System.out.println("Ancorage no vàlid per via esportiva");
                    return;
                }
                break;

            case "classica":
                System.out.println("Ancoratge (friends, tascons, bagues, pitons, Tricams, BigBros, spits, parabolts, químics):");
                ancoratge = sc.nextLine();

                if (!ancoratge.matches("friends|tascons|bagues|pitons|Tricams|BigBros|spits|parabolts|químics")) {
                    System.out.println("Ancorage no vàlid per via clàssica");
                    return;
                }
                break;

            case "gel":
                System.out.println("Ancoratge (friends, tascons, bagues, pitons, Tricams, BigBros, cargols gel):");
                ancoratge = sc.nextLine();

                if (!ancoratge.matches("friends|tascons|bagues|pitons|Tricams|BigBros|cargols gel")) {
                    System.out.println("Ancorage no vàlid per via de gel");
                    return;
                }
                break;

            default:
                System.out.println("Tipus de via no vàlid");
                return;
        }

        via.setAncoratge(ancoratge);

        // TIPUS ROCA
        System.out.println("Tipus roca (conglomerat, granit, calcaria, arenisca, altres):");
        String roca = sc.nextLine();

        if (!roca.matches("conglomerat|granit|calcaria|arenisca|altres")) {
            System.out.println("Tipus de roca no vàlid");
            return;
        }

        via.setTipus_roca(roca);

        // GRAU
        System.out.println("Grau:");
        String grau = sc.nextLine();
        via.setGrau(grau);

        // INSERT
        viaDAO.inserir(via);
        System.out.println("Via inserida correctament");
    }

    private static void modificarVia(){
        Scanner sc = new Scanner(System.in);

        //Mostar totes les vies
        ViaDAO viaDAO = new MySQLViaDAO();
        List<Via> vies = viaDAO.obtindreTots();
        Headers.viaHeader();
        for(Via v : vies){
            System.out.println(v);
        }

        //Demanar via específica per ID
        System.out.println("ID de la via: \n0 per sortir");
        long id = Long.parseLong(sc.nextLine());
        if(id == 0){
            return;
        }

        //Buscar Via per ID
        Via via = viaDAO.obtenir(id);

        //Comprovació de l'existència de la Via
        if(via == null){
            System.out.println("Via no trobada");
            return;
        }

        //Demanar canvis

        //Nom
        System.out.println("Nom (" + via.getNom() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String nom = sc.nextLine();

        if(!nom.isBlank()){
            via.setNom(nom);
        }

        //Tipus_via
        System.out.println("Tipus_via (" + via.getTipus_via() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String tipus_via = sc.nextLine();

        if(!tipus_via.isBlank()){
            via.setTipus_via(tipus_via);
        }

        //Orientacio
        System.out.println("Orientacio (" + via.getOrientacio() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String orientacio = sc.nextLine();

        if(!orientacio.isBlank()){
            via.setOrientacio(orientacio);
        }

        //Estat
        System.out.println("Estat (" + via.getEstat() + ") pressiona 'Enter' si no vols modificar-lo: \nESTATS: apte | construccio | tancada");
        String estat = sc.nextLine();

        if(!estat.isBlank()){
            via.setEstat(estat);
        }
        //Trucar funcio de logica de la via
        via.aplicarReglesEstat();

        if(via.isRestriccions()){

            System.out.println("Data_Fi_Estat (" + via.getData_fi_estat() + ") pressiona 'Enter' si no vols modificar-lo: \nFORMAT: YYYY-MM-DD");
            String data = sc.nextLine();

            if(!data.isBlank()){
                via.setData_fi_estat(LocalDate.parse(data));
            }
        }

        //Ancoratge
        System.out.println("Ancoratge (" + via.getAncoratge() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String ancoratge = sc.nextLine();

        if(!ancoratge.isBlank()){
            via.setAncoratge(ancoratge);
        }

        //Tipus_Roca
        System.out.println("Tipus_Roca (" + via.getTipus_roca() + ") pressiona 'Enter' si vols modificar-lo: ");
        String tipus_roca = sc.nextLine();

        if(!tipus_roca.isBlank()){
            via.setTipus_roca(tipus_roca);
        }

        //Grau
        System.out.println("Grau (" + via.getGrau() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String grau = sc.nextLine();

        if(!grau.isBlank()){
            via.setGrau(grau);
        }

        //Guardar els canvis a la BD
        viaDAO.modificar(via);
        System.out.println("Via modificada correctament");
    }

    private static void llistarVies(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n------LLISTAR VIES------\n" +
                            "1. Llistar una Via\n" +
                            "2. Llistar totes\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    llistarUnaVia();
                    break;
                case 2:
                    System.out.println("Llistant totes les vies...");
                    ViaDAO viaDAO = new MySQLViaDAO();
                    List<Via> vies = viaDAO.obtindreTots();
                    Headers.viaHeader();
                    for(Via v : vies){
                        System.out.println(v);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }

    private static void eliminarVia(){
        Scanner sc = new Scanner(System.in);

        ViaDAO viaDAO = new MySQLViaDAO();

        // Mostrar totes
        List<Via> vies = viaDAO.obtindreTots();
        Headers.viaHeader();

        for(Via v : vies){
            System.out.println(v);
        }

        // Demanar ID
        System.out.println("Introdueix ID de la via a eliminar (0 per sortir):");
        long id = Long.parseLong(sc.nextLine());

        if(id == 0){
            return;
        }

        Via via = viaDAO.obtenir(id);

        if(via == null){
            System.out.println("Via no trobada");
            return;
        }

        // Confirmació
        System.out.println("Segur que vols eliminar la via " + via.getNom() + "? (s/n)");
        String confirmacio = sc.nextLine();

        if(confirmacio.equalsIgnoreCase("s")){
            viaDAO.eliminar(via);
        } else {
            System.out.println("Eliminació cancel·lada");
        }
    }

    private static void llistarUnaVia(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n------Filtres Vies------\n" +
                            "1. Mostrar per dificultat\n" +
                            "2. Mostrar segons estat\n" +
                            "3. Vies que han passat a Apte\n" +
                            "4. Vies més llargues d'una escola\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    mostrarViesPerDificultat();
                    break;
                case 2:
                    mostrarViesPerEstat();
                    break;
                case 3:
                    mostrarViesApteRecents();
                    break;
                case 4:
                    mostrarViesMesLlarguesPerEscola();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }

    private static void mostrarViesPerDificultat() {

        Scanner sc = new Scanner(System.in);

        MySQLViaDAO viaDAO = new MySQLViaDAO();

        System.out.print("Introdueix grau mínim: ");
        String grauMin = sc.nextLine();

        System.out.print("Introdueix grau màxim: ");
        String grauMax = sc.nextLine();

        List<ViaDifDTO> vies =
                viaDAO.cercarViesPerDificultat(grauMin, grauMax);

        System.out.println("\n--- VIES PER DIFICULTAT ---\n");

        Headers.ViaDifHeader();

        if (vies.isEmpty()) {
            System.out.println("No s'han trobat vies.");
        } else {
            vies.forEach(System.out::println);
        }
    }
    private static void mostrarViesPerEstat() {

        Scanner sc = new Scanner(System.in);

        MySQLViaDAO viaDAO = new MySQLViaDAO();

        System.out.print("Introdueix estat (apte/construccio/tancada): ");
        String estat = sc.nextLine();

        List<ViaEstatDTO> vies =
                viaDAO.cercarViesPerEstat(estat);

        System.out.println("\n--- VIES SEGONS ESTAT ---\n");

        Headers.ViesSegonEstat();

        if (vies.isEmpty()) {
            System.out.println("No s'han trobat vies.");
        } else {
            vies.forEach(System.out::println);
        }
    }

    private static void mostrarViesApteRecents() {

        MySQLViaDAO viaDAO = new MySQLViaDAO();

        List<ViaApteDTO> vies =
                viaDAO.obtindreViesApteRecents();

        System.out.println(
                "\n--- VIES QUE HAN PASSAT A APTE EN ELS ÚLTIMS 14 DIES ---\n"
        );



        if (vies.isEmpty()) {
            Headers.ViaApteFaPoc();
            System.out.println("No hi ha vies recents.");

        } else {

            vies.forEach(System.out::println);
        }
    }


    private static void mostrarViesMesLlarguesPerEscola() {

        Scanner sc = new Scanner(System.in);

        MySQLEscolaDAO escolaDAO = new MySQLEscolaDAO();
        MySQLViaDAO viaDAO = new MySQLViaDAO();

        List<Escola> escoles = escolaDAO.obtindreTots();

        System.out.println("\n--- ESCOLES DISPONIBLES ---\n");

        for (int i = 0; i < escoles.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + escoles.get(i).getNom()
            );
        }

        System.out.print("\nSelecciona una escola: ");
        int opcio = sc.nextInt();

        if (opcio < 1 || opcio > escoles.size()) {

            System.out.println("Opció no vàlida.");
            return;
        }

        Escola escolaSeleccionada = escoles.get(opcio - 1);

        List<ViaLlargaDTO> vies =
                viaDAO.obtindreViesMesLlarguesPerEscola(
                        escolaSeleccionada.getId_escola()
                );

        System.out.println(
                "\n--- VIES MÉS LLARGUES DE "
                        + escolaSeleccionada.getNom().toUpperCase()
                        + " ---\n"
        );



        if (vies.isEmpty()) {

            System.out.println("No hi ha vies.");

        } else {
            Headers.ViaLlargada();
            vies.forEach(System.out::println);
        }
    }
}
