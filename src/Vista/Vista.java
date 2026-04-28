package Vista;
import java.sql.Connection;
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
                    System.out.println("Modificar Via...");
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

}