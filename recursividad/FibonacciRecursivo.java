
    public class FibonacciRecursivo {

    /**
     * Calcula el n-ésimo término de la serie de Fibonacci de manera recursiva.
     * La serie de Fibonacci comienza con F(1) = 1, F(2) = 1, F(3) = 2, F(4) = 3, ...
     *
     * @param n El índice del término de Fibonacci que se desea calcular (n >= 1).
     * @return El valor del n-ésimo término de Fibonacci.
     */
    public static int fibonacci(int n) {
        // Casos base:
        // F(1) = 1
        // F(2) = 1
        if (n == 1 || n == 2) {
            return 1;
        }
        // Caso base alternativo si se usa F(0)=0 y F(1)=1:
        // if (n == 0) {
        //     return 0;
        // } else if (n == 1) {
        //     return 1;
        // }

        // Proceso recursivo: F(n) = F(n-1) + F(n-2)
        // Esto descompone el problema en dos subproblemas más pequeños,
        // sumando los dos términos anteriores de la serie.
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        // Ejemplos de uso:
        System.out.println("Serie de Fibonacci:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(fibonacci(i) + ", ");
        }
        System.out.println("..."); // Salida esperada: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...

        System.out.println("\n");

        int termino5 = 5;
        System.out.println("El término " + termino5 + " de Fibonacci es: " + fibonacci(termino5)); // Salida esperada: 5

        int termino8 = 8;
        System.out.println("El término " + termino8 + " de Fibonacci es: " + fibonacci(termino8)); // Salida esperada: 21

        int termino1 = 1;
        System.out.println("El término " + termino1 + " de Fibonacci es: " + fibonacci(termino1)); // Salida esperada: 1
    }
}

