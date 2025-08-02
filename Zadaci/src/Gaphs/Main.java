package Gaphs;

public class Main {
    public static void main(String[] args) {
//        Graph EdisGraph = new Graph();
//        EdisGraph.addVertex("E");
//        EdisGraph.addVertex("D");
//        EdisGraph.addVertex("I");
//        EdisGraph.addVertex("N");
//        EdisGraph.addEdge("E" , "D");
//        EdisGraph.addEdge("E" , "I");
//        EdisGraph.addEdge("D" , "I");
//        EdisGraph.printGraph();
//        EdisGraph.removeVertex("E","D");
//        EdisGraph.printGraph();

        Graph myGraph=new Graph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A","B");
        myGraph.addEdge("A","C");
        myGraph.addEdge("A","D");
        myGraph.addEdge("B","D");
        myGraph.addEdge("C","D");
        System.out.println("\n");
        myGraph.printGraph();
        myGraph.removeVertex("D");
        myGraph.printGraph();
    }
}
