import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class colas_pilas_ {
    public static void main(String[] args) {
           //pila dinamica
    ArrayDeque<Integer> pila = new ArrayDeque<>(); 
   
    //insertar elementos(push)
    pila.push(5);
    pila.push(4);
    pila.push(3);
    pila.push(2);
    pila.push(1);

   //eliminar elmentos pop()
   pila.pop();

   //ver elementos
   pila.peek();
   
   //pila vacia
   if(pila.isEmpty() == true){System.out.println("la pila esta vacia");}
   
   //elemento en la cima
   pila.peek();

   //______________________________________________________________________
 // pila estatica
 int limite = 5;
   ArrayDeque<Integer> pilaf = new ArrayDeque<>(limite); 
   
   //insertar elementos(push)
   pilaf.push(5);
   pilaf.push(4);
   pilaf.push(3);
   pilaf.push(2);
   pilaf.push(1);

   //eliminar elmentos pop()
   pilaf.pop();

   //ver elementos
   pilaf.peek();

    //la pila llena
    if(pilaf.size() == limite){System.out.println("la pila esta llena");}

   //pila vacia
   if(pilaf.isEmpty() == true){System.out.println("la pila esta vacia");}
   
   //elemento en la cima
   pilaf.peek();

   //______________________________________________________________________
     // cola estatica
     //la libreria no acepta variables null
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

        //cola dinamica
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
