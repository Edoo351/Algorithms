package HashTabels;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTableProekti1 {
    static class People implements Comparable<People> {
        String name;
        String surname;
        int budget;
        String ipAdres;
        String vreme;
        String grad;
        int cena;

        People(String name, String surname, int budget, String ipAdres, String vreme, String grad, int cena) {
            this.name = name;
            this.surname = surname;
            this.budget = budget;
            this.ipAdres = ipAdres;
            this.vreme = vreme;
            this.grad = grad;
            this.cena = cena;
        }

        public String toString() {
            return name +" "+ surname+ " with salary " + budget + " form address " + ipAdres +" who spent "+ cena +"\n";
        }

        public int hashCode() {
            return grad.hashCode();
        }

        public int compareTo(People o) {
            int cmp = grad.compareTo(o.grad);
            if (cmp == 0) {
                cmp = name.compareTo(o.name);
            }
            if (cmp == 0) {
                cmp = surname.compareTo(o.surname);
            }
            return cmp;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CBHT<People, String> lista = new CBHT<>(10);
        ArrayList<People> peopleList = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();  // consume newline after n

        for (int i = 0; i < n; i++) {
            String string = sc.nextLine();
            String[] split = string.split("\\s+");
            String name = split[0];
            String surname = split[1];
            int budget = Integer.parseInt(split[2]);
            String ipAdres = split[3];
            String vreme = split[4];
            String grad = split[5];
            int cena = Integer.parseInt(split[6]);
            People p = new People(name, surname, budget, ipAdres, vreme, grad, cena);
            lista.insert(p, name);
            peopleList.add(p);
        }

        int m = sc.nextInt();
        sc.nextLine();  // consume newline after m

        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] split = line.split("\\s+");
            String testCity = split[5]; // city is at index 5

            int count = 0;
            People richest = null;

            for (People person : peopleList) {
                if (person.grad.equals(testCity)) {
                    if (person.budget >= person.cena) {
                        count++;
                        if (richest == null || person.cena > richest.cena) {
                            richest = person;
                        }
                    }
                }
            }
            System.out.println("City: "+ richest.grad+ " has the following number of customers:");
            System.out.println(count);
            System.out.println("The user who spent the most purchasing for that city is:");
            System.out.println(richest);
        }
    }
}
