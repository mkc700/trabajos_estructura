/**
 * Implementación de una Lista Simplemente Enlazada en Java
 * sin usar librerías, manejando explícitamente los apuntadores
 */
public class ListaSimplementeEnlazada {
    
    // Clase Nodo que representa cada elemento de la lista
    class Nodo {
        int dato;       // Dato almacenado en el nodo
        Nodo siguiente; // Apuntador al siguiente nodo
        
        // Constructor para crear un nuevo nodo
        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null; // Al crear un nodo, no apunta a ningún otro nodo
        }
    }
    
    // Apuntador al primer nodo de la lista
    private Nodo cabeza;
    
    // Constructor para crear una lista vacía
    public ListaSimplementeEnlazada() {
        this.cabeza = null; // Lista vacía: cabeza apunta a null
    }
    
    /**
     * Verifica si la lista está vacía
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        // La lista está vacía si cabeza apunta a null
        return cabeza == null;
    }
    
    /**
     * Inserta un nuevo nodo al inicio de la lista
     * @param dato Valor a insertar
     */
    public void insertarAlInicio(int dato) {
        // Crear nuevo nodo
        Nodo nuevoNodo = new Nodo(dato);
        
        if (estaVacia()) {
            // Si la lista está vacía, el nuevo nodo será la cabeza
            cabeza = nuevoNodo;
        } else {
            // Si la lista no está vacía:
            // 1. El apuntador 'siguiente' del nuevo nodo apuntará a donde apuntaba la cabeza
            nuevoNodo.siguiente = cabeza;
            // 2. La cabeza ahora apuntará al nuevo nodo
            cabeza = nuevoNodo;
        }
    }
    
    /**
     * Inserta un nuevo nodo al final de la lista
     * @param dato Valor a insertar
     */
    public void insertarAlFinal(int dato) {
        // Crear nuevo nodo
        Nodo nuevoNodo = new Nodo(dato);
        
        if (estaVacia()) {
            // Si la lista está vacía, el nuevo nodo será la cabeza
            cabeza = nuevoNodo;
        } else {
            // Si la lista no está vacía, recorremos hasta el último nodo
            Nodo actual = cabeza;
            
            // Mientras el nodo actual tenga un siguiente, avanzamos
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            
            // Al salir del bucle, 'actual' es el último nodo
            // Hacemos que el último nodo apunte al nuevo nodo
            actual.siguiente = nuevoNodo;
        }
    }
    
    /**
     * Inserta un nuevo nodo en una posición específica
     * @param dato Valor a insertar
     * @param posicion Posición donde insertar (0 es el inicio)
     */
    public void insertarEnPosicion(int dato, int posicion) {
        // Si la posición es 0, insertamos al inicio
        if (posicion == 0) {
            insertarAlInicio(dato);
            return;
        }
        
        // Crear nuevo nodo
        Nodo nuevoNodo = new Nodo(dato);
        
        // Nodo auxiliar para recorrer la lista
        Nodo actual = cabeza;
        int contador = 0;
        
        // Recorremos hasta la posición anterior a donde queremos insertar
        while (actual != null && contador < posicion - 1) {
            actual = actual.siguiente;
            contador++;
        }
        
        // Verificamos si la posición es válida
        if (actual == null) {
            System.out.println("Posición fuera de rango");
            return;
        }
        
        // Realizamos la inserción:
        // 1. El siguiente del nuevo nodo será el siguiente del nodo actual
        nuevoNodo.siguiente = actual.siguiente;
        // 2. El siguiente del nodo actual será el nuevo nodo
        actual.siguiente = nuevoNodo;
    }
    
    /**
     * Elimina el primer nodo de la lista
     */
    public void eliminarPrimero() {
        if (estaVacia()) {
            System.out.println("La lista está vacía, no se puede eliminar");
            return;
        }
        
        // Guardamos referencia al nodo a eliminar (para mostrar qué se eliminó)
        Nodo eliminado = cabeza;
        
        // La cabeza ahora apuntará al segundo nodo
        cabeza = cabeza.siguiente;
        
        // Desconectamos el nodo eliminado de la lista
        eliminado.siguiente = null;
        
        System.out.println("Nodo eliminado: " + eliminado.dato);
    }
    
    /**
     * Elimina el último nodo de la lista
     */
    public void eliminarUltimo() {
        if (estaVacia()) {
            System.out.println("La lista está vacía, no se puede eliminar");
            return;
        }
        
        // Si solo hay un nodo, eliminamos la cabeza
        if (cabeza.siguiente == null) {
            System.out.println("Nodo eliminado: " + cabeza.dato);
            cabeza = null;
            return;
        }
        
        // Si hay más de un nodo, necesitamos recorrer hasta el penúltimo
        Nodo actual = cabeza;
        Nodo anterior = null;
        
        // Recorremos hasta el último nodo
        while (actual.siguiente != null) {
            anterior = actual;
            actual = actual.siguiente;
        }
        
        // Al salir del bucle, 'actual' es el último nodo y 'anterior' es el penúltimo
        // Hacemos que el penúltimo nodo ya no apunte al último
        anterior.siguiente = null;
        
        System.out.println("Nodo eliminado: " + actual.dato);
    }
    
    /**
     * Elimina un nodo en una posición específica
     * @param posicion Posición del nodo a eliminar (0 es el inicio)
     */
    public void eliminarEnPosicion(int posicion) {
        if (estaVacia()) {
            System.out.println("La lista está vacía, no se puede eliminar");
            return;
        }
        
        // Si queremos eliminar el primer nodo
        if (posicion == 0) {
            eliminarPrimero();
            return;
        }
        
        // Nodos auxiliares para recorrer la lista
        Nodo actual = cabeza;
        Nodo anterior = null;
        int contador = 0;
        
        // Recorremos hasta la posición que queremos eliminar
        while (actual != null && contador < posicion) {
            anterior = actual;
            actual = actual.siguiente;
            contador++;
        }
        
        // Verificamos si la posición es válida
        if (actual == null) {
            System.out.println("Posición fuera de rango");
            return;
        }
        
        // Realizamos la eliminación:
        // El nodo anterior ahora apuntará al siguiente del nodo a eliminar
        anterior.siguiente = actual.siguiente;
        
        // Desconectamos el nodo eliminado de la lista
        actual.siguiente = null;
        
        System.out.println("Nodo eliminado: " + actual.dato);
    }
    
    /**
     * Busca un elemento en la lista
     * @param dato Valor a buscar
     * @return true si el elemento está en la lista, false en caso contrario
     */
    public boolean buscar(int dato) {
        // Si la lista está vacía, el elemento no está
        if (estaVacia()) {
            return false;
        }
        
        // Nodo auxiliar para recorrer la lista
        Nodo actual = cabeza;
        
        // Recorremos la lista
        while (actual != null) {
            // Si encontramos el dato, retornamos true
            if (actual.dato == dato) {
                return true;
            }
            // Avanzamos al siguiente nodo
            actual = actual.siguiente;
        }
        
        // Si llegamos aquí, el elemento no está en la lista
        return false;
    }
    
    /**
     * Recorre y muestra todos los elementos de la lista
     */
    public void recorrer() {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }
        
        System.out.println("Elementos de la lista:");
        
        // Nodo auxiliar para recorrer la lista
        Nodo actual = cabeza;
        
        // Recorremos la lista
        while (actual != null) {
            // Mostramos el dato del nodo actual
            System.out.print(actual.dato);
            
            // Si hay un siguiente nodo, mostramos una flecha
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            
            // Avanzamos al siguiente nodo
            actual = actual.siguiente;
        }
        
        System.out.println();
    }
    
    /**
     * Método principal para probar la lista
     */
    public static void main(String[] args) {
        ListaSimplementeEnlazada lista = new ListaSimplementeEnlazada();
        
        // Verificamos si la lista está vacía
        System.out.println("¿La lista está vacía? " + lista.estaVacia());
        
        // Insertamos elementos
        lista.insertarAlInicio(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarEnPosicion(15, 1);
        
        // Recorremos la lista
        lista.recorrer();
        
        // Buscamos elementos
        System.out.println("¿Está el 15 en la lista? " + lista.buscar(15));
        System.out.println("¿Está el 25 en la lista? " + lista.buscar(25));
        
        // Eliminamos elementos
        lista.eliminarPrimero();
        lista.recorrer();
        
        lista.eliminarEnPosicion(1);
        lista.recorrer();
        
        lista.eliminarUltimo();
        lista.recorrer();
        
        // Verificamos si la lista está vacía después de eliminar
        System.out.println("¿La lista está vacía? " + lista.estaVacia());
    }
}