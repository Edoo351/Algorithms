package DLL;
import java.util.*;
public class Zad8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> lista = new DLL<Integer>();
        for (int i = 0; i < n; i++){
            lista.insertLast(sc.nextInt());
        }
        int m = sc.nextInt();
        rotatoeItToBegining(lista , m);
        System.out.println(lista);
    }

    public static void rotatoeItToBegining(DLL<Integer> lista , int m){
        DLLNode<Integer> temp = lista.getFirst();
        for (int i= 0; i < m; i++) {
            lista.insertLast(temp.element);
            lista.delete(temp);
            temp=temp.succ;
        }
    }
}
