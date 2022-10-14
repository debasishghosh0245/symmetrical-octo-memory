import java.util.*;
public class CountingBitsDP_338{
    public static void main(String[] args){
        int n=5;
        System.out.println(Arrays.toString(countBit(n)));
    }
    //dp+Least Significant Bits
    public static int[] countingBits(int n){
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i==0){
                dp[0]=0;
            }
            dp[i]=dp[i>>1]+(i&1);
        }
        return dp;
    }
    //Using clear bit
    public static int[] countBit(int n){
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++){
            //clear bit (n & n-1) will clear last bit
            arr[i]=1+arr[n & n-1];
        }
        return arr;
    }
}
