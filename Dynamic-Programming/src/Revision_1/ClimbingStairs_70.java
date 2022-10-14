import java.util.*;
public class ClimbingStairs_70{
    public static void main(String[] args){
        System.out.println(climbStairs_DP(3));
    }
    public static int climbStairs_Helper(int n){
        if(n==0) return 1;
        int count=0;
        if(n-1>=0){
            count+=climbStairs_Helper(n-1);
        }
        if(n-2>=0){
            count+=climbStairs_Helper(n-2);
        }
        return count;
    }
    public static int climbStairs_DP(int n){
        int[] dp=new int[n+1];
        for(int i=0;i<dp.length;i++){
            if(i==0) {
                dp[i]=1;
            }else{
                if(i-2>=0){
                    dp[i]=dp[i-1]+dp[i-2];
                }else{
                    dp[i]=dp[i-1];
                }
            }
        }
        return dp[n];
    }
}
