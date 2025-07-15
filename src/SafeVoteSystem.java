import java.util.concurrent.*;

public class SafeVoteSystem {
    public static void main(String[] args) throws InterruptedException {
        // Inicializamos las estructuras de datos y colas
        PrimesList primesList = new PrimesList();
        BlockingQueue<Integer> taskQueue = new LinkedBlockingQueue<>();
        BlockingQueue<String> resultQueue = new LinkedBlockingQueue<>();
        Topic messageTopic = new Topic();

        // Cargamos primos desde un archivo CSV
        ManejoArchivos.cargarPrimosCSV(primesList, "primos.csv");

        // Creamos pool de 3 hilos para generar primos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.execute(new PrimesThread(primesList, taskQueue, resultQueue));
        }


        // Hilo especifico para escribir resultados en el archivo
        new Thread(() -> {
            while (messageTopic.getActivo()) {
                ManejoArchivos.escribirResultados(resultQueue, "encriptado.txt");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        // Apagar sistema
        executor.shutdownNow();
        messageTopic.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // Resultados finales
        System.out.println("Total de primos generados: " + primesList.getPrimesCount());
    }
}