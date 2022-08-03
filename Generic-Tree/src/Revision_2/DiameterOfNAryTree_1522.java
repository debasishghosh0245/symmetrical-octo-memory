import java.util.*;
public class DiameterOfNAryTree_1522{

    public static class TreeNode{
        int val;
        List<TreeNode> children=new ArrayList<>();
        TreeNode(int val){
            this.val=val;
        }
    }
    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx==nums.length) return null;
        TreeNode root=new TreeNode(nums[idx++]);
        while(null!=nums[idx]){
            root.children.add(buildTree(nums));
            idx++;
        }
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.val+">>");
        for(TreeNode child: root.children){
            sb.append(child.val+" ");
        }
        System.out.println(sb);
        for(TreeNode child: root.children){
            display(child);
        }
    }

    public static class Pair{
        int height;
        int maxDiameter;
        Pair(){
        }
        Pair(int height,int maxDiameter){
            this.height=height;
            this.maxDiameter=maxDiameter;
        }
    }

    public static Pair diameter(TreeNode root){
        //base case
        if(root.children.size()==0){
            return new Pair(0,0);
        }
        int maxChildHeight=-1;
        int secondMaxChildHeight=-1;
        System.out.println("Root >>"+root.val);
        for(TreeNode child: root.children){
            Pair childPair=diameter(child);
            int height=childPair.height;
            if(height>maxChildHeight){
                secondMaxChildHeight=maxChildHeight;
                maxChildHeight=height;
            }
            else if(height>secondMaxChildHeight){
               secondMaxChildHeight=height;
            }
            System.out.println("Child Node >> "+child.val);
            System.out.println("Max Child Height >>"+maxChildHeight);
            System.out.println("Second Max Child Height >>"+secondMaxChildHeight);
        }
        Pair pair=new Pair();
        pair.height=1+maxChildHeight;
        int currentDia=2+maxChildHeight+secondMaxChildHeight;
        pair.maxDiameter=Math.max(currentDia,pair.maxDiameter);
        System.out.println("returned height   >>"+pair.height);
        System.out.println("returned diameter >>"+currentDia);
        return pair;
    }

    public static void main(String[] args){
        Integer[] nums={1,3,5,null,6,null,null,2,null,4,null,null};
        //Integer[] nums={3,1,5,null,null,null};
        TreeNode root=buildTree(nums);
        //display(root);
        Pair pair=diameter(root);
        System.out.println("Diameter >> "+pair.maxDiameter);
    }
}
