public class SumaVectorRecursiva {

    /**
     * Calcula la suma de los elementos de un vector (array) de enteros de manera recursiva.
     * Esta versión utiliza un índice para recorrer el array.
     *
     * @param arr El array de enteros.
     * @param index El índice actual desde el cual se empezará a sumar.
     * Inicialmente, debe ser 0 para sumar todo el array.
     * @return La suma de los elementos del array desde el 'index' hasta el final.
     */
    public static int sumarElementos(int[] arr, int index) {
        // Caso base 1: Si el índice ha llegado al final del array, no hay más elementos que sumar.
        if (index >= arr.length) {
            return 0; // La suma de ningún elemento es 0
        }
        // Caso base 2 (implícito en el flujo): Si solo queda un elemento (última llamada),
        // se suma y la siguiente llamada (index + 1) activará el primer caso base.

        // Proceso recursivo: Suma el elemento actual y llama recursivamente para el resto del array.
        // arr[index] es el elemento actual.
        // sumarElementos(arr, index + 1) es la suma de los elementos restantes.
        return arr[index] + sumarElementos(arr, index + 1);
    }

    /**
     * Método auxiliar para llamar a la función recursiva sin necesidad de especificar el índice inicial.
     * Comienza la suma desde el primer elemento del array (índice 0).
     *
     * @param arr El array de enteros a sumar.
     * @return La suma total de todos los elementos del array.
     */
    public static int sumarVector(int[] arr) {
        // Manejo de caso especial para un array vacío (aunque el caso base principal ya lo cubre)
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return sumarElementos(arr, 0); // Inicia la recursión desde el índice 0
    }

    public static void main(String[] args) {
        int[] vector1 = {1, 2, 3, 4, 5};
        System.out.println("La suma de los elementos del vector1 es: " + sumarVector(vector1)); // Esperado: 15

        int[] vector2 = {10, 20, 30};
        System.out.println("La suma de los elementos del vector2 es: " + sumarVector(vector2)); // Esperado: 60

        int[] vector3 = {7};
        System.out.println("La suma de los elementos del vector3 es: " + sumarVector(vector3)); // Esperado: 7

        int[] vector4 = {}; // Vector vacío
        System.out.println("La suma de los elementos del vector4 es: " + sumarVector(vector4)); // Esperado: 0

        int[] vector5 = { -1, 5, -3, 8 };
        System.out.println("La suma de los elementos del vector5 es: " + sumarVector(vector5)); // Esperado: 9
    }
}