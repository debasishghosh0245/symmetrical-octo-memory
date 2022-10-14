public class LongestUnivaluePath_687{
    TreeNode root;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
        public String toString(){
            return this.val+" ";
        }
    }
    static int idx=0;
    public static TreeNode buildTree(Integer[] nums){
        if(idx > nums.length) return null;
        if(nums[idx]==null) {
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(nums[idx++]);
        root.left=buildTree(nums);
        root.right=buildTree(nums);
        return root;
    }
    public static void display(TreeNode root){
        if(root==null) return;
        StringBuilder sb=new StringBuilder();
        sb.append(root.left==null ? "-" :root.left.val);
        sb.append(" < "+root.val+" > ");
        sb.append(root.right==null ? "-" : root.right.val);
        System.out.println(sb);
        display(root.left);
        display(root.right);
    }
    public static class Pair{
        int longestUnivalPath;
        int heightOfUnivalPath;
        TreeNode uniValueNode;
        Pair(){}
        Pair(int longestUnivalPath,int heightOfUnivalPath,TreeNode uniValueNode){
            this.longestUnivalPath=longestUnivalPath;
            this.heightOfUnivalPath=heightOfUnivalPath;
            this.uniValueNode=uniValueNode;
        }
    }
    public static Pair longestuniValueNodePath(TreeNode root){
        if(root==null) {
            Pair pair=new Pair(Integer.MIN_VALUE,-1,root);
            return pair;
        }
        Pair left=longestuniValueNodePath(root.left);
        Pair right=longestuniValueNodePath(root.right);
        Pair pair=new Pair();
        pair.uniValueNode=root;
        if(null!=left.uniValueNode && root.val==left.uniValueNode.val
            && null!=right.uniValueNode && root.val==right.uniValueNode.val){
            pair.heightOfUnivalPath=1+Math.max(left.heightOfUnivalPath,
                right.heightOfUnivalPath);
            int currLongestUnivalPath=2+left.heightOfUnivalPath+
                right.heightOfUnivalPath;
            pair.longestUnivalPath=Math.max(currLongestUnivalPath,
                pair.longestUnivalPath);
        }
        else if(null!=right.uniValueNode
            && root.val==right.uniValueNode.val){
            pair.heightOfUnivalPath=1+right.heightOfUnivalPath;
            pair.longestUnivalPath=Math.max(pair.heightOfUnivalPath,
                pair.longestUnivalPath);
        }
        else if(null!=left.uniValueNode
            && root.val==left.uniValueNode.val){
            pair.heightOfUnivalPath=1+left.heightOfUnivalPath;
            pair.longestUnivalPath=Math.max(pair.heightOfUnivalPath,
            pair.longestUnivalPath);
        }
        pair.longestUnivalPath=Math.max(Math.max(left.longestUnivalPath,
        right.longestUnivalPath),pair.longestUnivalPath);
        return pair;
    }
    public static void main(String[] args){
        Integer[] nums={5,4,1,null,null,1,null,null,5,null,5,null,null};
        //Integer[] nums={1,4,4,null,null,4,null,null,5,null,5,null,null};
        TreeNode root=buildTree(nums);
        //display(root);
        Pair pair=longestuniValueNodePath(root);
        System.out.println(pair.longestUnivalPath);
    }
}
