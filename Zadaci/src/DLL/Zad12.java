package DLL;

import java.util.Scanner;

public class Zad12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextInt());
        }
        int M = sc.nextInt();
        System.out.println(lista);
        findAndPutOnBegining(lista,M);
        System.out.println(lista);
    }
    public static void findAndPutOnBegining(DLL<Integer> list, int M) {
        DLLNode<Integer> temp = list.getFirst();
        for (int i = 0; i < M; i++) {
            list.insertLast(temp.element);
            list.delete(temp);
            temp=temp.succ;
        }
    }
}
