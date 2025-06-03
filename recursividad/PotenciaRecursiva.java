public class PotenciaRecursiva {

    /**
     * Calcula la potencia de un número (base) elevado a un exponente de manera recursiva.
     * La operación es base^exponente.
     *
     * @param base     El número base.
     * @param exponente El exponente al que se elevará la base.
     * @return El resultado de base elevado al exponente.
     * Se asume que el exponente es no negativo (>= 0) según la definición del problema.
     */
    public static int calcularPotencia(int base, int exponente) {
        // Caso base: Si el exponente es 0, cualquier número elevado a 0 es 1.
        // n^0 = 1
        if (exponente == 0) {
            return 1;
        }
        // Caso base adicional (opcional pero buena práctica para 0^X):
        // if (base == 0) {
        //     return 0; // 0 elevado a cualquier exponente positivo es 0
        // }

        // Proceso recursivo: base * (base^(exponente-1))
        // Descompone el problema en multiplicar la base por el resultado de
        // calcular la potencia con el exponente reducido en 1.
        else {
            return base * calcularPotencia(base, exponente - 1);
        }
    }

    public static void main(String[] args) {
        // Ejemplos de uso:
        int base1 = 2;
        int exponente1 = 5;
        System.out.println(base1 + "^" + exponente1 + " = " + calcularPotencia(base1, exponente1)); // Salida esperada: 32 (2*2*2*2*2)

        int base2 = 3;
        int exponente2 = 4;
        System.out.println(base2 + "^" + exponente2 + " = " + calcularPotencia(base2, exponente2)); // Salida esperada: 81 (3*3*3*3)

        int base3 = 7;
        int exponente3 = 0;
        System.out.println(base3 + "^" + exponente3 + " = " + calcularPotencia(base3, exponente3)); // Salida esperada: 1 (caso base)

        int base4 = 5;
        int exponente4 = 1;
        System.out.println(base4 + "^" + exponente4 + " = " + calcularPotencia(base4, exponente4)); // Salida esperada: 5

        int base5 = 10;
        int exponente5 = 3;
        System.out.println(base5 + "^" + exponente5 + " = " + calcularPotencia(base5, exponente5)); // Salida esperada: 1000
    }
}
