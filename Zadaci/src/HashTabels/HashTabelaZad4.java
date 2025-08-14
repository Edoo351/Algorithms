package HashTabels;

import java.util.ArrayList;
import java.util.Scanner;

public class HashTabelaZad4 {
    static class Person implements Comparable<Person> {
        String name;
        String surname;
        int budget;
        String ipAddress;
        String vreme;
        int saat;
        int min;
        String grad;
        int cena;
        Person(String name , String surname, int budget, String ipAddress ,String vreme, int saat,int min, String grad, int cena) {
            this.name = name;
            this.surname = surname;
            this.budget = budget;
            this.ipAddress = ipAddress;
            this.vreme = vreme;
            this.saat = saat;
            this.min = min;
            this.grad = grad;
            this.cena = cena;
        }

        @Override
        public int hashCode() {
            String[] ip = ipAddress.split("\\.");
            String ipa = ip[0]+"."+ ip[1]+"."+ ip[2];
            return ipa.hashCode();
        }
        public String toString() {
           return name + " " + surname +" with salary "+ budget+" from address "+ ipAddress+ " who logged in at " +vreme+"\n";
        }
        public int compareTo(Person o) {
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) {
        CBHT<Person,String> lista = new CBHT<Person, String>(10);
        ArrayList<Person> lista1 = new ArrayList<Person>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] parts = input.split("\\s+");
            String name = parts[0];
            String surname = parts[1];
            int budget = Integer.parseInt(parts[2]);
            String ipAddress = parts[3];
            String vreme = parts[4];
            String[] vremeP = parts[4].split("\\:");
            int saat = Integer.parseInt(vremeP[0]);
            int min= Integer.parseInt(vremeP[1]);;
            String grad = parts[5];
            int cena = Integer.parseInt(parts[6]);
            Person person = new Person(name,surname,budget,ipAddress,vreme,saat,min,grad,cena);
            lista1.add(person);
        }
        int m  = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String input = sc.nextLine();
            String[] parts = input.split("\\s+");
            String[] ipAddress = parts[3].split("\\.");
            String hasIp = ipAddress[0]+"."+ipAddress[1]+"."+ipAddress[2];
            int netIp = hasIp.hashCode();
            Person erliestPerson = null;
            int count = 0;
            for (Person person : lista1) {
                String[] parts1 = person.ipAddress.split("\\.");
                String perNet = parts1[0]+"."+parts1[1]+"."+parts1[2];
                int perNetIp = perNet.hashCode();
                if (perNetIp == netIp&&(person.saat > 11||(person.saat==11 && person.min>59))) {
                    count++;
                    if (erliestPerson == null||erliestPerson.saat>person.saat||(erliestPerson.saat==person.saat&&erliestPerson.min>person.min)) {
                        erliestPerson = person;
                    }
                }
            }
            System.out.println("IP network: "+hasIp+ " has the following number of users: ");
            System.out.println(count);
            System.out.println("The user who logged on earliest after noon from that network is:");
            System.out.println(erliestPerson);
        }
    }
}
