package DLL;
import java.util.*;
public class Zad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            list.insertLast(sc.nextInt());
        }
        System.out.println("{"+ list + "}");
        findAndDelete(list);
    }
    public static void findAndDelete(DLL<Integer> list) {
        DLLNode<Integer> temp = list.getFirst();
        int count = 0;
        while (temp != null) {
            count+=temp.element;
            temp=temp.succ;
        }
        count = count / list.getSize();
        DLL<Integer> newList = new DLL<Integer>();
        temp = list.getFirst();
        while (temp != null) {
            if (temp.element==61){
                temp=temp.succ;
                continue;
            }
            if (temp.element>=count){
                newList.insertLast(temp.element);
            }
            temp=temp.succ;
        }
        newList.toString();

        System.out.println("{"+ newList + "}");
    }
}
