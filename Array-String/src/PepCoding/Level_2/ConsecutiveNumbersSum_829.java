import java.util.*;
public class ConsecutiveNumbersSum_829{

    public static void main(String[] args){
        int n=15;
        System.out.println(consecutiveNumsSum(n));
    }

    public static int consecutiveNumsSum(int n){
        int count=1;
        for(int k=2;k<Math.sqrt(2*n);k++){
            if((n-(k*(k-1)/2))%k==0) {
                count++;
            }
        }
        return count;
    }
}
