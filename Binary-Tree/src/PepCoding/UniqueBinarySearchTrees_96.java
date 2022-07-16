public class UniqueBinarySearchTrees_96{

    static int total=0;
    public static void main(String[] args){
        int n=4;
        Integer[] memo=new Integer[n+1];
        System.out.println(uniqueBST(n));
    }

    //Recursive ::
    //Time Complexity  :
    //Space Compleixty :
    public static int uniqueSearchBinaryTree(int n){
        if(n==0 || n==1) return 1;
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=uniqueSearchBinaryTree(i-1)*uniqueSearchBinaryTree(n-i);
        }
        return sum;
    }

    //Memoizaition:
    //Time Complexity:
    //Space Complexity:
    public static int uniqueBinarySearchTreeMemo(int n,Integer[] memo){
        if(n==0 || n==1) return 1;
        if(memo[n]!=null) return memo[n];
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=uniqueBinarySearchTreeMemo(i-1,memo)*uniqueBinarySearchTreeMemo(n-i,memo);
        }
        memo[n]=sum;
        return sum;
    }

    public static int uniqueBST(int n){
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[dp.length-1];
    }
}
