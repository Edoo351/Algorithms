package HashTabels;

import java.util.ArrayList;
import java.util.Scanner;

public class HashTabeliZad5 {
    static  class Person implements Comparable<Person> {
        String name;
        String surname;
        int budget;
        String ipAdress;
        int saat;
        int min;
        String grad;
        int cena;

        Person(String name, String surname, int budget, String ipAdress, int saat, int min, String grad, int cena) {
            this.name = name;
            this.surname = surname;
            this.budget = budget;
            this.ipAdress = ipAdress;
            this.saat = saat;
            this.min = min;
            this.grad = grad;
            this.cena = cena;
        }

        @Override
        public int hashCode() {
            String[] parts = ipAdress.split("\\.");
            String hash = parts[0] +"."+parts[1]+"."+parts[2];
            return hash.hashCode();
        }

        @Override
        public String toString() {
            return name+" "+surname+" with salary "+budget+" from address "+ipAdress+" who spent "+cena;
        }
        public int compareTo(Person o) {
            return name.compareTo(o.name);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> listPerson = new ArrayList<Person>();
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<Person,String> hashtabela= new CBHT<Person, String>(2*n);
        for (int i = 0; i < n; i++) {
            String string = sc.nextLine();
            String[] parts = string.split("\\s+");
            String name = parts[0];
            String surname = parts[1];
            int budget = Integer.parseInt(parts[2]);
            String ipAdress = parts[3];
            String[] parts2 = parts[4].split(":");
            int[] vreme = new int[parts2.length];
            for (int j=0 ; j<vreme.length; j++) {
                vreme[j] = Integer.parseInt(parts2[j]);
            }
            String grad = parts[5];
            int cena = Integer.parseInt(parts[6]);
            Person person = new Person(name,surname,budget,ipAdress,vreme[0],vreme[1],grad,cena);
            listPerson.add(person);
            hashtabela.insert(person,name);
        }
        int m= sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String string = sc.nextLine();
            String[] parts = string.split("\\s+");
            String ipAdress = parts[3];
            String[] parts2 = parts[3].split("\\.");
            String has = parts2[0]+"."+parts2[1]+"."+parts2[2];
            int network =has.hashCode();
            Person rich = null;
            int counter=0;
            for (Person person : listPerson) {
                String[] parts3 = person.ipAdress.split("\\.");
                String perNet = parts3[0]+"."+parts3[1]+"."+parts3[2];
               int newIp= perNet.hashCode();
                if (newIp == network && person.budget>=person.cena){
                    counter++;
                    if (rich == null || person.cena>rich.cena){
                        rich = person;
                    }
                }
            }
            System.out.println("IP network: "+has+" has the following number of users:");
            System.out.println(counter);
            System.out.println("The user who spent the most from that network is:");
            System.out.println(rich);
        }

    }

}
