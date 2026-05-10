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
                    ViaVista.crudVies();
                    break;
                case 2:
                    EscolaVista.crudEscoles();
                    break;
                case 3:
                    SectorVista.crudSector();
                    break;
                case 4:
                    EscaladorVista.crudEscaladors();
                    break;
                case 0:
                    System.out.println("Sortint del programa");
                    break;
                default:
                    System.out.println("Opció no vàlida ");
            }

        } while (opcion != 0);

    }
}

