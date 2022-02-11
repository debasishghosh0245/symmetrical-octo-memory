import java.io.*;
import java.util.*;
public class IsABinarySearchTree {
    
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
       }
    }
    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
                top.node.left = new Node(arr[idx], null, null);
                Pair lp = new Pair(top.node.left, 1);
            st.push(lp);
            } else {
                top.node.left = null;
            }
            top.state++;
        } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
                top.node.right = new Node(arr[idx], null, null);
                Pair rp = new Pair(top.node.right, 1);
                st.push(rp);
            } else {
                top.node.right = null;
            }
            top.state++;
        } else {
            st.pop();
        }
    }
        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "null" : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "null" : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) throws Exception {
       
        Integer[] arr={5,1,null,null,7,6,null,null,8,null,null};
        Node root = construct(arr);
        //display(root);
        isBinarySearchTree(root);
        System.out.println("Validate Binary Search Tree >> "+isbinarysearchtree);
    }
    
    public static Node isBinarySearchTree(Node root){
        
        if(root==null) return null;
        
        if(root.left==null || root.right==null) return null;
      
        Node leftnode=null;
        Node rightnode=null;
        
        if(null!=root && root.left!=null ) {
            leftnode=isBinarySearchTree(root.left);
        }
        if(null!=root && root.right!=null) {
            rightnode=isBinarySearchTree(root.left);
        }
        
        System.out.println("root data >> "+root.data);
        System.out.println("left node data >> "+leftnode.data);
        System.out.println("right node data >> "+rightnode.data);
        
        if(leftnode!=null && root.data < leftnode.data ) {
            isbinarysearchtree=false;
            return root;
        }
        
        if(rightnode!=null &&  root.data > rightnode.data) {
           
            isbinarysearchtree=false;
            return root;
        }
        
        return root;
    }
    
    
}