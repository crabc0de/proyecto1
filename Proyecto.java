import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class Proyecto {

    ////////////////////////////////////////// Métodos privados de la Clase //////////////////////////////////////////
    /**
     * Metodo estatico que lee las lineas de un archivo de texto y las ñade sin orden a un arreglo.
     * @param sc Scanner que lee el archivo de texto.
     * @param arreglo Arreglo donde se guardaran las lineas del archivo de texto.
     * @return Arreglo con las lineas del archivo de texto.
     */
    private static ArrayList<String> meteleAlArreglo(Scanner sc, ArrayList<String> arreglo) {
        while (sc.hasNextLine()) {
            arreglo.add(sc.nextLine());
        }

        return arreglo;
    }

    ////////////////////////////////////////// Método main //////////////////////////////////////////

    /**
     * Metodo principal del programa.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Bienvenido al Proyecto 1.\nTe ayudara a ordenar tu archivo de texto.\n");

        /**
         * Se intentara abrir el archivo de texto que se desea ordenar.
         * Si no se encuentra el archivo, se le informara al usuario.
         */
        try {
            File archivo = new File("hombres.txt");
            Scanner entrada = new Scanner(archivo, StandardCharsets.UTF_8);

            ArrayList<String> arregloLineas = new ArrayList<String>();

            meteleAlArreglo(entrada, arregloLineas);

            Collections.sort(arregloLineas);

            PrintWriter salida = new PrintWriter("tuTextoOrdenado.txt", StandardCharsets.UTF_8);

            for (String linea : arregloLineas) {
                salida.println(linea);
            }

            salida.close();

            System.out.println("El archivo ha sido ordenado exitosamente. Puedes encontrar el archivo ordenado en tu directorio de trabajo.");

        } catch (FileNotFoundException fnfe) {
            System.out.println("No se encontro el archivo. Por favor, asegurate de que el archivo se encuentre en el directorio de trabajo.");
        }   

    }
}
