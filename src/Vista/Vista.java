package Vista;

import DAO.EscaladorDAO;
import DAO.EscolaDAO;
import DAO.MySQL.MySQLEscaladorDAO;
import DAO.MySQL.MySQLEscolaDAO;
import DAO.MySQL.MySQLSectorDAO;
import DAO.MySQL.MySQLViaDAO;
import DAO.SectorDAO;
import DAO.ViaDAO;
import Model.Escalador;
import Model.Escola;
import Model.Sector;
import Model.Via;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Vista {

    public static void vistaMainMenu(Connection conn){
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n-------------------Pillam Ltd. Co.-------------------\n" +
                            "1. Vies\n" +
                            "2. Escoles\n" +
                            "3. Sectors\n" +
                            "4. Escaladors\n" +
                            "0. Sortir");

            System.out.print("Escull una opció: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    crudVies();
                    break;
                case 2:
                    crudEscoles();
                    break;
                case 3:
                    crudSector();
                    break;
                case 4:
                    crudEscaladors();
                    break;
                case 0:
                    System.out.println("Sortint del programa");
                    break;
                default:
                    System.out.println("Opció no vàlida ");
            }

        } while (opcion != 0);

    }

    private static void crudVies(){

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

            switch (opcion){
                case 1:
                    System.out.println("Crear Via...");
                    break;
                case 2:
                    viaHeader();
                    modificarVia();
                    break;
                case 3:
                    llistarVies();
                    break;
                case 4:
                    System.out.println("Eliminar Via...");
                    break;
                case 0:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }

    private static void crudEscoles(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n-------------------ESCOLES-------------------\n" +
                            "1. Crear Escola\n" +
                            "2. Modificar Escola\n" +
                            "3. Llistar Escola\n" +
                            "4. Eliminar Escola\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Crear Escola...");
                    break;
                case 2:
                    System.out.println("Modificar Escola...");
                    break;
                case 3:
                    llistarEscoles();
                    break;
                case 4:
                    System.out.println("Eliminar Escola...");
                    break;
                case 0:
                    System.out.println("Tornant...");
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }
    private static void crudSector(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n-------------------SECTORS-------------------\n" +
                            "1. Crear Sector\n" +
                            "2. Modificar Sector\n" +
                            "3. Llistar Sector\n" +
                            "4. Eliminar Sector\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Crear Sector...");
                    break;
                case 2:
                    System.out.println("Modificar Sector...");
                    break;
                case 3:
                    llistarSectors();
                    break;
                case 4:
                    System.out.println("Eliminar Sector...");
                    break;
                case 0:
                    System.out.println("Tornant...");
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }
    private static void crudEscaladors(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n-------------------ESCALADORS-------------------\n" +
                            "1. Crear Escalador\n" +
                            "2. Modificar Escalador\n" +
                            "3. Llistar Escaladors\n" +
                            "4. Eliminar Escalador\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Crear Escalador...");
                    break;
                case 2:
                    System.out.println("Modificar Escalador...");
                    break;
                case 3:
                    llistarEscaladors();
                    break;
                case 4:
                    System.out.println("Eliminar Escalador...");
                    break;
                case 0:
                    System.out.println("Tornant...");
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
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
                    viaHeader();
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

    private static void llistarEscoles(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n-------------------Llistar Escoles-------------------\n" +
                            "1. Llistar una Escola\n" +
                            "2. Llistar Totes\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    llistarUnaEscola();
                    break;
                case 2:
                    System.out.println("Llistant totes les escoles...");
                    EscolaDAO escolaDAO = new MySQLEscolaDAO();
                    List<Escola> escoles = escolaDAO.obtindreTots();
                    escolaHeader();
                    for(Escola e : escoles){
                        System.out.println(e);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }

    private static void llistarSectors(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n-------------------Llistar Sectors-------------------\n" +
                            "1. Llistar un Sector\n" +
                            "2. Llistar Tots\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    llistarUnSector();
                    break;
                case 2:
                    System.out.println("Llistant tots els sectors...");
                    SectorDAO sectorDAO = new MySQLSectorDAO();
                    List<Sector> sectors = sectorDAO.obtindreTots();
                    sectorHeader();
                    for(Sector s : sectors){
                        System.out.println(s);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }

    private static void llistarEscaladors(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n-------------------Llistar Escaladors-------------------\n" +
                            "1. Llistar un Escalador\n" +
                            "2. Llistar Tots\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    llistarUnEscalador();
                    break;
                case 2:
                    System.out.println("Llistant tots els escaladors...");
                    EscaladorDAO escaladorDAO = new MySQLEscaladorDAO();
                    List<Escalador> escaladors = escaladorDAO.obtindreTots();
                    escaladorHeader();
                    for (Escalador e : escaladors){
                        System.out.println(e);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
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
                    System.out.println("Filtrar per dificultat...");
                    break;
                case 2:
                    System.out.println("Filtrar per estat...");
                    break;
                case 3:
                    System.out.println("Vies passades a Apte...");
                    break;
                case 4:
                    System.out.println("Vies més llargues...");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }

    private static void llistarUnaEscola(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n------Filtres Escoles------\n" +
                            "1. Escoles amb restriccions actives\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Mostrant escoles amb restriccions...");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }

    private static void llistarUnSector(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n------Filtres Sectors------\n" +
                            "1. Sectors amb més de X vies\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Mostrant sectors amb moltes vies...");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }

    private static void llistarUnEscalador(){

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "\n------Filtres Escaladors------\n" +
                            "1. Escaladors amb mateix nivell màxim\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Mostrant escaladors amb mateix nivell...");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }

    private static void modificarVia(){
        Scanner sc = new Scanner(System.in);

        //Mostar totes les vies
        ViaDAO viaDAO = new MySQLViaDAO();
        List<Via> vies = viaDAO.obtindreTots();
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
        System.out.println("Estat (" + via.getEstat() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String estat = sc.nextLine();

        if(!estat.isBlank()){
            via.setEstat(estat);
        }

        //Data_Fi_Estat
        System.out.println("Data_Fi_Estat (" + via.getData_fi_estat() + ") pressiona 'Enter' si no vols modificar-lo: \nFORMAT: YYYY-MM-DD");
        String data_fi_estat = sc.nextLine();

        if(!data_fi_estat.isBlank()){
            via.setData_fi_estat(LocalDate.parse(data_fi_estat));
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

        //Restriccions
        System.out.println("Restriccions (" + via.isRestriccions() + ") pressiona 'Enter' si no vols modificar-lo:");
        String restriccions = sc.nextLine();

        if(!restriccions.isBlank()){
            via.setRestriccions(Boolean.parseBoolean(restriccions));
        }
    }

    private static void viaHeader(){
        System.out.println("id_via | sector_id | creador_id | nom | tipus_via | orientacio | estat | data_fi_estat | ancoratge | tipus_roca | grau | restriccions");
    }

    private static void escolaHeader(){
        System.out.println("id_escola | nom | lloc | aproximacio | numero_vies | popularitat | restriccions");
    }

    private static void sectorHeader(){
        System.out.println("id_sector | nom | coordenades | aproximacio | numero_vies | popularitat | restriccions | escola_id");
    }

    private static void escaladorHeader(){
        System.out.println("id_escalador | nom | alias | edat | nivell_maxim | estil_preferit");
    }

}