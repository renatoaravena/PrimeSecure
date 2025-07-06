import java.util.ArrayList;

public class PrimesList extends ArrayList<Integer> {

    public PrimesList(){
        super();
    }

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

    //Devolvera la cantidad de numeros de la lista
    public int getPrimesCount(){
        return this.size();
    }


    //Agregué synchronized debido a que estaba presentando inconsistencias al agregar números y luego no se veían reflejados
    //cuando se imprimía el tamaño de la lista.
    @Override
    public synchronized boolean add(Integer numero) throws IllegalArgumentException { //devuelve true si se agrego correctamente
        if (isPrime(numero)) { //Solo si es primo lo agregamos a la lista
            return super.add(numero);
        } else {
            throw new IllegalArgumentException("El número " + numero + " no es primo y no se puede agregar a la lista.");
        }
    }

    @Override
    public synchronized Integer remove(int index) {
        return super.remove(index);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return super.remove(o);
    }
}

