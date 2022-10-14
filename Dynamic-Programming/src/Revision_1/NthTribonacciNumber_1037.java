public class NthTribonacciNumber_1037{

    public static void main(String[] args){
        int n=4;
        //Integer[] memo=new Integer[n+1];
        System.out.println(caltibonacci_tabulation(n));
    }

    public static int caltibonacci(int n){
        if(n==0 || n==1) return n;
        if(n==2) return 1;
        return caltibonacci(n-1)+caltibonacci(n-2)+caltibonacci(n-3);
    }

    public static int caltibonacci_Memo(int n,Integer[] memo){
        if(n==0 || n==1) return n;
        if(n==2) return 1;
        if(memo[n]!=null) return memo[n];
        int result=caltibonacci(n-1)+caltibonacci(n-2)+caltibonacci(n-3);
        return result;
    }

    public static int caltibonacci_tabulation(int n){
        int[] dp=new int[n+1];
        for(int i=0;i<dp.length;i++){
            if(i==0 || i==1) {
                dp[i]=i;
            }
            else if(i==2) {
                dp[i]=1;
            }else{
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
    }

}
