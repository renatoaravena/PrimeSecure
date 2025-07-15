import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;



//Puntos 1, 2, 3, 7? y 10 de la rubrica completos

public class PrimesList extends ArrayList<Integer> {

    private final ReentrantLock lock = new ReentrantLock();

    public static boolean isPrime(int numero){

        boolean primo = true;
        for (int i = 2; i<numero; i++){
            if (numero % i == 0){
                primo = false;
                break;
            }
        }
        return primo;
    }

    @Override
    public boolean add(Integer numero) {
        lock.lock();
        try {
            if (!isPrime(numero)) {
                throw new IllegalArgumentException("Solo se permiten números primos");
            }
            return super.add(numero);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Integer remove(int index) {
        lock.lock();
        try {
            return super.remove(index);
        } finally {
            lock.unlock();
        }
    }

    public int getPrimesCount() {
        lock.lock();
        try {
            return this.size();
        } finally {
            lock.unlock();
        }
    }
}

