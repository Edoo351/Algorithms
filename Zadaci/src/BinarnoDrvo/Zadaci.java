package BinarnoDrvo;

import OpstoDrvo.SLLTree;
import OpstoDrvo.Tree;

import java.util.*;
public class Zadaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLLTree<String> tree = new SLLTree<>();
        Map<String, Tree.Node<String>> nodees = new HashMap<>();
        int n = sc.nextInt();
        String valueForRoot = sc.next();
        tree.makeRoot(valueForRoot);
        Tree.Node<String> NodeRoot = tree.root();
        nodees.put(valueForRoot,NodeRoot);
        for (int i = 0; i < n-1; i++) {
            String valueForParent = sc.next();
            String valueForChild = sc.next();
            Tree.Node<String> NodeParent = nodees.get(valueForParent);
            Tree.Node<String> NodeChild = tree.addChild(NodeParent,valueForChild);
            nodees.put(valueForChild,NodeChild);
        }
       tree.printTree();
    }
    static final String example_input = "7\nKoren\nKoren A\nKoren B\nA C\nB D\nA E\nC F";
    static final String example_input_2 = "7\nKoren\nKoren Jazol1\nKoren Jazol2\nJazol1 Jazol3\nJazol3 Jazol4\nJazol2 Jazol5\nKoren Jazol6";
}

class task2{
    public static void main(String[] args) {
        BTree<String> tree = new BTree<>();
        tree.makeRoot("Parent");
        BNode<String> root = tree.root;
        BNode<String> left = tree.addChild(root,BNode.LEFT , "Left");
        BNode<String> right = tree.addChild(root,BNode.RIGHT , "Right");
        BNode<String> left_left = tree.addChild(left,BNode.LEFT , "Left_Left");
        BNode<String> left_right = tree.addChild(left,BNode.RIGHT , "Left_Right");
        BNode<String> right_left = tree.addChild(right,BNode.LEFT , "Right_Left");
        BNode<String> right_right = tree.addChild(right,BNode.RIGHT , "Right_Right");
        BNode<String> right_left_left = tree.addChild(right_left,BNode.LEFT , "Right_Left_Left");

        System.out.println("Path to root" + pathToRoot(left_right));
        System.out.println("Path to root" + pathToRoot(right_left));
        System.out.println("Path to root" + pathToRoot(right_left_left));
    }

    static String pathToRoot(BNode<String> node) {
        String path = "";
        while (node != null) {
            path = "<" + node.info + ">" + path;
            node=node.parent;
        }
        return path;
    }
}