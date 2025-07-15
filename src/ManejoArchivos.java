import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class ManejoArchivos {
    public static void cargarPrimosCSV(PrimesList primesList, String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int prime = Integer.parseInt(line.trim());
                primesList.add(prime);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar primos: " + e.getMessage());
        }
    }

    public static void escribirResultados(Queue<String> resultQueue, String archivo) {
        try (FileWriter writer = new FileWriter(archivo, true)) {
            while (!resultQueue.isEmpty()) {
                writer.write(resultQueue.poll() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir resultados: " + e.getMessage());
        }
    }
}
