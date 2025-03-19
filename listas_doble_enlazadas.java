import java.util.ArrayList;
import java.util.Scanner;
public class listas_doble_enlazadas {
    public static void main(String[] args) {
        Scanner vard = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
//_____________________________________________________________________________________________________________        
        // insertar en la lista:
        list.add(15);
        list.add(16);
        list.add(17);
        list.add(18);
        list.add(19);
        list.add(20);
 //_____________________________________________________________________________________________________________
        //insertar al inicio de la lista
        list.addFirst(14);        
//_____________________________________________________________________________________________________________   
        // insertar al final de la lista
        list.addLast(21);
//_____________________________________________________________________________________________________________
        // insertar antes de un numero en una lista      
      
        System.out.println("que numero desea agregar: ");
        int var = vard.nextInt();
        System.out.println("antes de que numero desea agregarlo: ");
        int var1 = vard.nextInt();
        
      
       
        for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == var1) {   
            list.add(i,var);
            break;
            }
            //agrego la posicion
        }
//_____________________________________________________________________________________________________________
        // insertar despues de un numero en una lista     
       
        System.out.println("que numero desea agregar: ");
        int var2 = vard.nextInt();
        System.out.println("despues de que numero desea agregarlo: ");
        int va3 = vard.nextInt();


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == var2) {   
                list.add(i+1,va3);
                break;
                }
                //agrego la posicion
            }
//_____________________________________________________________________________________________________________
        //borrar un elemento de la lista
        
        System.out.println("que elemento desea borrar: ");    
        int delete_try = vard.nextInt();
        for (int i = 0; i < list.size(); i++) {
            while(list.get(i) == delete_try){
                list.remove(i);
                break;
            } 
          
        }
 //_____________________________________________________________________________________________________________       
        // operacion de recorrido de inicio a fin

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//______________________________________________________________________________________________________________
        // operacion de recorrido de fin a inicio
        System.out.println("de fin a inicio");

        for (int i = list.size() - 1; i >= 0; i++) {
            System.out.println(list.get(i));
        }
//_____________________________________________________________________________________________________________
        // operacion busqueda de un elemento

        System.out.println("que elemento desea buscar");
        int var4 = vard.nextInt();

        for (int i = 0; i < list.size(); i++) {
           if (list.get(i)==var4) {
            System.err.println("tu elemento esta en la posicion "+i);
            break;
           }
        }
//_____________________________________________________________________________________________________________
        //operacion de busqueda de un elemento (devuelve su posicion)
        System.out.println("metodo para comprobar que la columna esta vacia");

        if (list.isEmpty()== true) {
            System.out.println("la lista esta vacia");
        }else{
            System.out.println("la lista no esta vacia");
        }

    }
}
