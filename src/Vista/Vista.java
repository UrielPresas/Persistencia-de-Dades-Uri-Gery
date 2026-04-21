package Vista;

public class Vista {
    private static void vistaMainMenu(){
        System.out.println
                ("-------------------Pillam Ltd. Co.-------------------\n" +
                "1. Vies\n" +
                "2. Escoles\n" +
                "3. Sectors\n" +
                "4. Escaladors\n" +
                "0. Sortir");
    }

    private static void crudVies(){
        System.out.println
                ("-------------------VIES-------------------\n" +
                "1. Crear Via\n" +
                "2. Modificar Via\n" +
                "3. Llistar Via\n" +
                "4. Eliminar Via\n" +
                "0. Sortir");
    }

    private static void crudEscoles(){
        System.out.println
                ("-------------------ESCOLES-------------------\n" +
                "1. Crear Escola\n" +
                "2. Modificar Escola\n" +
                "3. Llistar Escola\n" +
                "4. Eliminar Escola\n" +
                "0. Sortir");
    }
    private static void crudSector(){
        System.out.println
                ("-------------------SECTORS-------------------\n" +
                "1. Crear Sector\n" +
                "2. Modificar Sector\n" +
                "3. Llistar Sector\n" +
                "4. Eliminar Sector\n" +
                "0. Sortir");
    }
    private static void crudEscaladors(){
        System.out.println
                ("-------------------ESCALADORS-------------------\n" +
                "1. Crear Escaladors\n" +
                "2. Modificar Escaladors\n" +
                "3. Llistar Escaladors\n" +
                "4. Eliminar Escaladors\n" +
                "0. Sortir");
    }

    private static void llistarVies(){
        System.out.println
                ("-------------------Llistar Vies-------------------\n" +
                "1. Llistar una Via" +
                "2. Llistar Tots" +
                "0. Sortir");
    }

    private static void llistarEscoles(){
        System.out.println
                ("-------------------Llistar Escoles-------------------\n" +
                "1. Llistar una Escola" +
                "2. Llistar Totes" +
                "0. Sortir");
    }

    private static void llistarSectors(){
        System.out.println
                ("-------------------Llistar Sectors-------------------\n" +
                "1. Llistar un Sector" +
                "2. Llistar Tots" +
                "0. Sortir");
    }

    private static void llistarEscaladors(){
        System.out.println
                ("-------------------Llistar Escaladors-------------------\n" +
                "1. Llistar un Escalador" +
                "2. Llistar Tots" +
                "0. Sortir");
    }

    private static void llistarUnaVia(){
        System.out.println
                ("-------------------Filtres per Llistar Vies-------------------\n" +
                "1. Mostar per dificultat" +
                "2. Mostar segons estat (Apte, Construcció, Tancada)" +
                "3. Mostrar vies que han passat a 'Apte'" +
                "4. Mostrar les vies mes llargues d'una escola" +
                "0. Sortir");
    }

    private static void llistarUnaEscola(){
        System.out.println
                ("-------------------Filtres per Llistar Escoles-------------------\n" +
                "1. Mostar escoles amb restriccions actives actuals" +
                "0. Sortir");
    }

    private static void llistarUnSector(){
        System.out.println
                ("-------------------Filtres per Llistar Sectors-------------------\n" +
                "1. Mostrar sectors amb mes de X vies especificades" +
                "0. Sortir");
    }

    private static void llistarUnEscalador(){
        System.out.println
                ("-------------------Filtres per Llistar Escaladors-------------------\n" +
                "1. Mostrar escaladors amb el mateix nivell màxim assolit" +
                "0. Sortir");
    }

}
