import java.util.*;
public class RemoveLeavesGenericTree {

	private static class Node{
		int data;
		List<Node> children=new ArrayList<Node>();
		Node(int data){
			this.data=data;
		}
	}
	
	public static void display(Node node){
		String str=node.data+"-->>";
		for(Node child:node.children){
			str=str+" "+child.data;
		}
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}
	
	public static void main(String[] args){
		int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1 
        ,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=null;
		root=construct(root,arr);
        removeLeaf(root);
        display(root);
	}
	
	public static Node construct(Node root,int[] arr) {
		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node(arr[i]);
				if (st.size() > 0) {
					st.peek().children.add(t);
				} else {
					root = t;
				}
				st.push(t);
			}
		}
		return root;
	}
   
    public static void removeLeaf(Node root){
        for(int i=0;i<=root.children.size()-1;i++){
           Node child=root.children.get(i);
           if(child.children.size()==0){
               root.children.remove(child);
           } 
        }
        for(Node child: root.children) {
            removeLeaf(child);
        }
    }
}
