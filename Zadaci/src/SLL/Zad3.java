package SLL;
import java.util.*;
public class Zad3 {
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
        findEqualOneAndAddTarger(lista,M);
        System.out.println(lista);
    }
    public static void findEqualOneAndAddTarger(SLL<String> lista, int M) {
        SLLNode<String> temp = lista.getFirst();
        while (temp != null) {

            if (temp.element.length()==M){
              lista.insertAfter( "Target" , temp);
              temp=temp.succ;
            }
            temp=temp.succ;
        }
    }
}