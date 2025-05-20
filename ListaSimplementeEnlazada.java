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
     
     */
    public boolean estaVacia() {
        // La lista está vacía si cabeza apunta a null
        return cabeza == null;
    }
    
    
   public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        
        // Caso 1: Lista vacía o el nuevo dato es menor que el dato de la cabeza
        if (cabeza == null || dato < cabeza.dato) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
            return;
        }
        
        // Caso 2: Buscar la posición correcta para insertar
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato < dato) {
            actual = actual.siguiente;
        }
        
        // Insertar el nuevo nodo después de 'actual'
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;
    }
    //_____________________________________________________________________________________
    /**
     * Elimina un nodo en una posición específica
     
     */
    public void eliminarEnPosicion(int posicion) {
        if (estaVacia()) {
            System.out.println("La lista está vacía, no se puede eliminar");
            return;
        }
        
        // Si queremos eliminar el primer nodo
        if (posicion == 0) {

            // Guardamos referencia al nodo a eliminar (para mostrar qué se eliminó)
            Nodo eliminado = cabeza;
        
            // La cabeza ahora apuntará al segundo nodo
            cabeza = cabeza.siguiente;
        
            // Desconectamos el nodo eliminado de la lista
            eliminado.siguiente = null;
        
            System.out.println("Nodo eliminado: " + eliminado.dato);
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
        
        lista.insertar(15);
        lista.insertar(20);
        lista.insertar(35);
        lista.insertar(10);
        lista.insertar(8);
        
        // Recorremos la lista
        lista.recorrer();
        
        // Buscamos elementos
        System.out.println("¿Está el 15 en la lista? " + lista.buscar(15));
        System.out.println("¿Está el 25 en la lista? " + lista.buscar(25));
        
        // Eliminamos elementos
        
        lista.recorrer();
        
        lista.eliminarEnPosicion(1);
        lista.recorrer();
        
        lista.recorrer();
        
        // Verificamos si la lista está vacía después de eliminar
        System.out.println("¿La lista está vacía? " + lista.estaVacia());
    }
}