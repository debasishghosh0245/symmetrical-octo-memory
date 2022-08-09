public class UniqueBinarySearchTrees_96{

    public static void main(String[] args){
        int n=5;
        Integer[] memo=new Integer[n+1];
        System.out.println(numTrees(n,memo));
    }
    public static int numTrees(int n,Integer[] memo) {
        if(n<=1) return 1;
        if(memo[n]!=null) return (int)memo[n];
        int total=0;
        for(int i=1;i<=n;i++){
            total+=numTrees(i-1,memo)*numTrees(n-i,memo);
        }
        memo[n]=total;
        return total;
    }
}
