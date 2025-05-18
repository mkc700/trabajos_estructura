/**
 * Implementación de una Lista Doblemente Enlazada en Java
 * sin usar librerías, manejando explícitamente los apuntadores
 */
public class ListaDoblementeEnlazada {
    
    // Clase Nodo que representa cada elemento de la lista
    class Nodo {
        int dato;       // Dato almacenado en el nodo
        Nodo siguiente; // Apuntador al siguiente nodo
        Nodo anterior;  // Apuntador al nodo anterior
        
        // Constructor para crear un nuevo nodo
        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null; // Al crear un nodo, no apunta a ningún otro nodo
            this.anterior = null;  // Al crear un nodo, no tiene nodo anterior
        }
    }
    
    // Apuntadores al primer y último nodo de la lista
    private Nodo cabeza; // Primer nodo
    private Nodo cola;   // Último nodo
    
    // Constructor para crear una lista vacía
    public ListaDoblementeEnlazada() {
        this.cabeza = null; // Lista vacía: cabeza apunta a null
        this.cola = null;   // Lista vacía: cola apunta a null
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
            // Si la lista está vacía, el nuevo nodo será tanto la cabeza como la cola
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            // Si la lista no está vacía:
            // 1. El apuntador 'siguiente' del nuevo nodo apuntará a donde apuntaba la cabeza
            nuevoNodo.siguiente = cabeza;
            // 2. El apuntador 'anterior' de la cabeza actual apuntará al nuevo nodo
            cabeza.anterior = nuevoNodo;
            // 3. La cabeza ahora apuntará al nuevo nodo
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
            // Si la lista está vacía, el nuevo nodo será tanto la cabeza como la cola
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            // Si la lista no está vacía:
            // 1. El apuntador 'anterior' del nuevo nodo apuntará a donde apuntaba la cola
            nuevoNodo.anterior = cola;
            // 2. El apuntador 'siguiente' de la cola actual apuntará al nuevo nodo
            cola.siguiente = nuevoNodo;
            // 3. La cola ahora apuntará al nuevo nodo
            cola = nuevoNodo;
        }
    }
    
    /**
     * Busca un nodo con el valor especificado
     * @param dato Valor a buscar
     * @return El nodo que contiene el valor, o null si no se encuentra
     */
    public Nodo buscarNodo(int dato) {
        // Si la lista está vacía, retornamos null
        if (estaVacia()) {
            return null;
        }
        
        // Nodo auxiliar para recorrer la lista
        Nodo actual = cabeza;
        
        // Recorremos la lista
        while (actual != null) {
            // Si encontramos el dato, retornamos el nodo
            if (actual.dato == dato) {
                return actual;
            }
            // Avanzamos al siguiente nodo
            actual = actual.siguiente;
        }
        
        // Si llegamos aquí, el elemento no está en la lista
        return null;
    }
    
    /**
     * Inserta un nuevo nodo antes del nodo que contiene el valor especificado
     * @param valorReferencia Valor de referencia
     * @param nuevoDato Valor a insertar
     * @return true si se insertó correctamente, false si no se encontró el valor de referencia
     */
    public boolean insertarAntesDe(int valorReferencia, int nuevoDato) {
        // Buscamos el nodo de referencia
        Nodo nodoReferencia = buscarNodo(valorReferencia);
        
        // Si no encontramos el nodo de referencia, retornamos false
        if (nodoReferencia == null) {
            return false;
        }
        
        // Si el nodo de referencia es la cabeza, insertamos al inicio
        if (nodoReferencia == cabeza) {
            insertarAlInicio(nuevoDato);
            return true;
        }
        
        // Crear nuevo nodo
        Nodo nuevoNodo = new Nodo(nuevoDato);
        
        // Obtenemos el nodo anterior al nodo de referencia
        Nodo nodoAnterior = nodoReferencia.anterior;
        
        // Realizamos la inserción:
        // 1. El siguiente del nuevo nodo será el nodo de referencia
        nuevoNodo.siguiente = nodoReferencia;
        // 2. El anterior del nuevo nodo será el nodo anterior al de referencia
        nuevoNodo.anterior = nodoAnterior;
        // 3. El siguiente del nodo anterior será el nuevo nodo
        nodoAnterior.siguiente = nuevoNodo;
        // 4. El anterior del nodo de referencia será el nuevo nodo
        nodoReferencia.anterior = nuevoNodo;
        
        return true;
    }
    
    /**
     * Inserta un nuevo nodo después del nodo que contiene el valor especificado
     * @param valorReferencia Valor de referencia
     * @param nuevoDato Valor a insertar
     * @return true si se insertó correctamente, false si no se encontró el valor de referencia
     */
    public boolean insertarDespuesDe(int valorReferencia, int nuevoDato) {
        // Buscamos el nodo de referencia
        Nodo nodoReferencia = buscarNodo(valorReferencia);
        
        // Si no encontramos el nodo de referencia, retornamos false
        if (nodoReferencia == null) {
            return false;
        }
        
        // Si el nodo de referencia es la cola, insertamos al final
        if (nodoReferencia == cola) {
            insertarAlFinal(nuevoDato);
            return true;
        }
        
        // Crear nuevo nodo
        Nodo nuevoNodo = new Nodo(nuevoDato);
        
        // Obtenemos el nodo siguiente al nodo de referencia
        Nodo nodoSiguiente = nodoReferencia.siguiente;
        
        // Realizamos la inserción:
        // 1. El anterior del nuevo nodo será el nodo de referencia
        nuevoNodo.anterior = nodoReferencia;
        // 2. El siguiente del nuevo nodo será el nodo siguiente al de referencia
        nuevoNodo.siguiente = nodoSiguiente;
        // 3. El siguiente del nodo de referencia será el nuevo nodo
        nodoReferencia.siguiente = nuevoNodo;
        // 4. El anterior del nodo siguiente será el nuevo nodo
        nodoSiguiente.anterior = nuevoNodo;
        
        return true;
    }
    
    /**
     * Elimina un nodo con el valor especificado
     * @param dato Valor a eliminar
     * @return true si se eliminó correctamente, false si no se encontró el valor
     */
    public boolean borrar(int dato) {
        // Si la lista está vacía, retornamos false
        if (estaVacia()) {
            return false;
        }
        
        // Buscamos el nodo a eliminar
        Nodo nodoEliminar = buscarNodo(dato);
        
        // Si no encontramos el nodo, retornamos false
        if (nodoEliminar == null) {
            return false;
        }
        
        // Caso 1: Si el nodo a eliminar es el único en la lista
        if (cabeza == cola && cabeza == nodoEliminar) {
            cabeza = null;
            cola = null;
            return true;
        }
        
        // Caso 2: Si el nodo a eliminar es la cabeza
        if (nodoEliminar == cabeza) {
            // La nueva cabeza será el siguiente nodo
            cabeza = cabeza.siguiente;
            // El anterior de la nueva cabeza será null
            cabeza.anterior = null;
            // Desconectamos el nodo eliminado
            nodoEliminar.siguiente = null;
            return true;
        }
        
        // Caso 3: Si el nodo a eliminar es la cola
        if (nodoEliminar == cola) {
            // La nueva cola será el nodo anterior
            cola = cola.anterior;
            // El siguiente de la nueva cola será null
            cola.siguiente = null;
            // Desconectamos el nodo eliminado
            nodoEliminar.anterior = null;
            return true;
        }
        
        // Caso 4: Si el nodo a eliminar está en medio de la lista
        // Obtenemos los nodos anterior y siguiente al nodo a eliminar
        Nodo nodoAnterior = nodoEliminar.anterior;
        Nodo nodoSiguiente = nodoEliminar.siguiente;
        
        // Realizamos la eliminación:
        // 1. El siguiente del nodo anterior será el nodo siguiente
        nodoAnterior.siguiente = nodoSiguiente;
        // 2. El anterior del nodo siguiente será el nodo anterior
        nodoSiguiente.anterior = nodoAnterior;
        
        // Desconectamos el nodo eliminado
        nodoEliminar.anterior = null;
        nodoEliminar.siguiente = null;
        
        return true;
    }
    
    /**
     * Busca un elemento en la lista
     * @param dato Valor a buscar
     * @return true si el elemento está en la lista, false en caso contrario
     */
    public boolean buscar(int dato) {
        // Utilizamos el método buscarNodo y verificamos si retorna null
        return buscarNodo(dato) != null;
    }
    
    /**
     * Recorre y muestra todos los elementos de la lista de inicio a fin
     */
    public void recorrerInicioFin() {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }
        
        System.out.println("Recorrido de inicio a fin:");
        
        // Nodo auxiliar para recorrer la lista
        Nodo actual = cabeza;
        
        // Recorremos la lista desde la cabeza hasta la cola
        while (actual != null) {
            // Mostramos el dato del nodo actual
            System.out.print(actual.dato);
            
            // Si hay un siguiente nodo, mostramos una flecha
            if (actual.siguiente != null) {
                System.out.print(" <-> ");
            }
            
            // Avanzamos al siguiente nodo
            actual = actual.siguiente;
        }
        
        System.out.println();
    }
    
    /**
     * Recorre y muestra todos los elementos de la lista de fin a inicio
     */
    public void recorrerFinInicio() {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }
        
        System.out.println("Recorrido de fin a inicio:");
        
        // Nodo auxiliar para recorrer la lista
        Nodo actual = cola;
        
        // Recorremos la lista desde la cola hasta la cabeza
        while (actual != null) {
            // Mostramos el dato del nodo actual
            System.out.print(actual.dato);
            
            // Si hay un nodo anterior, mostramos una flecha
            if (actual.anterior != null) {
                System.out.print(" <-> ");
            }
            
            // Retrocedemos al nodo anterior
            actual = actual.anterior;
        }
        
        System.out.println();
    }
    
    /**
     * Método principal para probar la lista
     */
    public static void main(String[] args) {
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
        
        // Verificamos si la lista está vacía
        System.out.println("¿La lista está vacía? " + lista.estaVacia());
        
        // Insertamos elementos al inicio y al final
        lista.insertarAlInicio(10);
        lista.insertarAlFinal(30);
        lista.insertarAlInicio(5);
        lista.insertarAlFinal(40);
        
        // Recorremos la lista en ambas direcciones
        lista.recorrerInicioFin();
        lista.recorrerFinInicio();
        
        // Insertamos elementos antes y después de otros
        lista.insertarAntesDe(30, 20);  // Insertamos 20 antes de 30
        lista.insertarDespuesDe(30, 35); // Insertamos 35 después de 30
        
        // Recorremos la lista actualizada
        lista.recorrerInicioFin();
        
        // Buscamos elementos
        System.out.println("¿Está el 20 en la lista? " + lista.buscar(20));
        System.out.println("¿Está el 25 en la lista? " + lista.buscar(25));
        
        // Eliminamos elementos
        System.out.println("Eliminando el 5: " + lista.borrar(5));
        System.out.println("Eliminando el 40: " + lista.borrar(40));
        lista.recorrerInicioFin();
        
        System.out.println("Eliminando el 20: " + lista.borrar(20));
        lista.recorrerInicioFin();
        
        // Verificamos si la lista está vacía después de eliminar
        System.out.println("¿La lista está vacía? " + lista.estaVacia());
        
        // Eliminamos todos los elementos restantes
        lista.borrar(10);
        lista.borrar(30);
        lista.borrar(35);
        
        // Verificamos si la lista está vacía después de eliminar todos los elementos
        System.out.println("¿La lista está vacía? " + lista.estaVacia());
    }
}