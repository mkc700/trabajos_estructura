import java.util.ArrayDeque;
public class pila_estatica {
    public static void main(String[] args) {
   int limite = 5;
   ArrayDeque<Integer> pila = new ArrayDeque<>(limite); 
   
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

    //la pila llena
    if(pila.size() == limite){System.out.println("la pila esta llena");}

   //pila vacia
   if(pila.isEmpty() == true){System.out.println("la pila esta vacia");}
   
   //elemento en la cima
   pila.peek();

   //______________________________________________________________________
 
   
    }
}
