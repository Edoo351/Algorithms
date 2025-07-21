package DLL;
import java.util.*;
public class Zad7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextInt());
        }
        int M = sc.nextInt();
        System.out.println(lista);
        rotateLastOnesToBegining(lista,M);
        System.out.println(lista);
    }
    public static void rotateLastOnesToBegining(DLL<Integer> lista, int M) {
        DLLNode<Integer> temp = lista.getLast();
        for (int i = 0; i < M; i++) {
            lista.insertFirst(temp.element);
            lista.delete(temp);
            temp=temp.pred;
        }
    }
}
