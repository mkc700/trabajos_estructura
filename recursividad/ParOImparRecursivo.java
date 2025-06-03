public class ParOImparRecursivo {

    /**
     * Determina si un número entero es par de forma recursiva.
     *
     * @param n El número entero a comprobar.
     * @return true si el número es par, false si es impar.
     */
    public static boolean esPar(int n) {
        // Caso base 1: Si n es 0, es par.
        if (n == 0) {
            return true;
        }
        // Caso base 2: Si n es 1, es impar.
        // También captura -1, que se manejará al llegar a 1 por la recursión.
        if (n == 1 || n == -1) {
            return false;
        }

        // Proceso recursivo para números positivos:
        // Un número positivo n es par si (n - 2) es par.
        if (n > 0) {
            return esPar(n - 2);
        }
        // Proceso recursivo para números negativos:
        // Un número negativo n es par si (n + 2) es par.
        // Esto mueve el número hacia 0, 1 o -1.
        else { // n < 0
            return esPar(n + 2);
        }
    }

    /**
     * Determina si un número entero es impar de forma recursiva.
     * (Es el opuesto de esPar, pero también se puede definir recursivamente de forma independiente)
     *
     * @param n El número entero a comprobar.
     * @return true si el número es impar, false si es par.
     */
    public static boolean esImpar(int n) {
        // Podríamos simplemente llamar a esPar y negar el resultado:
        // return !esPar(n);

        // O definirlo de forma independiente recursivamente:
        if (n == 0) {
            return false; // 0 es par
        }
        if (n == 1 || n == -1) {
            return true; // 1 y -1 son impares
        }

        if (n > 0) {
            return esImpar(n - 2);
        } else { // n < 0
            return esImpar(n + 2);
        }
    }

    public static void main(String[] args) {
        // Pruebas para esPar:
        System.out.println("--- Comprobación de Paridad (esPar) ---");
        System.out.println("Es 4 par? " + esPar(4));   // true
        System.out.println("Es 5 par? " + esPar(5));   // false
        System.out.println("Es 0 par? " + esPar(0));   // true
        System.out.println("Es 1 par? " + esPar(1));   // false
        System.out.println("Es -2 par? " + esPar(-2)); // true
        System.out.println("Es -3 par? " + esPar(-3)); // false
        System.out.println("Es 100 par? " + esPar(100)); // true
        System.out.println("Es 99 par? " + esPar(99));   // false

        // Pruebas para esImpar:
        System.out.println("\n--- Comprobación de Imparidad (esImpar) ---");
        System.out.println("Es 4 impar? " + esImpar(4));   // false
        System.out.println("Es 5 impar? " + esImpar(5));   // true
        System.out.println("Es 0 impar? " + esImpar(0));   // false
        System.out.println("Es 1 impar? " + esImpar(1));   // true
        System.out.println("Es -2 impar? " + esImpar(-2)); // false
        System.out.println("Es -3 impar? " + esImpar(-3)); // true
    }
}