
import java.util.concurrent.LinkedBlockingDeque;

public class cola_dinamica {
    public static void main(String[] args) {
        //creamos una cola pero sin un limite establecido,
        /* si se da cuenta el parametro de la instancia define
         * el limite de elementos de la variable 
         */
        LinkedBlockingDeque<Integer> colaDinamica = new LinkedBlockingDeque<>();

        //insertar elementos en la cola
        
        colaDinamica.add(5);
        colaDinamica.add(2);
        colaDinamica.add(6);
        colaDinamica.add(56);
        colaDinamica.add(7);
        colaDinamica.add(15);
        colaDinamica.add(12); 

        //eliminar de la cola
        colaDinamica.pollFirst();
        
        if (colaDinamica.isEmpty() == true) {
            System.out.println("la cola esta vacia");
          }  
   
          //la cola esta llena
   
          //el metodo de remainingCapacity te devuelve las posiciones
          //que quedan libres para llenar la cola
          if (colaDinamica.remainingCapacity() == 0) {
           System.out.println("la cola esta llena");
          }
        
        //el elemento al inicio
        /* con los metodos de peek consultamos los elementos del inicio(first)
         * y el final(last)
         */
        System.out.println("el primer elemento de la cola es: "+colaDinamica.peekFirst());

        //el elemento al final
        System.out.println("el ultimo elemento de la cola es: "+colaDinamica.peekLast());

  

    }
}
