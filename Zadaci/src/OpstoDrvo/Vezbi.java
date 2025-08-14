package OpstoDrvo;

import java.util.*;

public class Vezbi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number of "root"/"add" commands
        int Q = sc.nextInt(); // number of "ask" commands
        sc.nextLine(); // consume newline

        SLLTree<Integer> tree = new SLLTree<>();
        Map<Integer, SLLTree.Node<Integer>> nodeMap = new HashMap<>();

        // Process N+Q lines of input
        for (int i = 0; i < N + Q; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split("\\s+");
            String cmd = tokens[0];

            if (cmd.equals("root")) {
                int rootValue = Integer.parseInt(tokens[1]);
                tree.makeRoot(rootValue);
                nodeMap.put(rootValue, tree.root());
            }
            else if (cmd.equals("add")) {
                int parentValue = Integer.parseInt(tokens[1]);
                int childValue = Integer.parseInt(tokens[2]);
                SLLTree.Node<Integer> parentNode = nodeMap.get(parentValue);
                SLLTree.Node<Integer> childNode = tree.addChild(parentNode, childValue);
                nodeMap.put(childValue, childNode);
            }
            else if (cmd.equals("ask")) {
                int nodeValue = Integer.parseInt(tokens[1]);
                SLLTree.Node<Integer> node = nodeMap.get(nodeValue);
                int leaves = countLeaves(tree, node, nodeMap);
                System.out.println(leaves);
            }
        }
    }

    // Recursively count leaves in the subtree rooted at `node`
    static int countLeaves(SLLTree<Integer> tree, SLLTree.Node<Integer> node, Map<Integer, SLLTree.Node<Integer>> nodeMap) {
        Iterator<Integer> children = tree.children(node); // returns iterator over elements
        if (!children.hasNext()) {
            return 1; // no children → it's a leaf
        }
        int sum = 0;
        while (children.hasNext()) {
            int childValue = children.next();
            SLLTree.Node<Integer> childNode = nodeMap.get(childValue);
            sum += countLeaves(tree, childNode, nodeMap);
        }
        return sum;
    }
}
