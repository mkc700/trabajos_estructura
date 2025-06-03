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
        Nodo actual = cabeza;
        // Caso 1: Lista vacía 
        if (cabeza == null || dato < cabeza.dato) {
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        return;
    }
        
        // Caso 2: Buscar la posición correcta para insertar
        
        while (actual.siguiente != null && actual.siguiente.dato < dato ) {
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
    public void eliminar(int dato) {
        if (estaVacia()) {
            System.out.println("La lista está vacía, no se puede eliminar");
            return;
        }
        
        // Nodos auxiliares para recorrer la lista
        Nodo actual = cabeza;
        Nodo anterior = null;
        
        
        // Recorremos hasta la posición que queremos eliminar
        /**/
        while (actual != null && actual.dato < dato) {
            anterior = actual;
            actual = actual.siguiente;
            
        }
        
        // Verificamos si la posición es válida
        
        if (actual == null) {
            System.out.println("dato no encontrado");
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
            System.out.println("el valor no esta");
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
        System.out.println("el valor no esta");
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
        lista.insertar(12);
        lista.insertar(11);
       
        lista.insertar(10);
        lista.insertar(8);

        
        System.out.println("lista original");
        lista.recorrer();
        System.out.println("lista despues de la eliminacion del 11");
        lista.eliminar(11);
        lista.recorrer();
       
       
        //lista.eliminarEnPosicion(2);

        //lista.recorrer();
        
    }
}