//package HashTabels;
//import java.util.*;
//class SLL<E> {
//    private HashTabels.OBHT.SLLNode<E> first;
//
//    public SLL() {
//        // Construct an empty SLL
//        this.first = null;
//    }
//
//    public void deleteList() {
//        first = null;
//    }
//
//    public int size() {
//        int listSize = 0;
//        HashTabels.OBHT.SLLNode<E> tmp = first;
//        while(tmp != null) {
//            listSize++;
//            tmp = tmp.succ;
//        }
//        return listSize;
//    }
//
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            HashTabels.OBHT.SLLNode<E> tmp = first;
//            ret += tmp.element;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += "->" + tmp.element;
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
//    }
//
//    public void insertFirst(E o) {
//        HashTabels.OBHT.SLLNode<E> ins = new HashTabels.OBHT.SLLNode<E>(o, null);
//        ins.succ = first;
//        //HashTabels.OBHT.SLLNode<E> ins = new HashTabels.OBHT.SLLNode<E>(o, first);
//        first = ins;
//    }
//
//    public void insertAfter(E o, HashTabels.OBHT.SLLNode<E> node) {
//        if (node != null) {
//            HashTabels.OBHT.SLLNode<E> ins = new HashTabels.OBHT.SLLNode<E>(o, node.succ);
//            node.succ = ins;
//        } else {
//            System.out.println("Dadenot jazol e null");
//        }
//    }
//    public void insertBefore(E o, HashTabels.OBHT.SLLNode<E> before) {
//
//        if (first != null) {
//            HashTabels.OBHT.SLLNode<E> tmp = first;
//            if(first==before){
//                this.insertFirst(o);
//                return;
//            }
//            //ako first!=before
//            while (tmp.succ != before && tmp.succ!=null)
//                tmp = tmp.succ;
//            if (tmp.succ == before) {
//                tmp.succ = new HashTabels.OBHT.SLLNode<E>(o, before);;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//    }
//
//    public void insertLast(E o) {
//        if (first != null) {
//            HashTabels.OBHT.SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            tmp.succ = new HashTabels.OBHT.SLLNode<E>(o, null);
//        } else {
//            insertFirst(o);
//        }
//    }
//
//    public E deleteFirst() {
//        if (first != null) {
//            HashTabels.OBHT.SLLNode<E> tmp = first;
//            first = first.succ;
//            return tmp.element;
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//    }
//
//    public E delete(HashTabels.OBHT.SLLNode<E> node) {
//        if (first != null) {
//            HashTabels.OBHT.SLLNode<E> tmp = first;
//            if(first == node) {
//                return this.deleteFirst();
//            }
//            while (tmp.succ != node && tmp.succ.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == node) {
//                tmp.succ = tmp.succ.succ;
//                return node.element;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//                return null;
//            }
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//
//    }
//
//    public HashTabels.OBHT.SLLNode<E> getFirst() {
//        return first;
//    }
//
//    public HashTabels.OBHT.SLLNode<E> find(E o) {
//        if (first != null) {
//            HashTabels.OBHT.SLLNode<E> tmp = first;
//            while (!tmp.element.equals(o) && tmp.succ != null)
//                tmp = tmp.succ;
//            if (tmp.element.equals(o)) {
//                return tmp;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//        return null;
//    }
//
//    public void merge (SLL<E> in){
//        if (first != null) {
//            HashTabels.OBHT.SLLNode<E> tmp = first;
//            while(tmp.succ != null)
//                tmp = tmp.succ;
//            tmp.succ = in.getFirst();
//        }
//        else{
//            first = in.getFirst();
//        }
//    }
//
//    public void mirror() {
//        if (first != null) {
//            //m=nextsucc, p=tmp,q=next
//            HashTabels.OBHT.SLLNode<E> tmp = first;
//            HashTabels.OBHT.SLLNode<E> newsucc = null;
//            HashTabels.OBHT.SLLNode<E> next;
//
//            while(tmp != null){
//                next = tmp.succ;
//                tmp.succ = newsucc;
//                newsucc = tmp;
//                tmp = next;
//            }
//            first = newsucc;
//        }
//    }
//}
//
//
//class SLLNode<E> {
//    protected E element;
//    protected HashTabels.OBHT.SLLNode<E> succ;
//
//    public SLLNode(E elem, HashTabels.OBHT.SLLNode<E> succ) {
//        this.element = elem;
//        this.succ = succ;
//    }
//
//    public E getElement() {
//        return element;
//    }
//
//    public HashTabels.OBHT.SLLNode<E> getSucc() {
//        return succ;
//    }
//
//
//}
//
//public class NewSLLAzer{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        SLL<String> list = new SLL<>();
//        int n = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < n; i++) {
//            list.insertLast(sc.nextLine());
//        }
//        int m = sc.nextInt();
//        System.out.println(list);
//        listCheckWord(list , m);
//    }
//    public static void listCheckWord(SLL<String> list , int m) {
//        HashTabels.OBHT.SLLNode<String> tmp = list.getFirst();
//        while (tmp != null) {
//            if (tmp.element.length()<m){
//                list.delete(tmp);
//            }
//            tmp = tmp.succ;
//        }
//        System.out.println(list);
//    }
//
//}