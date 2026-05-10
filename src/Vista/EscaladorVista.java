package Vista;

import DAO.EscaladorDAO;
import DAO.MySQL.MySQLEscaladorDAO;
import Model.DTO.EscaladorNivellDTO;
import Model.Escalador;

import java.util.List;
import java.util.Scanner;

public class EscaladorVista {
    public static void crudEscaladors(){

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
                    inserirEscalador();
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

    private static void inserirEscalador(){
        Scanner sc = new Scanner(System.in);

        Escalador escalador = new Escalador();
        EscaladorDAO escaladorDAO = new MySQLEscaladorDAO();

        //Demanar valors per inserir als camps

        //Nom
        System.out.println("Introdueix nom");
        String nom = sc.nextLine();

        if(!nom.isBlank()){
            escalador.setNom(nom);
        }

        System.out.println("Introdueix alias");
        String alias = sc.nextLine();

        if(!alias.isBlank()){
            escalador.setAlias(alias);
        }

        System.out.println("Introdueix edat");
        String edatString = sc.nextLine();

        if(!edatString.isBlank()){
            try{
                int edat = Integer.parseInt(edatString);
                escalador.setEdat(edat);
            } catch(NumberFormatException e){
                System.out.println("Has d'introduir un número.");
            }
        }

        System.out.println("Introdueix nivell_maxim");
        String nivell_maxim = sc.nextLine();

        if(!nivell_maxim.isBlank()){
            escalador.setNivell_maxim(nivell_maxim);
        }

        System.out.println("Introdueix estil_preferit");
        String estil_preferit = sc.nextLine();

        if(!estil_preferit.isBlank()){
            escalador.setEstil_preferit(estil_preferit);
        }

        escaladorDAO.inserir(escalador);
        System.out.println("Escalador inserit correctament");
    }

    private static void modificarEscalador(){
        Scanner sc = new Scanner(System.in);

        //Mostar tots els escaladors
        EscaladorDAO escaladorDAO = new MySQLEscaladorDAO();
        List<Escalador> escaladors = escaladorDAO.obtindreTots();
        Headers.escaladorHeader();
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
                    Headers.escaladorHeader();
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

    private static void eliminarEscalador(){
        Scanner sc = new Scanner(System.in);

        EscaladorDAO escaladorDAO = new MySQLEscaladorDAO();

        //Mostrar tots els escaladors
        List<Escalador> escaladors = escaladorDAO.obtindreTots();
        Headers.escaladorHeader();

        for(Escalador e : escaladors){
            System.out.println(e);
        }

        // Demanar ID
        System.out.println("Introdueix ID del escalador a eliminar (0 per sortir):");
        long id = Long.parseLong(sc.nextLine());

        if(id == 0){
            return;
        }

        Escalador escalador = escaladorDAO.obtenir(id);

        if(escalador == null){
            System.out.println("Escalador no trobat");
            return;
        }

        // Confirmació
        System.out.println("Segur que vols eliminar la via " + escalador.getNom() + "? (s/n)");
        String confirmacio = sc.nextLine();

        if(confirmacio.equalsIgnoreCase("s")){
            escaladorDAO.eliminar(escalador);
        } else {
            System.out.println("Eliminació cancel·lada");
        }
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
                    mostrarEscaladorsMateixNivell();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
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
            Headers.EscaladorMateixNivell();
            escaladors.forEach(System.out::println);

        } else {

            System.out.println(
                    "No hi ha 2 escaladors o més amb el nivell " + nivell
            );
        }
    }
}
