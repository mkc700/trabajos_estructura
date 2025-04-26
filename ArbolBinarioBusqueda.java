// Clase que representa un nodo del árbol
class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;
    
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

// Implementación propia de una cola para el recorrido en anchura
class Cola {
    private Nodo[] elementos;
    private int capacidad;
    private int frente;
    private int final;
    private int tamaño;
    
    public Cola(int capacidad) {
        this.capacidad = capacidad;
        elementos = new Nodo[capacidad];
        frente = 0;
        final = -1;
        tamaño = 0;
    }
    
    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return tamaño == 0;
    }
    
    // Verificar si la cola está llena
    public boolean estaLlena() {
        return tamaño == capacidad;
    }
    
    // Agregar un elemento al final de la cola
    public void encolar(Nodo nodo) {
        if (estaLlena()) {
            // Si la cola está llena, aumentamos su capacidad
            redimensionar();
        }
        
        final = (final + 1) % capacidad;
        elementos[final] = nodo;
        tamaño++;
    }
    
    // Sacar el elemento del frente de la cola
    public Nodo desencolar() {
        if (estaVacia()) {
            return null;
        }
        
        Nodo nodo = elementos[frente];
        elementos[frente] = null;
        frente = (frente + 1) % capacidad;
        tamaño--;
        
        return nodo;
    }
    
    // Redimensionar la cola cuando está llena
    private void redimensionar() {
        int nuevaCapacidad = capacidad * 2;
        Nodo[] nuevosElementos = new Nodo[nuevaCapacidad];
        
        // Copiamos los elementos a la nueva cola
        for (int i = 0; i < tamaño; i++) {
            nuevosElementos[i] = elementos[(frente + i) % capacidad];
        }
        
        elementos = nuevosElementos;
        capacidad = nuevaCapacidad;
        frente = 0;
        final = tamaño - 1;
    }
}

// Clase principal del Árbol Binario de Búsqueda
class ArbolBinarioBusqueda {
    private Nodo raiz;
    
    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }
    
    // Método público para insertar un valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }
    
    // Método recursivo para insertar un valor
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        // Si el nodo es nulo, creamos un nuevo nodo
        if (nodo == null) {
            return new Nodo(valor);
        }
        
        // Si el valor es menor, insertamos en el subárbol izquierdo
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } 
        // Si el valor es mayor, insertamos en el subárbol derecho
        else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        // Si el valor ya existe, no hacemos nada (no permitimos duplicados)
        
        return nodo;
    }
    
    // Método para realizar recorrido en anchura (por niveles) sin usar librerías
    public void recorridoAnchura() {
        if (raiz == null) {
            System.out.println("El árbol está vacío");
            return;
        }
        
        // Utilizamos nuestra propia implementación de cola
        Cola cola = new Cola(10); // Capacidad inicial de 10
        cola.encolar(raiz);
        
        System.out.print("Recorrido en anchura: ");
        
        while (!cola.estaVacia()) {
            Nodo nodoActual = cola.desencolar();
            System.out.print(nodoActual.valor + " ");
            
            // Agregamos los hijos a la cola
            if (nodoActual.izquierdo != null) {
                cola.encolar(nodoActual.izquierdo);
            }
            
            if (nodoActual.derecho != null) {
                cola.encolar(nodoActual.derecho);
            }
        }
        System.out.println();
    }
    
    // Método público para recorrido inorden
    public void recorridoInorden() {
        System.out.print("Recorrido inorden: ");
        inorden(raiz);
        System.out.println();
    }
    
    // Método recursivo para recorrido inorden
    private void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }
    
    // Método público para recorrido preorden
    public void recorridoPreorden() {
        System.out.print("Recorrido preorden: ");
        preorden(raiz);
        System.out.println();
    }
    
    // Método recursivo para recorrido preorden
    private void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }
    
    // Método público para recorrido postorden
    public void recorridoPostorden() {
        System.out.print("Recorrido postorden: ");
        postorden(raiz);
        System.out.println();
    }
    
    // Método recursivo para recorrido postorden
    private void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }
    
    // Método público para contar nodos
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }
    
    // Método recursivo para contar nodos
    private int contarNodosRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        
        // Contamos el nodo actual más los nodos de los subárboles
        return 1 + contarNodosRecursivo(nodo.izquierdo) + contarNodosRecursivo(nodo.derecho);
    }
    
    // Método público para contar nodos hoja
    public int contarNodosHoja() {
        return contarNodosHojaRecursivo(raiz);
    }
    
    // Método recursivo para contar nodos hoja
    private int contarNodosHojaRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        
        // Si es un nodo hoja (sin hijos), retornamos 1
        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }
        
        // Si no es hoja, sumamos las hojas de los subárboles
        return contarNodosHojaRecursivo(nodo.izquierdo) + contarNodosHojaRecursivo(nodo.derecho);
    }
    
    // Método para visualizar la estructura del árbol (para depuración)
    public void mostrarArbol() {
        mostrarArbolRecursivo(raiz, 0);
    }
    
    private void mostrarArbolRecursivo(Nodo nodo, int nivel) {
        if (nodo != null) {
            mostrarArbolRecursivo(nodo.derecho, nivel + 1);
            
            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            
            System.out.println(nodo.valor);
            
            mostrarArbolRecursivo(nodo.izquierdo, nivel + 1);
        }
    }
    
    // Programa principal para probar la implementación
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        
        // Insertamos algunos valores
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 15, 25, 35, 45};
        
        System.out.println("Insertando valores en el árbol:");
        for (int valor : valores) {
            System.out.println("Insertando: " + valor);
            arbol.insertar(valor);
        }
        
        System.out.println("\nEstructura del árbol:");
        arbol.mostrarArbol();
        
        System.out.println("\nRecorridos del árbol:");
        arbol.recorridoInorden();
        arbol.recorridoPreorden();
        arbol.recorridoPostorden();
        arbol.recorridoAnchura();
        
        System.out.println("\nEstadísticas del árbol:");
        System.out.println("Número total de nodos: " + arbol.contarNodos());
        System.out.println("Número de nodos hoja: " + arbol.contarNodosHoja());
    }
}

// Ejecutamos el programa principal
//ArbolBinarioBusqueda.main(null);