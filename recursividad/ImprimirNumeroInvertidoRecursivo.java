public class ImprimirNumeroInvertidoRecursivo {

    /**
     * Imprime los dígitos de un número entero en forma invertida de manera recursiva.
     * Soporta números positivos y negativos (los maneja como si fueran positivos para la impresión de dígitos,
     * e imprime el signo al inicio si es negativo).
     *
     * @param n El número entero cuyos dígitos se imprimirán invertidos.
     */
    public static void imprimirDigitosInvertidos(int n) {
        // Manejo de números negativos:
        // Si el número es negativo, imprimimos el signo '-' y luego trabajamos con su valor absoluto.
        if (n < 0) {
            System.out.print("-");
            n = -n; // Convertir a positivo para procesar los dígitos
        }

        // Caso base: Si el número es un solo dígito (0-9), lo imprimimos directamente.
        if (n < 10) {
            System.out.print(n);
        } else {
            // Proceso recursivo:
            // 1. Imprime el último dígito del número (n % 10).
            //    Este es el dígito que debe aparecer primero en la salida invertida.
            System.out.print(n % 10);

            // 2. Llama recursivamente a la función con el número sin su último dígito (n / 10).
            //    Esta llamada se encargará de imprimir los dígitos restantes en orden invertido.
            imprimirDigitosInvertidos(n / 10);
        }
    }

    public static void main(String[] args) {
        System.out.print("El número 12345 invertido es: ");
        imprimirDigitosInvertidos(12345); // Esperado: 54321
        System.out.println(); // Salto de línea

        System.out.print("El número 987 invertido es: ");
        imprimirDigitosInvertidos(987); // Esperado: 789
        System.out.println();

        System.out.print("El número 0 invertido es: ");
        imprimirDigitosInvertidos(0);   // Esperado: 0
        System.out.println();

        System.out.print("El número 7 invertido es: ");
        imprimirDigitosInvertidos(7);   // Esperado: 7
        System.out.println();

        System.out.print("El número 10 invertido es: ");
        imprimirDigitosInvertidos(10);  // Esperado: 01 (Cuidado aquí: el 0 inicial es un dígito)
        System.out.println();

        System.out.print("El número -1234 invertido es: ");
        imprimirDigitosInvertidos(-1234); // Esperado: -4321
        System.out.println();
    }
}