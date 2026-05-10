package Vista;

import DAO.EscolaDAO;
import DAO.MySQL.MySQLEscolaDAO;
import DAO.MySQL.MySQLViaDAO;
import Model.DTO.EscolaRestriccioDTO;
import Model.DTO.ViaTancadaDTO;
import Model.Escola;
import Vista.Headers;

import java.util.List;
import java.util.Scanner;



public class EscolaVista {

    public static void crudEscoles(){

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

    private static void modificarEscola(){
        Scanner sc = new Scanner(System.in);

        //Mostrar totes les escoles
        EscolaDAO escolaDAO = new MySQLEscolaDAO();
        List<Escola> escoles = escolaDAO.obtindreTots();
        Headers.escolaHeader();
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
                    Headers.escolaHeader();
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

    private static void eliminarEscola(){
        Scanner sc = new Scanner(System.in);

        EscolaDAO escolaDAO = new MySQLEscolaDAO();

        //Mostrar tots els sectors
        List<Escola> escoles = escolaDAO.obtindreTots();
        Headers.escolaHeader();

        for(Escola e : escoles){
            System.out.println(e);
        }

        // Demanar ID
        System.out.println("Introdueix ID de l'escola a eliminar (0 per sortir):");
        long id = Long.parseLong(sc.nextLine());

        if(id == 0){
            return;
        }

        Escola escola = escolaDAO.obtenir(id);

        if(escola == null){
            System.out.println("Escola no trobada");
            return;
        }

        // Confirmació
        System.out.println("Segur que vols eliminar l'escola " + escola.getNom() + "? (s/n)");
        String confirmacio = sc.nextLine();

        if(confirmacio.equalsIgnoreCase("s")){
            escolaDAO.eliminar(escola);
        } else {
            System.out.println("Eliminació cancel·lada");
        }
    }

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
            Headers.ViaRestriccioHeader();
            vies.forEach(System.out::println);
        }
    }

    private static void mostrarEscolesAmbRestriccions() {

        MySQLEscolaDAO escolaDAO = new MySQLEscolaDAO();

        List<EscolaRestriccioDTO> escoles =
                escolaDAO.obtindreEscolesAmbRestriccions();

        System.out.println("\n--- ESCOLES AMB RESTRICCIONS ACTIVES ---\n");



        if (escoles.isEmpty()) {
            System.out.println("No hi ha escoles amb restriccions.");
        } else {
            Headers.EscolaRestricionsActives();
            escoles.forEach(System.out::println);
        }
    }

}