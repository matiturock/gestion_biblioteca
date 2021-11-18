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

import domain.Libro;
import utils.Constructor;

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
    public List<Libro> listarLibros(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        List<Libro> libros = new ArrayList<>();

        try {
            var registro = new BufferedReader(new FileReader(archivo));
            String atributosLibro = null;
            atributosLibro = registro.readLine();

            while (atributosLibro != null) {
                Libro libro = Constructor.instanciarLibro(atributosLibro);
                libros.add(libro);
                atributosLibro = registro.readLine();
            }

            registro.close();

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
    public void escribir(Libro libro, Boolean anexar, String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        try {
            var escritura = new PrintWriter(new FileWriter(archivo, anexar));
            escritura.println(libro.toString());
            escritura.close();
            System.out.println("Se ha escrito información en el archivo: " + libro);
        } catch (IOException e) {
            System.out.println("Error al escribir en archivo");
            e.printStackTrace();
        }
    }

    @Override
    public Libro buscarLibro(String nombreRecurso, String buscarLibroPorTitulo) {
        var arachivo = new File(nombreRecurso);
        Libro resultadoBusquedaLibro = null;

        try {
            var registro = new BufferedReader(new FileReader(arachivo));
            String atributosLibro = null;
            atributosLibro = registro.readLine();

            while (atributosLibro != null) {
                String[] atributosLibroArr = atributosLibro.split(",");
                String tituloLibro = atributosLibroArr[0];

                if (buscarLibroPorTitulo != null && buscarLibroPorTitulo.equalsIgnoreCase(tituloLibro))
                    resultadoBusquedaLibro = Constructor.instanciarLibro(atributosLibro);

                atributosLibro = registro.readLine();
            }

            registro.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo al buscar");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo al buscar");
            e.printStackTrace();
        }

        return resultadoBusquedaLibro;
    }

}
