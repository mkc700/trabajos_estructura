
public class sumarecursiva {

    /**
     * Calcula la sumatoria de los primeros n números naturales de manera recursiva.
     *
     * @param n El número hasta el cual se realizará la sumatoria.
     * @return La sumatoria de los números desde 1 hasta n.
     */
    public static int sumatoriaNaturales(int n) {
        // Caso base: Si n es 1, la sumatoria es 1.
        if (n == 1) {
            return 1;
        } else {
            // Proceso recursivo: n + sumatoriaNaturales(n-1)
            // Esto descompone el problema en un problema más pequeño (n-1)
            // y suma el n actual al resultado de ese subproblema.
            return n + sumatoriaNaturales(n - 1);
        }
    }

    public static void main(String[] args) {
        int numero1 = 5;
        System.out.println("La sumatoria de los primeros " + numero1 + " números naturales es: " + sumatoriaNaturales(numero1)); // Salida esperada: 15

        int numero2 = 10;
        System.out.println("La sumatoria de los primeros " + numero2 + " números naturales es: " + sumatoriaNaturales(numero2)); // Salida esperada: 55

        int numero3 = 1;
        System.out.println("La sumatoria de los primeros " + numero3 + " números naturales es: " + sumatoriaNaturales(numero3)); // Salida esperada: 1

        // Puedes probar con otros números
        // int numero4 = 0; // Esto podría causar un StackOverflowError si no se maneja,
        //                  // ya que la definición del problema es para números naturales (>= 1).
        // System.out.println("La sumatoria de los primeros " + numero4 + " números naturales es: " + sumatoriaNaturales(numero4));
    }
}