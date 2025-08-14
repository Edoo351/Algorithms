package RecursiveTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTree {

        public Node root;

        public static class Node {
            public int value;
            public Node left;
            public Node right;

            private Node(int value) {
                this.value = value;
            }
        }

        public Node getRoot() {
            return root;
        }

        public boolean insert(int value) {
            Node newNode = new Node(value);
            if (root == null) {
                root = newNode;
                return true;
            }
            Node temp = root;
            while (true) {
                if (newNode.value == temp.value) return false;
                if (newNode.value < temp.value) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return true;
                    }
                    temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return true;
                    }
                    temp = temp.right;
                }
            }
        }

        public ArrayList<Integer> DFSInOrder() {
            ArrayList<Integer> results = new ArrayList<>();

            class Traverse {
                Traverse(Node currentNode) {
                    if (currentNode.left != null) {
                        new Traverse(currentNode.left);
                    }
                    results.add(currentNode.value);
                    if (currentNode.right != null) {
                        new Traverse(currentNode.right);
                    }
                }
            }

            new Traverse(root);
            return results;
        }

        //   +===================================================+
        //   |                  WRITE YOUR CODE HERE             |
        //   | Description:                                      |
        //   | - Checks if the binary tree is a valid Binary     |
        //   |   Search Tree (BST).                              |
        //   | - A BST is valid if all nodes follow the left <   |
        //   |   parent < right rule across the entire tree.     |
        //   | - Utilizes in-order traversal to collect node     |
        //   |   values and then checks if the list of values    |
        //   |   is in ascending order without duplicates.       |
        //   |                                                   |
        //   | Return:                                           |
        //   | - Returns true if the tree is a valid BST.        |
        //   | - Returns false otherwise.                        |
        //   |                                                   |
        //   | Tips:                                             |
        //   | - DFSInOrder() is assumed to be a method that     |
        //   |   performs an in-order traversal of the tree and  |
        //   |   returns an ArrayList of node values.            |
        //   | - A valid BST should have its in-order traversal  |
        //   |   result in a strictly ascending order list.      |
        //   +===================================================+
        public boolean isValidBST(){
            ArrayList<Integer> list = DFSInOrder();
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) > list.get(i+1)) {
                    return false;
                }
            }
            return true;
        }
        public Integer kthSmallest(int k) {
            Stack<Node> stack = new Stack<>();
            Node node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                k-=1;
                if (k == 0) {
                    return node.value;
                }
                node = node.right;
            }
            return null;
        }
}
 class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.kthSmallest(1));  // Expected output: 2
        System.out.println(bst.kthSmallest(3));  // Expected output: 4
        System.out.println(bst.kthSmallest(5));  // Expected output: 7

    }

}

