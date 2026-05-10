package Vista;

import DAO.MySQL.MySQLSectorDAO;
import DAO.SectorDAO;
import Model.DTO.SectorViesDTO;
import Model.Sector;

import java.util.List;
import java.util.Scanner;

public class SectorVista {

    public static void crudSector(){

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
                    eliminarSector();
                    break;
                case 0:
                    System.out.println("Tornant...");
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
                    Headers.sectorHeader();
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


    private static void eliminarSector(){
        Scanner sc = new Scanner(System.in);

        SectorDAO sectorDAO = new MySQLSectorDAO();

        //Mostrar tots els sectors
        List<Sector> sectors = sectorDAO.obtindreTots();
        Headers.sectorHeader();

        for(Sector s : sectors){
            System.out.println(s);
        }

        // Demanar ID
        System.out.println("Introdueix ID del sector a eliminar (0 per sortir):");
        long id = Long.parseLong(sc.nextLine());

        if(id == 0){
            return;
        }

        Sector sector = sectorDAO.obtenir(id);

        if(sector == null){
            System.out.println("Sector no trobat");
            return;
        }
        // Confirmació
        System.out.println("Segur que vols eliminar el sector " + sector.getNom() + "? (s/n)");
        String confirmacio = sc.nextLine();

        if(confirmacio.equalsIgnoreCase("s")){
            sectorDAO.eliminar(sector);
        } else {
            System.out.println("Eliminació cancel·lada");
        }
    }



    private static void modificarSector(){
        Scanner sc = new Scanner(System.in);

        //Mostar tots els sectors
        SectorDAO sectorDAO = new MySQLSectorDAO();
        List<Sector> sectors = sectorDAO.obtindreTots();
        Headers.sectorHeader();
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
}
