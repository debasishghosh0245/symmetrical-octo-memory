import java.util.*;
public class LevelOrderLinewiseZigZag {
	
	public static class TreeNode {
		int data;
		ArrayList<TreeNode> children=new ArrayList<>(); 
		TreeNode(){}
		TreeNode(int data){
			this.data=data;
		}
	}
	
	public static void display(TreeNode root) {
		System.out.print(root.data+" -> ");
		for(TreeNode child: root.children){
			System.out.print(child.data+" ");
		}
		System.out.println();
		for(TreeNode child : root.children){
			display(child);
		}
	}
	
	public static TreeNode construct(int[] arr){
		Stack<TreeNode> stack=new Stack<>();
		TreeNode root=new TreeNode(arr[0]);
		stack.push(root);
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==-1){
				if(!stack.isEmpty()){
					stack.pop();
				}
			}
			else {
				TreeNode node=stack.peek();
				TreeNode newNode=new TreeNode(arr[i]);
				node.children.add(newNode);
				stack.push(newNode);
			}
		}
		return root;
	}
	
	public static void levelOrderTraversal(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);
		boolean odd=true;
		while(!stack.isEmpty()){
			int level=stack.size();
			for(int i=0;i<level;i++){
				TreeNode node=stack.pop();
				System.out.print(node.data+" ");
				if(odd){
					for(TreeNode child: node.children){
						stack.push(child);
					}
				}else{
					for(int j=node.children.size()-1;j>=0;j--){
						stack.push(node.children.get(j));
					}
				}
			}
			odd=(odd==true) ? false : true;
			System.out.println();
		}
	}
	
	public static void levelOrderTraversalII(TreeNode root){
		Queue<TreeNode> mainQueue=new ArrayDeque<>();
		Queue<TreeNode> childQueue=new ArrayDeque<>();
		mainQueue.add(root);
		while(!mainQueue.isEmpty()){
			TreeNode node=mainQueue.remove();
			System.out.print(node.data+" ");
			for(TreeNode child: node.children){
				childQueue.add(child);
			}
			if(mainQueue.isEmpty()){
				System.out.println(" ");
				while(!childQueue.isEmpty()){
					mainQueue.add(childQueue.remove());
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,
		120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		TreeNode node=construct(arr);
		levelOrderTraversal(node);			
	}
	
}