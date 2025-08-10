package HashTabels;

import java.util.Scanner;

public class TeatarskiKarti {
    static class People implements Comparable<People> {
        String name;
        String surname;
        String city;
        People(String name, String surname
        , String city) {
            this.name = name;
            this.surname = surname;
            this.city = city;
        }

        public String toString(){
            return name + " " + surname;
        }
        public int compareTo(People o) {
            return name.compareTo(o.name);
        }
        public int hashCode() {
            return city.charAt(0);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof People)) return false;
            People other = (People) obj;
            return name.equals(other.name) &&
                    surname.equals(other.surname) &&
                    city.equals(other.city);
        }


        public String getCity() {
            return city;
        }
    }

   static class City{
        int budget;
        String ipAdres;
        String vreme;
        int cena;
        City(int budget, String ipAdres, String vreme , int cena){
            this.budget = budget;
            this.ipAdres = ipAdres;
            this.vreme = vreme;
            this.cena = cena;
        }
        public String toString(){
            return budget + " " + ipAdres + " " + vreme + " ";
        }
        public int getBudget(){
            return budget;
        }
        public int getCena(){
            return cena;
        }

   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Fix: consume leftover newline

        CBHT<People, City> lista = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String name = parts[0];
            String surname = parts[1];
            int budget = Integer.parseInt(parts[2]);
            String ipAdres = parts[3];
            String vreme = parts[4];
            String city = parts[5];
            int cena = Integer.parseInt(parts[6]);
            People p = new People(name, surname, city);
            City c = new City(budget, ipAdres, vreme, cena);
            lista.insert(p, c);
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");

            String name = parts[0];
            String surname = parts[1];
            int budget = Integer.parseInt(parts[2]);
            String ipAdres = parts[3];
            String vreme = parts[4];
            String city = parts[5];
            int cena = Integer.parseInt(parts[6]);

            People p = new People(name, surname, city);
            City c = new City(budget, ipAdres, vreme, cena);

            SLLNode<MapEntry<People, City>> node = lista.search(p);
            City currentCity = (node == null) ? null : node.element.value;

            if (currentCity == null) {
                System.out.println("No record found for " + p);
            } else if (currentCity.getBudget() > c.getCena()) {
                System.out.println("OK: " + currentCity);
            } else {
                System.out.println("NOT ENOUGH BUDGET: " + currentCity);
            }
        }
    }
    }
