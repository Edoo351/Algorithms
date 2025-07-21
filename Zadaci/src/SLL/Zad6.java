package SLL;
import java.util.*;
public class Zad6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<String> lista = new SLL<String>();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextLine());
        }
        int M = sc.nextInt();
        System.out.println(lista);
        findSameOnePutOnFirst(lista,N,M);

    }
    public static void findSameOnePutOnFirst(SLL<String> lista, int N, int M) {
        SLLNode<String> temp = lista.getFirst();
        SLLNode<String> findeOne = null;
        boolean found = false;
        while (temp != null) {
            if (N==1){
                System.out.println(lista);
                return;
            }
            if (temp.element.length()==M){
                findeOne = temp;
                found = true;
            }
            temp = temp.succ;
        }
        if (found) {
            lista.delete(findeOne);
            lista.insertFirst(findeOne.element);
        }
        System.out.println(lista);
    }
}
