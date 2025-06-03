public class MaximoArrayRecursivo {

    /**
     * Encuentra el valor máximo en un arreglo de enteros de forma recursiva.
     * Esta versión utiliza un índice para recorrer el arreglo desde el inicio.
     *
     * @param arr El arreglo de enteros.
     * @param index El índice actual desde el cual se empezará a buscar el máximo.
     * Inicialmente, debe ser 0 para buscar en todo el arreglo.
     * @return El valor máximo encontrado en el subarreglo desde 'index' hasta el final.
     * @throws IllegalArgumentException Si el arreglo es nulo o está vacío.
     */
    public static int encontrarMaximo(int[] arr, int index) {
        // Validación inicial (podría hacerse en el método wrapper también)
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo o vacío.");
        }

        // Caso base: Si el índice ha llegado al último elemento del arreglo,
        // ese elemento es el máximo en esta sub-llamada.
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Proceso recursivo:
        // 1. Encuentra el máximo del resto del arreglo (desde el siguiente índice).
        int maxDelResto = encontrarMaximo(arr, index + 1);

        // 2. Compara el elemento actual (arr[index]) con el máximo del resto.
        //    Devuelve el mayor de los dos.
        if (arr[index] > maxDelResto) {
            return arr[index];
        } else {
            return maxDelResto;
        }

        // Forma más concisa del return del paso recursivo:
        // return Math.max(arr[index], encontrarMaximo(arr, index + 1));
    }

    /**
     * Método auxiliar (wrapper) para encontrar el valor máximo en un arreglo.
     * Simplifica la llamada inicial al método recursivo.
     *
     * @param arr El arreglo de enteros.
     * @return El valor máximo en el arreglo.
     * @throws IllegalArgumentException Si el arreglo es nulo o está vacío.
     */
    public static int encontrarMaximoEnArray(int[] arr) {
        // Delegar la validación al método recursivo o manejarla aquí.
        // Aquí la manejamos para tener un punto de entrada más limpio.
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo o vacío.");
        }
        return encontrarMaximo(arr, 0); // Inicia la recursión desde el primer elemento (índice 0)
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9, 1, 7};
        System.out.println("Máximo en arr1: " + encontrarMaximoEnArray(arr1)); // Esperado: 9

        int[] arr2 = {10, 3, 25, 8, 12, 1};
        System.out.println("Máximo en arr2: " + encontrarMaximoEnArray(arr2)); // Esperado: 25

        int[] arr3 = {42};
        System.out.println("Máximo en arr3: " + encontrarMaximoEnArray(arr3)); // Esperado: 42

        int[] arr4 = {-5, -1, -10, -3};
        System.out.println("Máximo en arr4: " + encontrarMaximoEnArray(arr4)); // Esperado: -1

        try {
            int[] arrVacio = {};
            System.out.println("Máximo en arreglo vacío: " + encontrarMaximoEnArray(arrVacio));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Esperado: El arreglo no puede ser nulo o vacío.
        }

        try {
            int[] arrNulo = null;
            System.out.println("Máximo en arreglo nulo: " + encontrarMaximoEnArray(arrNulo));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Esperado: El arreglo no puede ser nulo o vacío.
        }
    }
}
