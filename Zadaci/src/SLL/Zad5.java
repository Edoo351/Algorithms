package SLL;
import java.util.*;
public class Zad5 {
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
        findAndPutOnEnd(lista,M , N);
    }

    public static void findAndPutOnEnd(SLL<String> lista, int M ,int N) {
        SLLNode<String> temp = lista.getFirst();
        SLL<String> tempLista = new SLL<String>();
        while (temp != null) {
            if (temp.element.length()==M){
                tempLista.insertLast(temp.element);
                lista.delete(temp);
            }
            temp=temp.succ;
        }
        if (tempLista.size()!=0) {
            System.out.println(lista + "->" + tempLista);
        }else {
            System.out.println(lista);
        }
    }
}
