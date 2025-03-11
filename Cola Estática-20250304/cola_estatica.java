import java.util.concurrent.LinkedBlockingDeque;

public class cola_estatica {
    public static void main(String[] args) {
        //esta libreria no acepta variables null
        //creo una cola con un limite de 6 elementos
        //array deque funciona con colas dinamicas
        LinkedBlockingDeque<Integer> cola = new LinkedBlockingDeque<>(6);
      
        // insertar en la cola
        cola.add(5);
        cola.add(7);
        cola.add(9);
        cola.add(3);

        //eliminar de la cola
        cola.pollFirst();

        cola.add(8);
    
        /*se puede consultar y eliminar el primer o el ultimo elemento
        de la cola con esta libreria pero para respetar la forma en
        como funcionan las colas dejaremos los metodos de este modo */
        
        //la cola esta vacia,lo que dice el metodo es muy literal
        // y devuelve un booleano
       if (cola.isEmpty() == true) {
         System.out.println("la cola esta vacia");
       }  

       //la cola esta llena

       //el metodo de remainingCapacity te devuelve las posiciones
       //que quedan libres para llenar la cola
       if (cola.remainingCapacity() == 0) {
        System.out.println("la cola esta llena");
       }

        //el elemento al inicio
        /* con los metodos de peek consultamos los elementos del inicio(first)
         * y el final(last)
         */
        System.out.println("el primer elemento de la cola es: "+cola.peekFirst());

        //el elemento al final
        System.out.println("el ultimo elemento de la cola es: "+cola.peekLast());

        


        

        
    }
}
