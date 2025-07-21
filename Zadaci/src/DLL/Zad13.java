package DLL;
import java.util.*;
public class Zad13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            list.insertLast(sc.nextInt());
        }
        findAvverageAndSeeBeforeAndAfter(list);
    }
    public static void findAvverageAndSeeBeforeAndAfter(DLL<Integer> list) {
        DLLNode<Integer> temp = list.getFirst();
        int counter = 0;
        while (temp != null) {
            DLLNode<Integer> before = list.getFirst();
            double beforeNums = 0;
            double countBefore = 0;
            while (before!=temp){
                countBefore++;
                beforeNums+=before.element;
                before=before.succ;
            }
            double beforeAverage  = countBefore>0 ?  beforeNums/countBefore : 0;
            double afterNums = 0;
            double countAfter = 0;
            DLLNode<Integer> after = temp.succ;
            while (after!=null){
                countAfter++;
                afterNums+=after.element;
                after=after.succ;
            }
            double afterAverage  = countAfter>0 ? afterNums/countAfter :0;
            if (beforeAverage > afterAverage && afterAverage>0 ){
                counter++;
            }
            temp=temp.succ;
        }
        System.out.println(counter);
    }
}
