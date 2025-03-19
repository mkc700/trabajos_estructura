import java.util.LinkedList;

public class ListaSimple {
    private LinkedList<Integer> lista;

    public ListaSimple() {
        lista = new LinkedList<>();
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return lista.isEmpty();
    }

    // Insertar un elemento en orden
    public void insertar(int valor) {
        // Se puede utilizar un iterador para mejorar la eficiencia de la búsqueda
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > valor) {
                lista.add(i, valor);
                return; // Salir después de insertar
            }
        }
        // Si llegamos aquí, el valor es mayor que todos los existentes
        lista.add(valor); 
    }

    // Borrar un nodo con un valor específico
    public void borrar(int valor) {
        if (!estaVacia()) {
            lista.removeFirstOccurrence(valor);
        }
    }

    // Recorrer la lista e imprimir los elementos
    public void recorrer() {
        System.out.println(lista);
    }

    // Buscar un elemento en la lista
    public boolean buscar(int valor) {
        return lista.contains(valor);
    }

    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple(); 
        
        lista.insertar(10);
        lista.insertar(5);
        lista.insertar(20);
        lista.insertar(15);
        lista.insertar(17);
        
        System.out.println("Lista después de inserciones: ");
        lista.recorrer();

        //System.out.println("Borrando el 10...");
        //lista.borrar(10);
        lista.recorrer();
        
        System.out.println(lista);

        //System.out.println("Buscando el 15: " + (lista.buscar(15) ? "Encontrado" : "No encontrado"));

        //System.out.println("La lista está " + (lista.estaVacia() ? "vacía" : "no vacía"));
    }
}