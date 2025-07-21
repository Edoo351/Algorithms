package DLL;
import java.util.*;
public class Zad9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            list.insertLast(sc.nextInt());
        }
        int S = sc.nextInt();
        int P = sc.nextInt();
        System.out.println(list);
        findAndShiftItLeft(list,S,P);
        System.out.println(list);
    }
    public static void findAndShiftItLeft(DLL<Integer> list, int S, int P) {
        DLLNode<Integer> temp = list.getFirst();
        DLLNode<Integer> save = list.getFirst();
        boolean found = false;
        boolean count = false;
        int counter = 0;
        while (temp != null) {
            if (temp.element == S){
                count=true;
                save = temp;
                list.delete(temp);
                for (int i = 0; i < P; i++) {
                    temp=temp.pred;
                    if (temp==null){
                        temp=list.getLast();
                        found=true;
                    }
                }
                if (found){
                    list.insertAfter(save.element,temp);
                    break;
                }else {
                    list.insertBefore(save.element, temp);
                    break;
                }
            }
            temp=temp.succ;
        }
        if (!count){
            System.out.println("Elementot ne postoi vo listata");
        }
    }
}
