import java.util.*;
public class PreOrderMorrisTraversalInBinaryTree {
      
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(){};
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        Node(int data) {
            this.data=data;
        }
    }
    
    public static void display(Node node) {
        if (node == null) {
          return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
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

    public static void main(String[] args) throws Exception {
        Integer[] arr={50,25,12,null,null,37,30,null,null,40,null,null,75,
        67,60,null,null,70,null,null,87,null,null,null};
        Node root=construct(arr);
        //display(root);
        List<Integer> list=morrisPreOrderTraversal(root);
        System.out.println(list);
    }
    
    public static List<Integer> morrisPreOrderTraversal(Node root) {
       List<Integer> list=new ArrayList<Integer>();
       Node currentNode=root;
       while(currentNode!=null) {
          Node left=currentNode.left;
          if(left==null) {  
             list.add(currentNode.data); 
             currentNode=currentNode.right;   
          }else{
             Node rightMostNode=getRightMostNode(left,currentNode);
             if(rightMostNode.right==null){
                 list.add(currentNode.data); 
                 rightMostNode.right=currentNode;
                 currentNode=currentNode.left;
             }
             else{
                 currentNode=currentNode.right; 
             }
          } 
       }
       return list;
    }
    
    public static Node getRightMostNode(Node left,Node currentNode){
        while(left.right!=null && left.right!=currentNode){
             left=left.right;
        }
        return left;
    }
}
