package BinarnoDrvo;
public class BTreeTest {

    public static void main(String[] args) {
        BNode<Character> a, b, c;
        BTree<Character> tree = new BTree<Character>('Z');
        a = tree.addChild(tree.root, BNode.LEFT, 'D');
        b = tree.addChild(a, BNode.LEFT, 'B');
        c = tree.addChild(b, BNode.LEFT, 'A');
        c = tree.addChild(b, BNode.RIGHT, 'C');
        c = tree.addChild(a, BNode.RIGHT, 'E');
        a = tree.addChild(tree.root, BNode.RIGHT, 'G');
        b = tree.addChild(a, BNode.RIGHT, 'I');
        c = tree.addChild(b, BNode.LEFT, 'H');
        c = tree.addChild(b, BNode.RIGHT, 'O');
        c = tree.addChild(b, BNode.RIGHT, 'G');
        c = tree.addChild(b, BNode.RIGHT, 'M');
        c = tree.addChild(b, BNode.RIGHT, 'Z');
        c = tree.addChild(b, BNode.RIGHT, 'Y');
        c = tree.addChild(b, BNode.RIGHT, 'X');
        c = tree.addChild(b, BNode.LEFT, 'P');
        c = tree.addChild(b, BNode.LEFT, 'L');
        c = tree.addChild(b, BNode.LEFT, 'K');
        c = tree.addChild(b, BNode.LEFT, 'T');
        
        tree.inorder();
        tree.preorder();
        tree.postorder();
        tree.inorderNonRecursive();
        tree.preorderNonRecursive();
        
        System.out.println("Brojot na vnatresni jazli e " + tree.insideNodes());
        System.out.println("Brojot na listovi e " + tree.leaves());
        System.out.println("Dlabocinata na drvoto e " + tree.depth());

        tree.mirror();
        tree.inorder();
    }

}
