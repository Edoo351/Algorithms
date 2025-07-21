package DLL;
import java.util.*;
public class Zad10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextInt());
        }
        int F = sc.nextInt();
        int P = sc.nextInt();
        System.out.println(lista);
        findAndShiftToLeft(lista , F , P);
        System.out.println(lista);
    }
    public static void findAndShiftToLeft(DLL<Integer> lista , int F , int P) {
        DLLNode<Integer> temp = lista.getFirst();
        DLLNode<Integer> save = null;
        boolean found = false;
        boolean print = false;
        while (temp != null) {
            if (temp.element==F){
                print = true;
                save = temp;
                lista.delete(temp);
                for (int i = 0; i < P; i++) {
                    temp=temp.succ;
                    if (temp==null){
                        found = true;
                        temp=lista.getFirst();
                    }
                }
                if (!found){
                    lista.insertAfter(save.element,temp);
                    break;
                }else {
                    lista.insertBefore(save.element,temp);
                    break;
                }

            }

            temp=temp.succ;
        }
        if (!print){
            System.out.println("Elementot ne postoi vo listata");
        }
    }
}
