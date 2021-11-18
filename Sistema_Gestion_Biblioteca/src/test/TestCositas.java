package test;

// import java.util.Scanner;

// import domain.Genero;

// import java.time.LocalDate;

// import domain.persona.Autor;
// import utils.Generador;

/**
 * Clase usada para probar funcionalidades varias como capturar datos para
 * instanciar clases desde Strings
 */
public class TestCositas {
    public static void main(String[] args) {
        // // TEST crear Autor desde String
        // Autor autorNuevo = new Autor("Mati", LocalDate.parse("1990-06-04"), null,
        // "Argentina");
        // System.out.println(autorNuevo);

        // String autorRegistroString = "García
        // Marquez;1927-03-06;2014-04-17;Colombiano";
        // autorNuevo = Generador.instanciarAutor(autorRegistroString);
        // System.out.println(autorNuevo);

        // // TEST crear copiaLibro desde String
        // CopiaLibro copiaLibroNuevo = new CopiaLibro("100 Años de Soledad",
        // Genero.NOVELA, autorNuevo, 3,
        // EstadoLibro.EN_BIBLIOTECA);
        // System.out.println(copiaLibroNuevo);

        // String libroString = "Carrie,NOVELA,Sthepen King;1947-09-21;null;Estados
        // Unidos,5,EN_BIBLIOTECA";
        // CopiaLibro libroDesdeString = Generador.instanciarCopiaLibro(libroString);
        // System.out.println(libroDesdeString);

        // // TEST capturar fechas desde Strings
        // // Formato de fecha AÑO/MES/DIA -> 0000/00/00
        // LocalDate ahora = LocalDate.now();
        // System.out.println(ahora + " LocalDate");
        // String ahoraStr = String.valueOf(ahora);
        // System.out.println(ahoraStr + " String.valueOf");

        // LocalDate ahoraNuevo = LocalDate.parse(ahoraStr);
        // System.out.println(ahoraNuevo + " LocalDate.parse");

        // // TEST capturar valor del enum desde String
        // EstadoLibro estado = EstadoLibro.valueOf("PRESTADO");
        // System.out.println(estado);

        // Genero[] generos = Genero.values();
        // Scanner s = new Scanner(System.in);
        // int opcionUsuario = -1;
        // int indice = 1;

        // for (Genero genero : generos) {
        // System.out.println(String.format("%d - %s", indice, genero));
        // indice++;
        // }
        // opcionUsuario = Integer.parseInt(s.nextLine());

        // System.out.println(generos[opcionUsuario - 1]);
        // s.close();
    }

}
