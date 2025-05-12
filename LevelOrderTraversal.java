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

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
       if (root == null)  return ;

        // Create an empty queue for level order traversal
        Queue<Node> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // Enqueue Root
        que.add(root);
    

        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                // Add front of queue and remove it from queue
                Node node = que.poll();
                level.add(node.data);

                // Enqueue left child
                if (node.left != null)
                    que.add(node.left);

                // Enqueue right child
                if (node.right != null)
                    que.add(node.right);
            }
            
        for(int i = 0;i<level.size();i++){
            System.out.print(level.get(i) + " ");
        }
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
        levelOrder(root);
    }	
}
