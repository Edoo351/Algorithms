package DLL;
import java.util.Scanner;

public class Zad12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL<Integer> lista = new DLL<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }
        countaverageLeftAndRight(lista);
    }
    public static void countaverageLeftAndRight(DLL<Integer> lista) {
        DLLNode<Integer> temp = lista.getFirst();
        int counter = 0;
        while (temp != null) {
            DLLNode<Integer> left = lista.getFirst();
            double counterLeft =0;
            double sumLeft = 0;
            while (left != temp) {
                counterLeft++;
                sumLeft += left.element;
                left = left.succ;
            }
            double leftAverage = counterLeft > 0 ? sumLeft / counterLeft : 0;
            DLLNode<Integer> right = temp.succ;

            double counterRight =0;
            double sumRight = 0;
            while (right != null) {
                counterRight++;
                sumRight += right.element;
                right = right.succ;
            }
            double rightAverage = counterRight > 0 ? sumRight / counterRight : 0;
            if (rightAverage>0 &&leftAverage> rightAverage){
                counter++;
            }
            temp = temp.succ;
        }
        System.out.println(counter);

    }

}