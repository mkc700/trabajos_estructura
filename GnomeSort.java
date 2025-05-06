public class GnomeSort {
    
    /**
     * Método que implementa el ordenamiento Gnome
     */
    public static void gnomeSort(int[] arr) {
        int i = 0;
        // arr es el nombre de la variable que representa el arreglo
        while (i < arr.length) {
            // Si estamos al inicio o el elemento actual es mayor o igual al anterior
            if (i == 0 || arr[i] >= arr[i - 1]) {
                i++; // Avanzamos
            } else {
                // Intercambiamos elementos y retrocedemos
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
            // Mostramos el estado actual
         System.out.print("Estado-posicion("+i+"): ");
         imprimirArreglo(arr);
           
        }
    }
    
    /**
     * Método para imprimir un arreglo sin usar librerías
     */
    public static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        int[] arr = {23,58,16,14,20,19};
        
        System.out.print("Original: ");
        imprimirArreglo(arr);
        
        gnomeSort(arr);
        
        System.out.print("Ordenado: ");
        imprimirArreglo(arr);
    }
}

// Simulación simplificada
