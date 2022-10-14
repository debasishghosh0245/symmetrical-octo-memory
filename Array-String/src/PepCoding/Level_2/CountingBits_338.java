import java.util.*;
public class CountingBits_338{
    public static void main(String[] args){
        int n=5;
        System.out.println(Arrays.toString(countingBitsDP(n)));
    }

    public static int countingBits(int n){
        if(n==0) return 0;
        if(n%2==0) return countingBits(n/2);
        else return 1+countingBits(n/2);
    }

    public static int[] countingBitsDP(int n){
        int[] dp=new int[n+1];
        for(int i=0;i<dp.length;i++){
            if(i==0){
                dp[0]=0;
            }else{
                if(i%2==0) {
                    dp[i]=dp[i/2];
                }
                else {
                    dp[i]=1+dp[i/2];
                }
            }
        }
        return dp;
    }
}
