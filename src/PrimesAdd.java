//No aparece en rubrica, pero lo hago igualmente para comprobar la funcionalidad del programa
public class PrimesAdd extends Thread {
    private final PrimesList listaPrimos;
    private final int numero;

    public PrimesAdd(PrimesList listaPrimos, int numero) {
        this.listaPrimos = listaPrimos;
        this.numero = numero;
    }

    @Override
    public void run() {
        try {
            listaPrimos.add(numero);
            System.out.println("Número primo " + numero + " agregado a la lista.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
