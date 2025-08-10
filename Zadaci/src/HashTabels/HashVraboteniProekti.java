package HashTabels;

import java.util.Scanner;

public class HashVraboteniProekti {

// Овде креирајте ги помошните класи за клуч и вредност
// Исполнете ги барањата од текстот за toString методите
// Дополнително осигурете се дека вашата клуч класа ќе ги имплементира потребните
// hashCode и equals методи

    static class Person implements Comparable<Person> {
        // поставете ги потребните полиња овде
   String name;
   int age;

        // имплементирајте соодветен конструктор
        Person(String name, int age) {
        this.name = name;
        this.age = age;
        }

        @Override
        public String toString() {
          return "<"+name+", "+age+">";
        }


        // имплементирајте ги следните два метоpackage HashTabels;
        //
        //import java.util.Scanner;
        //
        //public class HashVraboteniProekti {
        //
        //// Овде креирајте ги помошните класи за клуч и вредност
        //// Исполнете ги барањата од текстот за toString методите
        //// Дополнително осигурете се дека вашата клуч класа ќе ги имплементира потребните
        //// hashCode и equals методи
        //
        //    static class Person implements Comparable<Person> {
        //        // поставете ги потребните полиња овде
        //   String name;
        //   int age;
        //
        //        // имплементирајте соодветен конструктор
        //        Person(String name, int age) {
        //        this.name = name;
        //        this.age = age;
        //        }
        //
        //        @Override
        //        public String toString() {
        //          return "<"+name+", "+age+">";
        //        }
        //
        //
        //        // имплементирајте ги следните два методи за да работи табелата правилно
        //        @Override
        //        public boolean equals(Object o) {
        //        return o instanceof Person && name.equals(((Person) o).name) && age == ((Person) o).age;
        //        }
        //        @Override
        //        public int hashCode() {
        //            int numAge = age;
        //            int numAtStr = name.charAt(0);
        //            return numAge * numAtStr;
        //        }
        //
        //        public int compareTo(Person other) {
        //            // First compare names
        //            int nameCompare = this.name.compareTo(other.name);
        //            if (nameCompare != 0) {
        //                return nameCompare;
        //            }
        //            // If names are equal, compare ages
        //            return Integer.compare(this.age, other.age);
        //        }
        //    }
        //
        //   static class Project {
        //        int workingTime ;
        //        int payPerHour;
        //
        //        Project(int workingTime, int payPerHour) {
        //        this.workingTime = workingTime;
        //        this.payPerHour = payPerHour;
        //        }
        //
        //        int paycheck(){
        //            return workingTime * payPerHour;
        //        }
        //
        //
        //        @Override
        //        public String toString() {
        //            return "<"+workingTime+", "+payPerHour+">";
        //        }
        //    }
        //
        //        public static void main(String[] args) {
        //            Scanner in = new Scanner(System.in);
        //            int n = in.nextInt();
        //            // Креирајте ја табелата според барањата
        //            CBHT<Person,Project> table = new CBHT<>(10);
        //            in.nextLine();
        //            // Прочитајте ги податоците од влезот и пополнете ја табелата
        //            for (int i = 0; i < n; i++) {
        //                String[] parts = in.nextLine().split(" ");
        //                String name = parts[0];
        //                int age = Integer.parseInt(parts[1]);
        //                int workingTime = Integer.parseInt(parts[2]);
        //                int payPerHours = Integer.parseInt(parts[3]);
        //                Person person = new Person(name , age);
        //                Project project = new Project(workingTime , payPerHours);
        //                SLLNode<MapEntry<Person,Project>> node = table.search(person);
        //                Project currentProject ;
        //                if (node == null) {
        //                    currentProject = null;
        //                }else {
        //                    currentProject=node.element.value;
        //                }
        //                if (currentProject == null|| project.paycheck()> currentProject.paycheck()){
        //                  table.insert(person, project);
        //                }
        //
        //            }
        //
        //            // отпечатете ја вашата табела
        //            System.out.println(table);
        //        }
        //    }ди за да работи табелата правилно
        @Override
        public boolean equals(Object o) {
        return o instanceof Person && name.equals(((Person) o).name) && age == ((Person) o).age;
        }
        @Override
        public int hashCode() {
            int numAge = age;
            int numAtStr = name.charAt(0);
            return numAge * numAtStr;
        }

        public int compareTo(Person other) {
            // First compare names
            int nameCompare = this.name.compareTo(other.name);
            if (nameCompare != 0) {
                return nameCompare;
            }
            // If names are equal, compare ages
            return Integer.compare(this.age, other.age);
        }
    }

   static class Project {
        int workingTime ;
        int payPerHour;

        Project(int workingTime, int payPerHour) {
        this.workingTime = workingTime;
        this.payPerHour = payPerHour;
        }

        int paycheck(){
            return workingTime * payPerHour;
        }


        @Override
        public String toString() {
            return "<"+workingTime+", "+payPerHour+">";
        }
    }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            // Креирајте ја табелата според барањата
            CBHT<Person,Project> table = new CBHT<>(10);
            in.nextLine();
            // Прочитајте ги податоците од влезот и пополнете ја табелата
            for (int i = 0; i < n; i++) {
                String[] parts = in.nextLine().split(" ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                int workingTime = Integer.parseInt(parts[2]);
                int payPerHours = Integer.parseInt(parts[3]);
                Person person = new Person(name , age);
                Project project = new Project(workingTime , payPerHours);
                SLLNode<MapEntry<Person,Project>> node = table.search(person);
                Project currentProject ;
                if (node == null) {
                    currentProject = null;
                }else {
                    currentProject=node.element.value;
                }
                if (currentProject == null|| project.paycheck()> currentProject.paycheck()){
                  table.insert(person, project);
                }

            }

            // отпечатете ја вашата табела
            System.out.println(table);
        }
    }

