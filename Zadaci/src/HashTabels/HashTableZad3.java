package HashTabels;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTableZad3 {
    static class Person implements Comparable<Person> {
        String name;
        String surname;
        int budget;
        String ipAdress;
        int saat;
        int minutes;
        String grad;
        int cena;
        Person(String name, String surname, int budget, String ipAdress, int saat,int minutes, String grad , int cena) {
            this.name = name;
            this.surname = surname;
            this.budget = budget;
            this.ipAdress = ipAdress;
            this.saat = saat;
            this.minutes = minutes;
            this.grad = grad;
            this.cena = cena;
        }
        @Override
        public String toString() {
            return String.format("%s %s with salary %d from address %s who logged in at %02d:%02d\n",
                    name, surname, budget, ipAdress, saat, minutes);
        }


        @Override
        public int hashCode() {
            return grad.hashCode();
        }
        public boolean equals(Person person) {
            return name.equals(person.name)&&surname.equals(person.surname);
        }

        @Override
        public int compareTo(Person o) {
            int cmp = grad.compareTo(o.grad);     // Compare by city
            if (cmp == 0) cmp = name.compareTo(o.name);     // Compare by name
            if (cmp == 0) cmp = surname.compareTo(o.surname); // Compare by surname
            return cmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CBHT<Person,String> lista =new CBHT<>(10);
        ArrayList<Person> persons = new ArrayList<Person>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String string = sc.nextLine();
            String[] split = string.split("\\s+");
            String name = split[0];
            String surname = split[1];
            int budget = Integer.parseInt(split[2]);
            String ipAdress = split[3];
            String[] parts = split[4].split(":");
            int[] vreme = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                vreme[j] = Integer.parseInt(parts[j]);
            }
            String grad = split[5];
            int cena = Integer.parseInt(split[6]);
            Person person = new Person(name, surname, budget, ipAdress, vreme[0] , vreme[1] , grad, cena);
            lista.insert(person,name);
            persons.add(person);
        }
        int m = sc.nextInt();
        sc.nextLine();
        int counter = 0;
        for (int i = 0; i < m; i++) {
            counter=0;
            Person latest = null;
            String string = sc.nextLine();
            String[] split = string.split("\\s+");
            String grad = split[5];
            String[] parts = split[4].split(":");
            int[] vreme = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                vreme[j] = Integer.parseInt(parts[j]);
            }
            for (Person person : persons) {
                if (grad.equals(person.grad)) {
                    if (person.saat > 11 || (person.saat == 11 && person.minutes > 59)) {
                    counter++;
                        if (latest == null || person.saat< latest.saat ||
                                (person.saat == latest.saat && person.minutes < latest.minutes)) {
                            latest = person;
                    }
                    }
                }

            }
            System.out.println("City: " + latest.grad +" has the following number of customers: ");
            System.out.println(counter);
            System.out.println("The user who logged on earliest after noon from that city is:");
            System.out.println(latest);
        }
//        System.out.println(lista);

    }

}
