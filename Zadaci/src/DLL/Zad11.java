package DLL;
import org.w3c.dom.Node;

import java.util.*;
public class Zad11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextInt());
        }
        int M = sc.nextInt();
        System.out.println(lista);
        rotateOnLastToFirst(lista,M);
        System.out.println(lista);
    }
    public static void rotateOnLastToFirst(DLL<Integer> lista, int M) {
        DLLNode<Integer> temp = lista.getLast();
        for (int i = 0; i < M; i++) {
            lista.insertFirst(temp.element);
            lista.delete(temp);
            temp=temp.pred;
        }
    }
}
