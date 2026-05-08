package Vista;

import DAO.EscaladorDAO;
import DAO.EscolaDAO;
import DAO.MySQL.MySQLEscaladorDAO;
import DAO.MySQL.MySQLEscolaDAO;
import DAO.MySQL.MySQLSectorDAO;
import DAO.MySQL.MySQLViaDAO;
import DAO.SectorDAO;
import DAO.ViaDAO;
import Model.DTO.*;
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
                    modificarEscola();
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
                    inserirSector();
                    break;
                case 2:
                    modificarSector();
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
                    modificarEscalador();
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
                            "2. Llistar Vies per dificultat\n"+
                            "3. Llistar Vies per estat\n" +
                            "4. Llistar totes\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    llistarUnaVia();
                    break;
                case 2:
                    mostrarViesPerDificultat();
                    break;
                case 3:
                    mostrarViesPerEstat();
                    break;
                case 4:
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
                            "1. Vies amb restriccions actives d'una escola \n" +
                            "2. Escoles amb restriccions actives\n" +
                            "0. Sortir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    mostrarViesPerEscolaAmbRestriccions();
                    break;
                case 2:
                    mostrarEscolesAmbRestriccions();
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
                    mostrarSectorsAmbMesDeXVies();
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

    private static void inserirVia() {
        Scanner sc = new Scanner(System.in);

        Via via = new Via();
        ViaDAO viaDAO = new MySQLViaDAO();

        //Demanar valors per inserir als camps

        //Sector_id
        System.out.println("Introdueix el sector_id");
        long sector_id = Long.parseLong(sc.nextLine());

        if(sector_id == 0) {
            return;
        }

        via.setSector_id(sector_id);

        //Creador_id
        System.out.println("Introdueix el creador_id");
        long creador_id = Long.parseLong(sc.nextLine());

        if(creador_id == 0) {
            return;
        }

        via.setCreador_id(creador_id);

        //Nom
        System.out.println("Introdueix el nom");
        String nom = sc.nextLine();

        if(!nom.isBlank()) {
            via.setNom(nom);
        }

        //Tipus_via
        System.out.println("Introdueix el tipus_via");
        String tipus_via = sc.nextLine();

        if(!tipus_via.isBlank()) {
            via.setTipus_via(tipus_via);
        }

        //Orientació
        System.out.println("Introdueix l'orientacio");
        String orientacio = sc.nextLine();

        if(!orientacio.isBlank()) {
            via.setOrientacio(orientacio);
        }

        //Estat
        System.out.println("Introdueix l'estat");
        String estat = sc.nextLine();

        if(!estat.isBlank()) {
            via.setEstat(estat);
        }

        via.aplicarReglesEstat();

        //Restriccions
        if(via.isRestriccions()){
            System.out.println("Introdueix Data_Fi_Estat (YYYY-MM-DD)");
            String data = sc.nextLine();

            if(!data.isBlank()){
                via.setData_fi_estat(LocalDate.parse(data));
            }
        }

        //Ancoratge
        System.out.println("Introdueix l'ancoratge");
        String ancoratge = sc.nextLine();

        if(!ancoratge.isBlank()) {
            via.setAncoratge(ancoratge);
        }

        //Tipus_roca
        System.out.println("Introdueix tipus_roca");
        String tipus_roca = sc.nextLine();

        if(!tipus_roca.isBlank()) {
            via.setTipus_roca(tipus_roca);
        }

        //Grau
        System.out.println("Introdueix el grau");
        String grau = sc.nextLine();

        if(!grau.isBlank()) {
            via.setGrau(grau);
        }

        //Inserir la nova Via
        viaDAO.inserir(via);
        System.out.println("Via inserida correctament");
    }

    private static void inserirSector() {
        Scanner sc = new Scanner(System.in);

        Sector sector = new Sector();
        SectorDAO sectorDAO = new MySQLSectorDAO();

        //Demanar valors per inserir als camps

        //Nom
        System.out.println("Introdueix nom");
        String nom = sc.nextLine();

        if(!nom.isBlank()){
            sector.setNom(nom);
        }

        //Coordenades
        System.out.println("Introdueix coordenades");
        String coordenades = sc.nextLine();

        if(!coordenades.isBlank()){
            sector.setCoordenades(coordenades);
        }

        //Aproximacio
        System.out.println("Introdueix l'aproximacio");
        String aproximacio = sc.nextLine();

        if(!aproximacio.isBlank()){
            sector.setAproximacio(aproximacio);
        }

        //Numero_Vies
        System.out.println("Introdueix el numero_vies");
        String numero_viesString = sc.nextLine();

        if(!numero_viesString.isBlank()){
            try{
                int numero_vies = Integer.parseInt(numero_viesString);
                sector.setNumero_vies(numero_vies);
            } catch(NumberFormatException e){
                System.out.println("Has d'introduir un número.");
            }
        }

        //Popularitat
        System.out.println("Introdueix la popularitat");
        String popularitat = sc.nextLine();

        if(!popularitat.isBlank()){
            sector.setPopularitat(popularitat);
        }

        //Restriccions
        System.out.println("Introdueix les restriccions");
        String restriccions = sc.nextLine();

        if(!restriccions.isBlank()){
            sector.setRestriccions(restriccions);
        }

        //Escola_id
        System.out.println("Introdueix escola_id");
        long escola_id = sc.nextLong();

        if(escola_id == 0){
            return;
        }

        sector.setEscola_id(escola_id);

        sectorDAO.inserir(sector);
        System.out.println("Sector inserit corectament");
    }

    private static void modificarVia(){
        Scanner sc = new Scanner(System.in);

        //Mostar totes les vies
        ViaDAO viaDAO = new MySQLViaDAO();
        List<Via> vies = viaDAO.obtindreTots();
        viaHeader();
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

    private static void modificarSector(){
        Scanner sc = new Scanner(System.in);

        //Mostar tots els sectors
        SectorDAO sectorDAO = new MySQLSectorDAO();
        List<Sector> sectors = sectorDAO.obtindreTots();
        sectorHeader();
        for(Sector s : sectors){
            System.out.println(s);
        }

        //Demanar sector específic per ID
        System.out.println("ID del sector: \n0 per sortir");
        long id = Long.parseLong(sc.nextLine());
        if(id == 0){
            return;
        }

        //Buscar Sector per ID
        Sector sector = sectorDAO.obtenir(id);

        //Comprovació de l'existència del Sector
        if(sector == null){
            System.out.println("Via no trobada");
            return;
        }

        //Demanar canvis

        //Nom
        System.out.println("Nom (" + sector.getNom() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String nom = sc.nextLine();

        if(!nom.isBlank()){
            sector.setNom(nom);
        }

        //Coordenades
        System.out.println("Coordenades (" + sector.getCoordenades() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String coordenades = sc.nextLine();

        if(!coordenades.isBlank()){
            sector.setCoordenades(coordenades);
        }

        //Aproximacio
        System.out.println("Aproximacio (" + sector.getAproximacio() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String aproximacio = sc.nextLine();

        if(!aproximacio.isBlank()){
            sector.setAproximacio(aproximacio);
        }

        //Numero_Vies
        System.out.println("Numero_vies (" + sector.getNumero_vies() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String numero_viesString = sc.nextLine();

        if(!numero_viesString.isBlank()){
            try{
                int numero_vies = Integer.parseInt(numero_viesString);
                sector.setNumero_vies(numero_vies);
            } catch(NumberFormatException e){
                System.out.println("Has d'introduir un número.");
            }
        }

        //Popularitat
        System.out.println("Popularitat (" + sector.getPopularitat() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String popularitat = sc.nextLine();

        if(!popularitat.isBlank()){
            sector.setPopularitat(popularitat);
        }

        //Restriccions
        System.out.println("Restriccions (" + sector.getRestriccions() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String restriccions = sc.nextLine();

        if(!restriccions.isBlank()){
            sector.setRestriccions(restriccions);
        }

        sectorDAO.modificar(sector);
        System.out.println("Sector modificat correctament");
    }

    private static void modificarEscola(){
        Scanner sc = new Scanner(System.in);

        //Mostrar totes les escoles
        EscolaDAO escolaDAO = new MySQLEscolaDAO();
        List<Escola> escoles = escolaDAO.obtindreTots();
        escolaHeader();
        for(Escola e : escoles){
            System.out.println(e);
        }

        //Demanar escoles especifiques per ID
        System.out.println("ID de l'escola: \n0 per sortir");
        long id = Long.parseLong(sc.nextLine());
        if(id == 0){
            return;
        }

        //Buscar Escola per ID
        Escola escola = escolaDAO.obtenir(id);

        //Comprovacio de l'existencia de l'Escola
        if(escola == null){
            System.out.println("Escola no trobada");
            return;
        }

        //Demanar canvis

        //Nom
        System.out.println("Nom (" + escola.getNom() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String nom = sc.nextLine();

        if(!nom.isBlank()){
            escola.setNom(nom);
        }

        //Lloc
        System.out.println("Lloc (" + escola.getLloc() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String lloc = sc.nextLine();

        if(!lloc.isBlank()){
            escola.setLloc(lloc);
        }

        //Aproximacio
        System.out.println("Aproximacio (" + escola.getAproximacio() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String aproximacio = sc.nextLine();

        if(!aproximacio.isBlank()){
            escola.setAproximacio(aproximacio);
        }

        //Numero_Vies
        System.out.println("Numero_vies (" + escola.getNumero_vies() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String numero_viesString = sc.nextLine();

        if(!numero_viesString.isBlank()){
            try{
                int numero_vies = Integer.parseInt(numero_viesString);
                escola.setNumero_vies(numero_vies);
            } catch (NumberFormatException e){
                System.out.println("Has d'introduir un número.");
            }
        }

        //Popularitat
        System.out.println("Popularitat (" + escola.getPopularitat() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String popularitat = sc.nextLine();

        if(!popularitat.isBlank()){
            escola.setPopularitat(popularitat);
        }

        //Restriccions
        System.out.println("Restriccions (" + escola.getRestriccions() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String restriccions = sc.nextLine();

        if(!restriccions.isBlank()){
            escola.setRestriccions(restriccions);
        }

        escolaDAO.modificar(escola);
        System.out.println("Escola modificada correctament");
    }

    private static void modificarEscalador(){
        Scanner sc = new Scanner(System.in);

        //Mostar tots els escaladors
        EscaladorDAO escaladorDAO = new MySQLEscaladorDAO();
        List<Escalador> escaladors = escaladorDAO.obtindreTots();
        escaladorHeader();
        for(Escalador e : escaladors){
            System.out.println(e);
        }

        //Demanar escaladors especifiques per ID
        System.out.println("ID de l'escalador: \n0 per sortir");
        long id = Long.parseLong(sc.nextLine());
        if(id == 0){
            return;
        }

        //Buscar Escalador per ID
        Escalador escalador = escaladorDAO.obtenir(id);

        //Comprovacio de l'existencia de l'Escalador
        if(escalador == null){
            System.out.println("Escalador no trobat");
            return;
        }

        //Demanar canvis

        //Nom
        System.out.println("Nom (" + escalador.getNom() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String nom = sc.nextLine();

        if(!nom.isBlank()){
            escalador.setNom(nom);
        }

        //Alias
        System.out.println("Alias (" + escalador.getAlias() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String alias = sc.nextLine();

        if(!alias.isBlank()){
            escalador.setAlias(alias);
        }

        //Edat
        System.out.println("Edat (" + escalador.getEdat() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String edat_string = sc.nextLine();

        if(!edat_string.isBlank()){
            try{
                int edat = Integer.parseInt(edat_string);
                escalador.setEdat(edat);
            } catch (NumberFormatException e){
                System.out.println("Has d'introduir un número.");
            }
        }

        //Nivell_maxim
        System.out.println("Nivell_maxim (" + escalador.getNivell_maxim() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String nivell_maxim = sc.nextLine();

        if(!nivell_maxim.isBlank()){
            escalador.setNivell_maxim(nivell_maxim);
        }

        //Estil_Preferit
        System.out.println("Estil_preferit (" + escalador.getEstil_preferit() + ") pressiona 'Enter' si no vols modificar-lo: ");
        String estil_preferit = sc.nextLine();

        if(!estil_preferit.isBlank()){
            escalador.setEstil_preferit(estil_preferit);
        }

        escaladorDAO.modificar(escalador);
        System.out.println("Escalador modificat correctament");
    }

    private static void viaHeader() {

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

    private static void escolaHeader() {

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

    private static void sectorHeader() {

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

    private static void escaladorHeader() {

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

    private static void ViaRestriccioHeader(){
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


    private static void ViaDifHeader(){
        System.out.printf(
                "%-20s %-8s %-25s %-20s\n",
                "VIA",
                "GRAU",
                "SECTOR",
                "ESCOLA"
        );    }

    private static void mostrarViesPerEscolaAmbRestriccions() {

        Scanner sc = new Scanner(System.in);

        EscolaDAO escolaDAO = new MySQLEscolaDAO();
        MySQLViaDAO viaDAO = new MySQLViaDAO();

        List<Escola> escoles = escolaDAO.obtindreTots();

        System.out.println("\n--- ESCOLES DISPONIBLES ---");

        for (int i = 0; i < escoles.size(); i++) {
            System.out.println((i + 1) + ". " + escoles.get(i).getNom());
        }

        System.out.print("Selecciona una escola: ");
        int opcion = sc.nextInt();

        if (opcion < 1 || opcion > escoles.size()) {
            System.out.println("Opció no vàlida");
            return;
        }

        Escola esc = escoles.get(opcion - 1);

        List<ViaTancadaDTO> vies =
                viaDAO.obtindreViesAmbRestriccionsPerEscola(esc.getId_escola());

        System.out.println("\n--- VIES AMB RESTRICCIONS ACTIVES ---");
        if (vies.isEmpty()) {
            System.out.println("No hi ha vies amb restriccions.");
        } else {
            ViaRestriccioHeader();
            vies.forEach(System.out::println);
        }
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

        ViaDifHeader();

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

        ViesSegonEstat();

        if (vies.isEmpty()) {
            System.out.println("No s'han trobat vies.");
        } else {
            vies.forEach(System.out::println);
        }
    }

    private static void mostrarEscolesAmbRestriccions() {

        MySQLEscolaDAO escolaDAO = new MySQLEscolaDAO();

        List<EscolaRestriccioDTO> escoles =
                escolaDAO.obtindreEscolesAmbRestriccions();

        System.out.println("\n--- ESCOLES AMB RESTRICCIONS ACTIVES ---\n");

        System.out.printf(
                "%-20s %-20s %-30s\n",
                "ESCOLA",
                "LLOC",
                "RESTRICCIONS"
        );

        if (escoles.isEmpty()) {
            System.out.println("No hi ha escoles amb restriccions.");
        } else {
            escoles.forEach(System.out::println);
        }
    }

    private static void ViesSegonEstat(){
        System.out.printf(
                "%-20s %-12s %-10s %-20s %-20s\n",
                "VIA",
                "TIPUS",
                "GRAU",
                "SECTOR",
                "ESCOLA"
        );    }
    private static void EscaladorMateixNivell(){

        System.out.printf(
                "%-20s %-20s %-15s\n",
                "NOM",
                "ALIAS",
                "NIVELL_MAXIM"
        );
    }

    private static void ViaApteFaPoc(){
        System.out.printf(
                "%-20s %-20s %-20s %-15s\n",
                "VIA",
                "SECTOR",
                "ESCOLA",
                "DATA_APTE"
        );
    }

    private static void ViaLlargada() {
        System.out.printf(
                "%-25s %-15s %-20s %-20s\n",
                "VIA",
                "LLARGADA",
                "SECTOR",
                "ESCOLA"
        );
    }

    private static void mostrarSectorsAmbMesDeXVies() {

        Scanner sc = new Scanner(System.in);

        MySQLSectorDAO sectorDAO = new MySQLSectorDAO();

        System.out.print("Introdueix el mínim de vies: ");
        int minim = sc.nextInt();

        List<SectorViesDTO> sectors =
                sectorDAO.obtindreSectorsAmbMesDeXVies(minim);

        System.out.println("\n--- SECTORS AMB MÉS DE " + minim + " VIES ---\n");

        System.out.printf(
                "%-25s %-15s %-20s\n",
                "SECTOR",
                "TOTAL_VIES",
                "ESCOLA"
        );

        if (sectors.isEmpty()) {
            System.out.println("No s'han trobat sectors.");
        } else {
            sectors.forEach(System.out::println);
        }
    }


    private static void mostrarEscaladorsMateixNivell() {

        Scanner sc = new Scanner(System.in);

        MySQLEscaladorDAO escaladorDAO = new MySQLEscaladorDAO();

        System.out.print("Introdueix el nivell a buscar: ");
        String nivell = sc.nextLine();

        List<EscaladorNivellDTO> escaladors =
                escaladorDAO.obtindreEscaladorsPerNivell(nivell);

        System.out.println("\n--- ESCALADORS AMB NIVELL " + nivell + " ---\n");



        if (escaladors.size() >= 2) {
            EscaladorMateixNivell();
            escaladors.forEach(System.out::println);

        } else {

            System.out.println(
                    "No hi ha 2 escaladors o més amb el nivell " + nivell
            );
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
            ViaApteFaPoc();
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
            ViaLlargada();
            vies.forEach(System.out::println);
        }
    }



}