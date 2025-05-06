// Clase Nodo representa un elemento del Árbol Binario de Búsqueda (ABB)
class Nodo {
    int valor;          // Valor que guarda el nodo
    Nodo izquierda;     // Referencia al hijo izquierdo
    Nodo derecha;       // Referencia al hijo derecho

    // Constructor del Nodo
    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null; // Inicialmente no tiene hijos
    }
}

// Clase Cola para realizar el recorrido en anchura (tipo FIFO)
class Cola {
    Nodo[] elementos;   // Arreglo que guarda los nodos
    int inicio, fin, tamano; // Punteros de control

    // Constructor de la cola
    public Cola(int capacidad) {
        elementos = new Nodo[capacidad];
        inicio = fin = tamano = 0;
    }

    // Método para agregar (encolar) un nodo
    public void encolar(Nodo nodo) {
        elementos[fin++] = nodo;
        tamano++;
    }

    // Método para eliminar (desencolar) un nodo
    public Nodo desencolar() {
        tamano--;
        return elementos[inicio++];
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return tamano == 0;
    }
}

// Clase principal del Árbol Binario de Búsqueda
class ABB {
    Nodo raiz;  // Nodo raíz del árbol

    // Constructor del ABB
    public ABB() {
        raiz = null;    // El árbol empieza vacío
    }

    // Método público para insertar un nuevo valor
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    // Método recursivo privado que realiza la inserción
    private Nodo insertarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor); // Si no existe nodo, lo creamos
            return nodo;
        }
        if (valor < nodo.valor) {
            nodo.izquierda = insertarRec(nodo.izquierda, valor); // Insertar a la izquierda
        } else {
            nodo.derecha = insertarRec(nodo.derecha, valor);     // Insertar a la derecha
        }
        return nodo;
    }

    // Método para recorrer el árbol en INORDEN (izquierda - raíz - derecha)
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecha);
        }
    }

    // Método para recorrer el árbol en PREORDEN (raíz - izquierda - derecha)
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierda);
            preorden(nodo.derecha);
        }
    }

    // Método para recorrer el árbol en POSTORDEN (izquierda - derecha - raíz)
    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierda);
            postorden(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    // Método para recorrer el árbol en ANCHURA (nivel por nivel)
    public void anchura() {
        if (raiz == null) return; // Árbol vacío, no hace nada

        Cola cola = new Cola(100); // Creamos una cola de capacidad 100
        cola.encolar(raiz);         // Insertamos la raíz

        while (!cola.estaVacia()) {
            Nodo actual = cola.desencolar(); // Sacamos el primer nodo
            System.out.print(actual.valor + " "); // Mostramos su valor

            // Insertamos sus hijos (si existen) en la cola
            if (actual.izquierda != null) {
                cola.encolar(actual.izquierda);
            }
            if (actual.derecha != null) {
                cola.encolar(actual.derecha);
            }
        }
    }

    // Método para contar la cantidad total de nodos en el árbol
    public int contarNodos(Nodo nodo) {
        if (nodo == null) return 0; // Si no hay nodo, no cuenta
        return 1 + contarNodos(nodo.izquierda) + contarNodos(nodo.derecha); // Cuenta el actual más los de sus hijos
    }

    // Método para contar únicamente los nodos HOJA (nodos sin hijos)
    public int contarHojas(Nodo nodo) {
        if (nodo == null) return 0; // Si no hay nodo, no cuenta
        if (nodo.izquierda == null && nodo.derecha == null) return 1; // Si no tiene hijos, es hoja
        return contarHojas(nodo.izquierda) + contarHojas(nodo.derecha); // Sigue buscando hojas
    }
}

// Clase Main para ejecutar el programa
public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB(); // Creamos un árbol vacío

        // Insertamos varios valores
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            arbol.insertar(v);
        }

        // Mostramos los distintos recorridos
        System.out.println("\nRecorrido Inorden:");
        arbol.inorden(arbol.raiz);

        System.out.println("\n\nRecorrido Preorden:");
        arbol.preorden(arbol.raiz);

        System.out.println("\n\nRecorrido Postorden:");
        arbol.postorden(arbol.raiz);

        System.out.println("\n\nRecorrido en Anchura:");
        arbol.anchura();

        // Mostramos la cantidad de nodos y de hojas
        System.out.println("\n\nCantidad total de nodos: " + arbol.contarNodos(arbol.raiz));
        System.out.println("Cantidad de nodos hoja: " + arbol.contarHojas(arbol.raiz));
    }
}
