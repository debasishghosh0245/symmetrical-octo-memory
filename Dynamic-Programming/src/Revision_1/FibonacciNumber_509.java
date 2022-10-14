public class FibonacciNumber_509{

    public static void main(String[] args){
        int n=5;
        System.out.println(tabularCalFib(n));
        // Integer[] memo=new Integer[n+1];
        // for(int i=0;i<n;i++){
        //     System.out.print(calfib(i,memo)+" ");
        // }
    }

    public static int calfib(int n,Integer[] memo){
        if(n==0 || n==1) return n;
        if(memo[n]!=null) return memo[n];
        int result=calfib(n-1,memo)+calfib(n-2,memo);
        memo[n]=result;
        return result;
    }

    public static int tabularCalFib(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
