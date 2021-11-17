package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import domain.libro.CopiaLibro;
import domain.libro.EstadoLibro;
import domain.libro.Genero;
import domain.persona.Autor;
import utils.Generador;

public class AccesoDatosArchivo implements IAccesoDatos {

    @Override
    public void crearBase(String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.err.println("Se ha creado el archivo");
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e);
            e.printStackTrace();
        }

    }

    @Override
    public void borrarBase(String nombreRecurso) {
        var archivo = new File(nombreRecurso);

        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Sr ha borrado el archivo");
        }

        System.out.println("El archivo que intentas borrar no existe");
    }

    @Override
    public boolean existe(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<CopiaLibro> listaCopiaLibros(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        List<CopiaLibro> libros = new ArrayList<>();

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String registro = null;
            registro = entrada.readLine();

            while (registro != null) {
                // capturar distintos campos del archivo csv
                String[] libroAtributos = registro.split(",");
                String titulo = libroAtributos[0];
                Genero genero = Genero.valueOf(libroAtributos[1]);
                // los atributos de autor están separados por '+'
                Autor autor = Generador.instanciarAutor(libroAtributos[2]);
                Integer idCopia = Integer.parseInt(libroAtributos[3]);
                EstadoLibro estadoLibro = EstadoLibro.valueOf(libroAtributos[4]);

                var copiaLibro = new CopiaLibro(titulo, genero, autor, idCopia, estadoLibro);
                libros.add(copiaLibro);

                // se mueve el punto de lectura a la siguiente línea
                registro = entrada.readLine();
            }

            entrada.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar el archivo: " + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
            e.printStackTrace();
        }

        return libros;
    }

    @Override
    public void escribir(CopiaLibro copiaLibro, Boolean anexar, String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        try {
            var escritura = new PrintWriter(new FileWriter(archivo, anexar));
            escritura.println(copiaLibro);
            escritura.close();
            System.out.println("Se ha escrito información en el archivo: " + copiaLibro);
        } catch (IOException e) {
            System.out.println("Error al escribir en archivo");
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(CopiaLibro copiaLibro, String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Se ha borrado el archivo: " + nombreRecurso);
        }
        System.out.println("El archivo no existe");
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) {
        var arachivo = new File(nombreRecurso);
        String resultadoBusqueda = null;

        try {
            var entrada = new BufferedReader(new FileReader(arachivo));
            String salida = null;
            salida = entrada.readLine();

            while (salida != null) {
                String[] atributosLibro = salida.split(",");
                String tituloLibro = atributosLibro[0];
                if (buscar != null && buscar.equalsIgnoreCase(tituloLibro))
                    resultadoBusqueda = salida;
                salida = entrada.readLine();
            }

            entrada.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo al buscar");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo al buscar");
            e.printStackTrace();
        }

        return resultadoBusqueda;
    }

}
