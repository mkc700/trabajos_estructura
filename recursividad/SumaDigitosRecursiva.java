public class SumaDigitosRecursiva {

    /**
     * Calcula la suma de los dígitos de un número entero de forma recursiva.
     * Soporta números positivos y negativos (sumando los dígitos de su valor absoluto).
     *
     * @param n El número entero cuyos dígitos se sumarán.
     * @return La suma de los dígitos del número.
     */
    public static int sumarDigitos(int n) {
        // Manejo de números negativos:
        // Si el número es negativo, trabajamos con su valor absoluto,
        // ya que la suma de los dígitos de -123 es 1+2+3 = 6.
        if (n < 0) {
            n = -n;
        }

        // Caso base: Si el número es un solo dígito (de 0 a 9), la suma es el propio número.
        if (n < 10) {
            return n;
        } else {
            // Proceso recursivo:
            // 1. Obtenemos el último dígito del número (n % 10).
            // 2. Llamamos recursivamente a la función con el número sin su último dígito (n / 10).
            // 3. Sumamos el último dígito al resultado de la llamada recursiva.
            return (n % 10) + sumarDigitos(n / 10);
        }
    }

    public static void main(String[] args) {
        // Ejemplos de uso:
        System.out.println("Suma de dígitos de 12345: " + sumarDigitos(12345)); // Esperado: 1+2+3+4+5 = 15
        System.out.println("Suma de dígitos de 987: " + sumarDigitos(987));     // Esperado: 9+8+7 = 24
        System.out.println("Suma de dígitos de 0: " + sumarDigitos(0));         // Esperado: 0
        System.out.println("Suma de dígitos de 7: " + sumarDigitos(7));         // Esperado: 7
        System.out.println("Suma de dígitos de 10: " + sumarDigitos(10));       // Esperado: 1+0 = 1
        System.out.println("Suma de dígitos de -123: " + sumarDigitos(-123));   // Esperado: 1+2+3 = 6
        System.out.println("Suma de dígitos de 9999: " + sumarDigitos(9999));   // Esperado: 36
    }
}
