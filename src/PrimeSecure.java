
public class PrimeSecure {
    public static void main(String[] args) {
        //Inicializamos la lista de primos
        PrimesList listaPrimos = new PrimesList();

        Thread t1 = new PrimesAdd(listaPrimos, 2);// Deberia funcionar
        Thread t2 = new PrimesAdd(listaPrimos, 3);//Deberia funcionar
        Thread t3 = new PrimesAdd(listaPrimos, 4);//Deberia fallar

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join(); // Espera a que el hilo t1 termine
            t2.join(); // Espera a que el hilo t2 termine
            t3.join(); // Espera a que el hilo t3 termine
        } catch (InterruptedException e) {
            System.out.println("Un hilo fue interrumpido: " + e.getMessage());
        }

        System.out.println("Cantidad de números primos en la lista: " + listaPrimos.getPrimesCount());
        System.out.println("Lista de números primos: " + listaPrimos);
        listaPrimos.removeLast();
        System.out.println("Cantidad de números primos en la lista después de eliminar el último: " + listaPrimos.getPrimesCount());
        System.out.println("Lista de números primos después de eliminar el último: " + listaPrimos);
    }

}
