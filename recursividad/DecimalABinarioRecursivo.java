public class DecimalABinarioRecursivo {

    /**
     * Convierte un número entero en base decimal a su representación en binario de manera recursiva.
     *
     * @param n El número entero decimal a convertir.
     * @return Una cadena de texto que representa el número en binario.
     */
    public static String decimalABinario(int n) {
        // Caso base: Si n es menor que 2 (es decir, 0 o 1), su representación binaria es el propio n.
        if (n < 2) {
            return String.valueOf(n); // Convertimos el 0 o 1 a su representación en String.
        } else {
            // Proceso recursivo:
            // 1. Llamada recursiva para la división entera de n entre 2.
            //    Esto construye los bits más significativos.
            // 2. Concatenamos el resultado de la llamada recursiva
            //    con el resto de la división de n entre 2 (el bit menos significativo actual).
            return decimalABinario(n / 2) + String.valueOf(n % 2);
        }
    }

    public static void main(String[] args) {
        // Ejemplos de uso:
        int numero1 = 2;
        System.out.println("El número " + numero1 + " en binario es: " + decimalABinario(numero1)); // Esperado: 10

        int numero2 = 3;
        System.out.println("El número " + numero2 + " en binario es: " + decimalABinario(numero2)); // Esperado: 11

        int numero3 = 5;
        System.out.println("El número " + numero3 + " en binario es: " + decimalABinario(numero3)); // Esperado: 101

        int numero4 = 10;
        System.out.println("El número " + numero4 + " en binario es: " + decimalABinario(numero4)); // Esperado: 1010

        int numero5 = 0;
        System.out.println("El número " + numero5 + " en binario es: " + decimalABinario(numero5)); // Esperado: 0 (caso base)

        int numero6 = 1;
        System.out.println("El número " + numero6 + " en binario es: " + decimalABinario(numero6)); // Esperado: 1 (caso base)

        int numero7 = 25;
        System.out.println("El número " + numero7 + " en binario es: " + decimalABinario(numero7)); // Esperado: 11001
    }
}
