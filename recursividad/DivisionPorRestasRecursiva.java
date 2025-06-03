public class DivisionPorRestasRecursiva {

    /**
     * Realiza la división entera de dos números positivos utilizando restas sucesivas de forma recursiva.
     *
     * @param dividendo El número a ser dividido.
     * @param divisor   El número por el cual se divide.
     * @return El cociente de la división entera.
     * @throws IllegalArgumentException Si el divisor es cero o si alguno de los números es negativo.
     */
    public static int dividir(int dividendo, int divisor) {
        // Validación de entradas
        if (divisor == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        if (dividendo < 0 || divisor < 0) {
            throw new IllegalArgumentException("Este método solo soporta números positivos.");
            // Para soportar negativos, se necesitaría manejar los signos y convertir a positivos para la recursión,
            // luego ajustar el signo del resultado.
        }

        // Caso base: Si el dividendo es menor que el divisor, ya no podemos restar.
        // El cociente en este punto es 0.
        if (dividendo < divisor) {
            return 0;
        } else {
            // Proceso recursivo:
            // 1. Restamos el divisor del dividendo.
            // 2. Llamamos recursivamente con el nuevo dividendo (dividendo - divisor).
            // 3. Sumamos 1 al resultado de la llamada recursiva (porque hemos realizado una resta).
            return 1 + dividir(dividendo - divisor, divisor);
        }
    }

    public static void main(String[] args) {
        // Ejemplos de uso:
        System.out.println("División de 10 entre 2: " + dividir(10, 2)); // Esperado: 5
        System.out.println("División de 7 entre 3: " + dividir(7, 3));   // Esperado: 2 (7 - 3 = 4, 4 - 3 = 1. Dos restas.)
        System.out.println("División de 15 entre 5: " + dividir(15, 5)); // Esperado: 3
        System.out.println("División de 9 entre 9: " + dividir(9, 9));   // Esperado: 1
        System.out.println("División de 4 entre 8: " + dividir(4, 8));   // Esperado: 0 (caso base)
        System.out.println("División de 0 entre 5: " + dividir(0, 5));   // Esperado: 0 (caso base)

        // Pruebas de excepciones:
        try {
            System.out.println("División de 10 entre 0: " + dividir(10, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Esperado: El divisor no puede ser cero.
        }

        try {
            System.out.println("División de -10 entre 2: " + dividir(-10, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Esperado: Este método solo soporta números positivos.
        }
    }
}