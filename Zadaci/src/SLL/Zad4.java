package SLL;
import java.util.*;
public class Zad4 {
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
        findLargerThanL(lista,M);
        System.out.println(lista);
    }
    public static void findLargerThanL(SLL<String> lista, int M) {
        SLLNode<String> temp = lista.getFirst();
        while (temp != null) {
            if (temp.element.length()>M){
                lista.insertBefore("Outlier",temp);
            }
            temp=temp.succ;
        }
    }
}
