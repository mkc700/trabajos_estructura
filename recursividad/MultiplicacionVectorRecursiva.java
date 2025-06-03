public class MultiplicacionVectorRecursiva {

    /**
     * Calcula la multiplicación de los elementos de un vector (array) de enteros de manera recursiva.
     * Esta versión utiliza un índice para recorrer el array.
     *
     * @param arr El array de enteros.
     * @param index El índice actual desde el cual se empezará a multiplicar.
     * Inicialmente, debe ser 0 para multiplicar todo el array.
     * @return El producto de los elementos del array desde el 'index' hasta el final.
     */
    public static long multiplicarElementos(int[] arr, int index) {
        // Caso base: Si el índice ha llegado al final del array, no hay más elementos que multiplicar.
        // El producto de una lista vacía de números es 1 (elemento neutro de la multiplicación).
        if (index >= arr.length) {
            return 1;
        }

        // Proceso recursivo: Multiplica el elemento actual y llama recursivamente para el resto del array.
        // arr[index] es el elemento actual.
        // multiplicarElementos(arr, index + 1) es el producto de los elementos restantes.
        return (long)arr[index] * multiplicarElementos(arr, index + 1);
    }

    /**
     * Método auxiliar para llamar a la función recursiva sin necesidad de especificar el índice inicial.
     * Comienza la multiplicación desde el primer elemento del array (índice 0).
     *
     * @param arr El array de enteros a multiplicar.
     * @return El producto total de todos los elementos del array.
     */
    public static long multiplicarVector(int[] arr) {
        // Manejo de caso especial para un array nulo.
        if (arr == null) {
            return 1; // Un array nulo no tiene elementos, su producto es 1.
        }
        // El caso de array vacío (arr.length == 0) ya lo cubre el caso base de multiplicarElementos.
        return multiplicarElementos(arr, 0); // Inicia la recursión desde el índice 0
    }

    public static void main(String[] args) {
        int[] vector1 = {1, 2, 3, 4, 5};
        System.out.println("La multiplicación de los elementos del vector1 es: " + multiplicarVector(vector1)); // Esperado: 120 (1*2*3*4*5)

        int[] vector2 = {10, 2, 3};
        System.out.println("La multiplicación de los elementos del vector2 es: " + multiplicarVector(vector2)); // Esperado: 60 (10*2*3)

        int[] vector3 = {7};
        System.out.println("La multiplicación de los elementos del vector3 es: " + multiplicarVector(vector3)); // Esperado: 7

        int[] vector4 = {}; // Vector vacío
        System.out.println("La multiplicación de los elementos del vector4 es: " + multiplicarVector(vector4)); // Esperado: 1 (caso base)

        int[] vector5 = { -1, 5, -3, 2 };
        System.out.println("La multiplicación de los elementos del vector5 es: " + multiplicarVector(vector5)); // Esperado: 30 (-1*5*-3*2)

        int[] vectorConCero = {1, 2, 0, 4};
        System.out.println("La multiplicación de los elementos del vectorConCero es: " + multiplicarVector(vectorConCero)); // Esperado: 0
    }
}
