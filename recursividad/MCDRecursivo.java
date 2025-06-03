public class MCDRecursivo {

    /**
     * Calcula el Máximo Común Divisor (MCD) de dos números enteros positivos
     * utilizando el algoritmo de Euclides de forma recursiva.
     *
     * @param a El primer número.
     * @param b El segundo número.
     * @return El Máximo Común Divisor de a y b.
     * @throws IllegalArgumentException Si alguno de los números es negativo.
     */
    public static int calcularMCD(int a, int b) {
        // Validación de entradas: El MCD tradicionalmente se define para números no negativos.
        // Si se necesitan negativos, se puede tomar el valor absoluto.
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Este método solo soporta números no negativos.");
        }

        // Caso base: Si b es 0, entonces a es el MCD.
        if (b == 0) {
            return a;
        } else {
            // Proceso recursivo:
            // El MCD(a, b) es igual al MCD(b, a % b).
            // Esto reduce el problema a uno más pequeño hasta que el segundo número (b) se convierte en 0.
            return calcularMCD(b, a % b);
        }
    }

    public static void main(String[] args) {
        // Ejemplos de uso:
        System.out.println("MCD(48, 18): " + calcularMCD(48, 18)); // Esperado: 6
        System.out.println("MCD(101, 103): " + calcularMCD(101, 103)); // Esperado: 1 (son primos relativos)
        System.out.println("MCD(10, 5): " + calcularMCD(10, 5));     // Esperado: 5
        System.out.println("MCD(5, 10): " + calcularMCD(5, 10));     // Esperado: 5
        System.out.println("MCD(0, 5): " + calcularMCD(0, 5));       // Esperado: 5 (MCD(0, x) = x)
        System.out.println("MCD(5, 0): " + calcularMCD(5, 0));       // Esperado: 5 (MCD(x, 0) = x, caso base)
        System.out.println("MCD(12, 12): " + calcularMCD(12, 12));   // Esperado: 12
        System.out.println("MCD(27, 36): " + calcularMCD(27, 36));   // Esperado: 9

        // Pruebas de excepciones:
        try {
            System.out.println("MCD(-48, 18): " + calcularMCD(-48, 18));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Esperado: Este método solo soporta números no negativos.
        }
    }
}