package DSAProblems.fifth_day;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TopView {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    static class Pair{
        int hd;
        Node node;

        Pair(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair p = queue.remove();

            int hd = p.hd;
            Node tem = p.node;


            if(!map.containsKey(hd)) map.put(hd, tem.data);
            if(tem.left != null) queue.add(new Pair(tem.left, hd-1));
            if(tem.right != null) queue.add(new Pair(tem.right, hd+1));
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}