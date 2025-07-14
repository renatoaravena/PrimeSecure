public class PrimesThread implements Runnable{

    private PrimesList primesList;

    public PrimesThread(PrimesList primesList) {
        this.primesList = primesList;
    }


    @Override
    public void run() {

        int numeroRandom = (int) ((Math.random() * 100) + 1); // Genera un número aleatorio entre 1 y 100

        //Verificacion si es primo

        //TODO Preguntar al profe, por que verificar si es primo en el hilo(PrimesThread), si al agregar el numero a la lista con el metodo add,
        // se verificara si es primo o no. En este caso se estaria haciendo una doble verificacion de lo mismo, una en el hilo y otra nuevamente
        // en el metodo add de la clase PrimesList.

        if (PrimesList.isPrime(numeroRandom)) { // Verifica si el número es primo
            //Si es primo, lo agregamos a la lista primesList
            primesList.add(numeroRandom);

        } else {
            System.out.println("El número " + numeroRandom + " no es primo.");
        }

    }




}
