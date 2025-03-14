import java.util.ArrayList;
import java.util.Scanner;
public class listas_doble_enlazadas {
    public static void main(String[] args) {
        Scanner vard = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        // insertar en la lista:
        list.add(15);
        list.add(16);
        list.add(17);
        list.add(18);
        list.add(19);
        list.add(20);

        //insertar al inicio de la lista
        list.addFirst(14);        
        
        // insertar al final de la lista
        list.addLast(21);

        // insertar antes de un numero en una lista de array list      
        System.out.println("que numero desea agregar: ");
        int var = vard.nextInt();
        System.out.println("antes de que numero desea agregarlo: ");
        int var1 = vard.nextInt();
        
        //System.out.println("el numero que deseas agregar es "+var+" y el numero del cual antes vas a agregar es "+var1);
        
        
        for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == var1) {     
            list.add(i,var);
            //agrego la posicion
        }else{

        }
        }
        

        // mostrar todos los elementos
        System.out.println(list);
    }
}
