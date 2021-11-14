package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.libro.CopiaLibro;
import domain.libro.Genero;
import domain.persona.Autor;

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
                // TODO capturar distintos campos del archivo csv
                String[] libroAtributos = registro.split(",");
                String titulo = libroAtributos[0];
                Genero genero = Genero.valueOf(libroAtributos[1]);
                Autor autor = instanciarAutor(libroAtributos[2]);

                var copiaLibro = new CopiaLibro(null, null, null, null, null);
                libros.add(copiaLibro);
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

        return null;
    }

    private Autor instanciarAutor(String string) {
        String[] atributosAutor = string.split(",");
        var autor = new Autor(atributosAutor[0], LocalDate.parse(atributosAutor[1]), LocalDate.parse(atributosAutor[2]),
                atributosAutor[3]);
        return autor;
    }

    @Override
    public void escribir(CopiaLibro copiaLibro, Boolean anexar, String nombreRecurso) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actualizar(CopiaLibro copiaLibro, String nombreRecurso) {
        // TODO Auto-generated method stub

    }

    @Override
    public void borrar(CopiaLibro copiaLibro, String nombreRecurso) {
        // TODO Auto-generated method stub

    }

    @Override
    public String buscar(String nombreRecurso, String buscar) {
        // TODO Auto-generated method stub
        return null;
    }

}
