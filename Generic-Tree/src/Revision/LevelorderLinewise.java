import java.util.*;
public class LevelorderLinewise {
	
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
		Queue<TreeNode> queue=new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int level=queue.size();
			for(int i=0;i<level;i++){
				TreeNode node=queue.remove();
				System.out.print(node.data+" ");
				for(TreeNode child: node.children){
					queue.add(child);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		int[] arr={10,20,-1,30,50,-1,60,-1,-1,40,-1};
		TreeNode node=construct(arr);
		//display(node);
		levelOrderTraversal(node);
	}
}