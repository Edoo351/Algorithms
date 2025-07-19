package SLL;
import java.util.*;
import java.util.Scanner;
public class Zad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<String> list = new SLL<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextLine());
        }
        int m = sc.nextInt();
        System.out.println(list);
        checkWorrdsIfAreLarger(list , m);
    }
    private static void checkWorrdsIfAreLarger(SLL<String> list, int m) {
        SLLNode<String> temp = list.getFirst();
        while (temp != null) {
            if (temp.element.length()<m){
                list.delete(temp);
            }
            temp=temp.succ;
        }
        System.out.println(list);
    }
    }
