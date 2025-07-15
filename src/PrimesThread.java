import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class PrimesThread implements Runnable {
    private final PrimesList primesList;
    private final BlockingQueue<Integer> taskQueue;
    private final BlockingQueue<String> resultQueue;

    public PrimesThread(PrimesList primesList,
                        BlockingQueue<Integer> taskQueue,
                        BlockingQueue<String> resultQueue) {
        this.primesList = primesList;
        this.taskQueue = taskQueue;
        this.resultQueue = resultQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int numero = random.nextInt(1000) + 2;
                taskQueue.put(numero);

                if (PrimesList.isPrime(numero)) {
                    synchronized (primesList) {
                        primesList.add(numero);
                        String encriptado = "ENCRIPTADO_" + numero * 31;
                        resultQueue.put("Código Primo: " + numero + " | Mensaje: " + encriptado);
                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
