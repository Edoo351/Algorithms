package SLL;
import java.util.*;
public class Zad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<String> lista = new SLL<String>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextLine());
        }
        sc.next();
        int M = sc.nextInt();
        findEqualOneAndAddTarger(lista,M);
    }
    public static void findEqualOneAndAddTarger(SLL<String> lista, int M) {
        SLLNode<String> temp = lista.getFirst();
        while (temp != null) {

            if (temp.element.length()==M){
              lista.insertAfter( "Target" , temp);
            }
            temp=temp.succ;
        }
    }
}